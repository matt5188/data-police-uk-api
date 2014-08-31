package uk.police.data.api;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import junit.framework.Assert;

import org.apache.commons.lang3.time.DateUtils;
import org.junit.Test;
import uk.police.data.api.schema.Crime;


public class CrimeTest extends AbstractPoliceApiTest {
    
    @Test
    public void crimeAtLocationTest() throws IOException{
        createMockResponse("crime_at_location.json");
                
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, Calendar.MARCH);
        c.set(Calendar.YEAR, 2013);
        DateUtils.truncate(c, Calendar.MONTH);
        
        List<Crime> crimes = api.getCrimeAtLocation(c.getTime(), 52.629729, -1.131592);
        Assert.assertEquals(10, crimes.size());
        Crime crime = crimes.get(0);
        Assert.assertNotNull(crime.getCategory());
        Assert.assertNotNull(crime.getContext());
        Assert.assertNotNull(crime.getLocationSubtype());
        Assert.assertNotNull(crime.getPersistentId());
        Assert.assertNull(crime.getOutcomeStatus());
        Assert.assertNotNull(crime.getMonth());
    }
}

