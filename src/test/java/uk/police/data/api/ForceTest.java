package uk.police.data.api;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import static junit.framework.Assert.*;

import org.junit.Before;
import org.junit.Test;

import uk.police.data.api.schema.Force;
import uk.police.data.api.schema.Officer;
import uk.police.data.api.schema.PoliceResourceException;

public class ForceTest {

    private PoliceAPIGateway api;
    private MockConnection connection;
    
    @Before
    public void setup(){
        connection = MockConnection.getConnection();
        api = PoliceAPIGateway.getNewGateway(connection);
    }
    
    @Test
    public void testGetForces() throws IOException{
        createResponse("forces.json", 200);
       
        List<Force> forces = api.getForces();
        assertTrue(forces.size() == 2);
        
        Force f = forces.get(1);
        
        assertEquals("bedfordshire", f.getId());
        assertEquals("Bedfordshire Police", f.getName());
    }
    
    @Test
    public void testGetSpecificForce() throws IOException{
    }
    
    @Test
    public void testOfficerForForce() throws IOException{
        createResponse("officer.json", 200);
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
    
    @Test(expected = PoliceResourceException.class)
    public void testBadResponseFormat() throws IOException {
        createResponse("bad_format.json", 200);
        api.getOfficersForForce("leicestershire");
    }
    
    
    

    private void createResponse(String fileName, int code) {
        InputStream is = ForceTest.class.getResourceAsStream(fileName);
        connection.withInputStream(is).withResponse(code);
    }
    
}
