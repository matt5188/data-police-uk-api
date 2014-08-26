package uk.police.data.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;


public interface ApiConnection {
    
    public HttpURLConnection connect(URL url) throws IOException;
    
}
