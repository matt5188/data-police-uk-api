package uk.police.data.api;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.apache.commons.io.IOUtils;

import uk.police.data.api.exception.PoliceResourceException;

public class ApiRequest {

    private String requestMethod = "GET";
    private PoliceAPIGateway context;
    private Map<String, Object> parameters = new LinkedHashMap<>();
    
    public static ApiRequest request (PoliceAPIGateway api){
        return new ApiRequest(api);
    }
    
    public ApiRequest(PoliceAPIGateway api){
        this.context = api;
    }
    
    public ApiRequest addParameter(String key, Object value){
        if (value != null) {
            parameters.put(key, value);
        }
        return this;
    }
    
    public <T> T doGet(String uri, Class<T> type, T existing){
        this.requestMethod = "GET";
        return doRequest(uri, type, existing);
    }
    
    public <T> T doPost(String uri, Class<T> type, T existing){
        this.requestMethod = "POST";
        return doRequest(uri, type, existing);
    }
    
    protected <T> T doRequest(String uri, Class<T> type, T existing) {
        String url = uri + this.buildParameters();
        try {
            HttpURLConnection con = context.getConnection().connect(context.getURL(url));
            con.setRequestMethod(this.requestMethod);
            T response = parseResponse(con, type, existing);
            return response;
        } catch (IOException io) {
            throw new PoliceResourceException(io.getMessage());
        }
    }
    
    protected <T> T parseResponse(HttpURLConnection connection, Class<T> type, T existing) throws IOException{
        InputStreamReader isReader = null;
        try {
            checkResponseStatus(connection);
            InputStream stream = connection.getInputStream();
            isReader = new InputStreamReader(stream);
            String response = IOUtils.toString(isReader); 
            if (existing != null) {
                return PoliceAPIGateway.getJsonMapper().readerForUpdating(existing).readValue(response);
            }
            if (type != null) {
                return PoliceAPIGateway.getJsonMapper().readValue(response, type);
            }
            return null;
        } finally {
            IOUtils.closeQuietly(isReader);
        }
    }
    
    private void checkResponseStatus(HttpURLConnection connection) throws IOException {
        int responseCode = connection.getResponseCode();
        if(responseCode > 300){
            throw new PoliceResourceException(
                    "Error retreiving resource " +
                    "(" + connection.getURL() + ") " +
            		"(" + responseCode + ")"
            		);
        }
        
    }

    protected String buildParameters(){
        Set<String> keys = this.parameters.keySet();
        if(keys.isEmpty()){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for(String s : keys){
            if(isFirst){
                sb.append("?");
                isFirst = false;
            }else{
                sb.append("&");
            }
            sb.append(s).append("=").append(parameters.get(s));
        }
        
        return sb.toString();
    }
    
}
