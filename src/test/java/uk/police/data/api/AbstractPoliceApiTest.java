package uk.police.data.api;

import java.io.InputStream;

import org.junit.Before
;
import org.junit.Rule;
import org.junit.rules.ExpectedException;

public class AbstractPoliceApiTest {

    protected PoliceData api;
    protected MockConnection connection;
    
    @Rule
    public ExpectedException exception = ExpectedException.none();
    
    @Before
    public void setup(){
        connection = MockConnection.getConnection();
        api = PoliceData.getNewGateway(connection);
    }
    
    protected void createMockResponse(String fileName) {
        createMockResponse(fileName, 200);
    }
    
    protected void createMockResponse(String fileName, int code) {
        InputStream is = this.getClass().getResourceAsStream(fileName);
        connection.withInputStream(is).withResponse(code);
    }
    
}
