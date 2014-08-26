package uk.police.data.api;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.mockito.Mockito;

public class MockConnection implements ApiConnection {
    
    private MockConnection(){}
    
    private InputStream inputStream;
    private int responseCode;
    
    public static MockConnection getConnection(){
        return new MockConnection();
    }
    
    @Override
    public HttpURLConnection connect(URL url) throws IOException {
        HttpURLConnection con = Mockito.mock(HttpURLConnection.class);
        Mockito.when(con.getInputStream()).thenReturn(inputStream);
        Mockito.when(con.getResponseCode()).thenReturn(responseCode);
        Mockito.when(con.getURL()).thenReturn(url);
        return con;
    }
    
    public MockConnection withInputStream(InputStream inputStream){
        this.inputStream = inputStream;
        return this;
    }
    
    public MockConnection withResponse(int response){
        this.responseCode = response;
        return this;
    }

}
