package uk.police.data.api;

import static java.util.Arrays.asList;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import uk.police.data.api.schema.Crime;
import uk.police.data.api.schema.CrimeCategory;
import uk.police.data.api.schema.CrimeOutcome;
import uk.police.data.api.schema.Force;
import uk.police.data.api.schema.Neighbourhood;
import uk.police.data.api.schema.NeighbourhoodBoundry;
import uk.police.data.api.schema.NeighbourhoodEvent;
import uk.police.data.api.schema.NeighbourhoodPriority;
import uk.police.data.api.schema.NeighbourhoodTeam;
import uk.police.data.api.schema.Officer;
import uk.police.data.api.schema.StreetLevelAvailability;
import uk.police.data.api.util.Util;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.module.SimpleModule;

public class PoliceAPIGateway {

    private ApiConnection apiConnection;
    
    private String apiUrl;
    
    private Date createdAt;
        
    public ApiConnection getConnection(){
        return apiConnection;
    }
    
    public static PoliceAPIGateway getNewGateway(){
        return new PoliceAPIGateway();
    }
    
    public static PoliceAPIGateway getNewGateway(ApiConnection connection){
        return new PoliceAPIGateway(DEFAULT_URL, connection);
    }
    
    private PoliceAPIGateway(){
        this(DEFAULT_URL, ConnectionProvider.getDefault());
    }
    
    private PoliceAPIGateway(String apiUrl, ApiConnection connection){
        this.apiUrl = apiUrl;
        this.apiConnection = connection; 
        this.createdAt = new Date();
    }

    public URL getURL(String uri) throws MalformedURLException{
        return new URL(apiUrl + uri);
    }
    
    public List<Force> getForces() {
        List<Force> forces = asList(ApiRequest.request(this).doGet("/forces", Force[].class, null));
        return forces;
    }
    
    public Force getSpecificForce(String id){
        return ApiRequest.request(this).doGet("/forces/" + id, Force.class, null);
    }
    
    public List<Officer> getOfficersForForce(String forceId) {
       return asList(ApiRequest.request(this).doGet("/forces/" + forceId + "/people", Officer[].class, null));
    }
    
    
    public List<StreetLevelAvailability> getStreetLevelAvailability() {
        return asList(ApiRequest.request(this).doGet("/crimes-street-dates", StreetLevelAvailability[].class, null));
    }
    
    public List<Crime> getCrimeAtLocation(Date date, double latitude, double longitude) {
        return asList(
             ApiRequest.request(this)
            .addParameter("date", Util.formatDate(date))
            .addParameter("lat", latitude)
            .addParameter("lng", longitude)
            .doGet("/crimes-at-location", Crime[].class, null)
        );
    }
    
    public List<Crime> getCrimeAtLocation(Date date, String locationId) {
        return asList(
             ApiRequest.request(this)
            .addParameter("date", Util.formatDate(date))
            .addParameter("location_id", locationId)
            .doGet("/crimes-at-location", Crime[].class, null)
        );
    }
    
    public List<Crime> getStreetLevelCrime(Date date, double latitude, double longitude) {
        return asList(
             ApiRequest.request(this)
            .addParameter("date", Util.formatDate(date))
            .addParameter("lat", latitude)
            .addParameter("lng", longitude)
            .doGet("/crimes-street/all-crime", Crime[].class, null)
        );
    }
    
    public List<Crime> getStreetLevelCrimeCustomArea(Date date, String polygon) {
        return asList(
             ApiRequest.request(this)
            .addParameter("date", Util.formatDate(date))
            .addParameter("poly", polygon)
            .doPost("/crimes-street/all-crime", Crime[].class, null)
        );
    }
    
    public List<Crime> getCrimeNoLocation(Date date, String category, String force){
        return asList(
             ApiRequest.request(this)
            .addParameter("date", Util.formatDate(date))
            .addParameter("category", category)
            .addParameter("force", force)
            .doGet("/crimes-no-location", Crime[].class, null)
        );
    }
    
    public CrimeOutcome getOutcomeForCrime(String identifier) {
        return ApiRequest.request(this).doGet("/outcomes-for-crime/" + identifier, CrimeOutcome.class, null);
    }
    
    public List<CrimeOutcome> getOutcomesAtLocation(Date date, double latitude, double longitude) {
        return asList(
                ApiRequest.request(this)
               .addParameter("date", Util.formatDate(date))
               .addParameter("lat", latitude)
               .addParameter("lng", longitude)
               .doPost("/outcomes-at-location", CrimeOutcome[].class, null)
           );
    }
    
    public List<CrimeOutcome> getOutcomesAtLocation(Date date, String locationId)  {
        return asList(
                ApiRequest.request(this)
               .addParameter("date", Util.formatDate(date))
               .addParameter("location_id", locationId)
               .doPost("/outcomes-at-location", CrimeOutcome[].class, null)
           );
    }
    
    public List<CrimeOutcome> getOutcomesAtCustomArea(Date date, String polygon) {
        return asList(
                ApiRequest.request(this)
               .addParameter("date", Util.formatDate(date))
               .addParameter("poly", polygon)
               .doPost("/outcomes-at-location", CrimeOutcome[].class, null)
           );
    }
    
    public List<CrimeCategory> getCrimeCategories(Date date){
        return asList(
             ApiRequest.request(this)
            .addParameter("date", Util.formatDate(date))
            .doGet("/crime-categories", CrimeCategory[].class, null)
        );
    }
    
    public List<Neighbourhood> getNeighbourhoodsForForce(String name){
        return asList(ApiRequest.request(this).doGet("/" + name + "/neighbourhoods", Neighbourhood[].class, null));
    }
    
    public Neighbourhood getSpecificNeighbourhood(String name, String id) {
        return ApiRequest.request(this).doGet("/" + name + "/" + id, Neighbourhood.class, null);
    }
    
    public NeighbourhoodBoundry getNeighbourhoodBoundry(String name, String id) {
        return ApiRequest.request(this).doGet("/" + name + "/" + id + "/boundary", NeighbourhoodBoundry.class, null);
    }
    
    public List<NeighbourhoodTeam> getNeighbourhoodTeam(String name, String id) {
        return asList(
            ApiRequest.request(this).doGet("/" + name + "/" + id + "/people", NeighbourhoodTeam[].class, null)
        );
    }
    
    public List<NeighbourhoodEvent> getNeighbourhoodEvents(String name, String id) {
        return asList(
            ApiRequest.request(this).doGet("/" + name + "/" + id + "/events", NeighbourhoodEvent[].class, null)
        );
    }
    
    public List<NeighbourhoodPriority> getNeighbourhoodPrioritys(String name, String id) {
        return asList(
            ApiRequest.request(this).doGet("/" + name + "/" + id + "/events", NeighbourhoodPriority[].class, null)
        );
    }

    public Date getCreateDate(){
        return createdAt;
    }
    
    public static ObjectMapper getJsonMapper() {
        return JSON_MAPPER;
    }
    
    private static final String DEFAULT_URL = "http://data.police.uk/api";
    
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    
    static {
        JSON_MAPPER.registerModule(new SimpleModule().addDeserializer(NeighbourhoodBoundry.class, new NeighbourhoodBoundryDeserializer()));
        JSON_MAPPER.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        JSON_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JSON_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM"));
        JSON_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    }
    
}
