package uk.police.data.api;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.*;

import org.junit.Test;
import uk.police.data.api.exception.PoliceResourceException;
import uk.police.data.api.schema.EngagementMethod;
import uk.police.data.api.schema.Force;
import uk.police.data.api.schema.Officer;

public class ForceTest extends AbstractPoliceApiTest{
    
    @Test
    public void testGetForces() throws IOException{
        createMockResponse("forces.json");
       
        List<Force> forces = api.getForces();
        assertTrue(forces.size() == 2);
        
        Force f = forces.get(1);
        
        assertEquals("bedfordshire", f.getId());
        assertEquals("Bedfordshire Police", f.getName());
    }
    
    @Test
    public void testGetSpecificForce() throws IOException{
        createMockResponse("specific_force.json");
        Force force = api.getSpecificForce("leicestershire");
        
        assertEquals("leicestershire", force.getId());
        assertEquals("Test description", force.getDescription());
        assertEquals("http://localhost/", force.getUrl());
        assertEquals("Leicestershire Constabulary", force.getName());
        assertEquals("123456789", force.getTelephone());
        assertEquals(4, force.getEngagementMethods().size());

        EngagementMethod em = force.getEngagementMethods().get(0);
        
        assertEquals("http://localhost", em.getUrl());
        assertEquals("title 1", em.getTitle());
        assertEquals("description 1", em.getDescription());
    }
    
    @Test
    public void testOfficerForForce() throws IOException{
        createMockResponse("officer.json");
        List<Officer> officers = api.getOfficersForForce("leicestershire");
        assertEquals(15, officers.size());
        
        Officer o = officers.get(0);
        
        assertTrue(o.getBio().startsWith("Enim occaecat deserunt adipisicing fugiat aliqua proident "));
        assertEquals("Jennie Thompson", o.getName());
        assertEquals("Laurel Avenue Wauhillau", o.getContactDetails().getAddress());
        assertEquals("(854) 515-3871", o.getContactDetails().getTelephone());
        assertEquals("rheahutchinson@eventex.com", o.getContactDetails().getEmail());
        assertEquals("(974) 430-2431", o.getContactDetails().getMobile());
        assertEquals("http://localhost", o.getContactDetails().getEmessaging());
    }
    
    @Test
    public void testBadResponseFormat() throws IOException {
        exception.expect(PoliceResourceException.class);
        createMockResponse("bad_format.json");
        api.getOfficersForForce("leicestershire");
    }
    
    @Test
    public void testBadResponseCode() throws IOException {
        exception.expect(PoliceResourceException.class);
        exception.expectMessage("Error retreiving resource (http://data.police.uk/api/forces/leicestershire/people) (404)");
        createMockResponse("bad_format.json", 404);
        api.getOfficersForForce("leicestershire");
    }
    
}

