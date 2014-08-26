package uk.police.data.api;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class ConnectionProvider {

    public static ApiConnection getDefault() {
        return new ApiConnection() {

            @Override
            public HttpURLConnection connect(URL url) throws IOException {
                return (HttpURLConnection) url.openConnection();
            }
        };
    }

}
