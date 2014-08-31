package uk.police.data.api;
import java.net.MalformedURLException;
import java.net.URL;

import junit.framework.Assert;

import org.junit.Test;
public class PoliceTest extends AbstractPoliceApiTest {

    
    @Test
    public void testURLCreation() throws MalformedURLException{
        URL url1 = api.getURL("/crimes-street/all-crime?lat=52.629729&lng=-1.131592&date=2013-01");
        URL url2 = new URL("http://data.police.uk/api/crimes-street/all-crime?lat=52.629729&lng=-1.131592&date=2013-01");
        
        Assert.assertEquals(url1.toString(), url2.toString());
    }
    
    
    
}
