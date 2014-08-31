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
import uk.police.data.api.schema.NeighbourhoodBoundary;
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

/**
 * Gateway to API provided by http://data.police.uk/
 * 
 * For full documentation visit http://data.police.uk/docs/
 * 
 * This class offers full access to all end points specified by API.
 *
 */
public class PoliceData {

    //The ApiConnection for this PoliceData
    private ApiConnection apiConnection;
    
    //Base URL
    private String apiUrl;
    
    //Retain Date this instance was created
    private Date createdAt;
        
    public ApiConnection getConnection(){
        return apiConnection;
    }
    
    /**
     * Instantiates a new PoliceData object
     * @return a new instance of PoliceData class
     */
    public static PoliceData create(){
        return new PoliceData();
    }
    
    
    /**
     * Instantiates a new PoliceData object
     *  
     * @param connection <code>ApiConnection</code> to use
     * @return a new instance of PoliceData class
     */
    public static PoliceData create(ApiConnection connection){
        return new PoliceData(DEFAULT_URL, connection);
    }
    
    private PoliceData(){
        this(DEFAULT_URL, ConnectionProvider.getDefault());
    }
    
    private PoliceData(String apiUrl, ApiConnection connection){
        this.apiUrl = apiUrl;
        this.apiConnection = connection; 
        this.createdAt = new Date();
    }

    /**
     * Create a <code>URL</code> relative to uk.police.data.api.PoliceData.apiUrl
     * @param uri
     * @return
     * @throws MalformedURLException
     */
    public URL getURL(String uri) throws MalformedURLException{
        return new URL(apiUrl + uri);
    }
    
    /**
     * Get all the forces  
     * @return  all the forces as a list of <code>Force</code>
     */
    public List<Force> getForces() {
        List<Force> forces = asList(ApiRequest.request(this).doGet("/forces", Force[].class, null));
        return forces;
    }
    
    /**
     * Get a force by it's unique identifier 
     * @param forceId    Unique identified of force
     * @return  <code>Force</code> represented by this id
     */
    public Force getSpecificForce(String forceId){
        return ApiRequest.request(this).doGet("/forces/" + forceId, Force.class, null);
    }
    
    /**
     * Get <code>Officer</code> for a force by force identifier
     * 
     * @param forceId Unique identified of force
     * @return
     */
    public List<Officer> getOfficersForForce(String forceId) {
       return asList(ApiRequest.request(this).doGet("/forces/" + forceId + "/people", Officer[].class, null));
    }
    
    /**
     * Get all <code>StreetLevelAvailability</code>
     * 
     * @return list of all <code>StreetLevelAvailability</code>
     */
    public List<StreetLevelAvailability> getStreetLevelAvailability() {
        return asList(ApiRequest.request(this).doGet("/crimes-street-dates", StreetLevelAvailability[].class, null));
    }
    
    /**
     * Get a list of all crimes at a location rather than those within a radius
     * 
     * @param date  (optional) the month if null then current month.
     * @param latitude  the latitude 
     * @param longitude the longitude
     * @return  list of all <Crime> for this date, latitude and longitude
     */
    public List<Crime> getCrimeAtLocation(Date date, double latitude, double longitude) {
        return asList(
             ApiRequest.request(this)
            .addParameter("date", Util.formatDate(date))
            .addParameter("lat", latitude)
            .addParameter("lng", longitude)
            .doGet("/crimes-at-location", Crime[].class, null)
        );
    }
    
    /**
     * Get a list of all crimes at a location
     * 
     * @param date  (optional) the month if null then current month.
     * @param locationId    unique location id
     * @return  list of all <Crime> for this date and location
     */
    public List<Crime> getCrimeAtLocation(Date date, String locationId) {
        return asList(
             ApiRequest.request(this)
            .addParameter("date", Util.formatDate(date))
            .addParameter("location_id", locationId)
            .doGet("/crimes-at-location", Crime[].class, null)
        );
    }
    
    /**
     * Get a list of all crimes within 1 mile radius 
     * 
     * @param date  (optional) the month if null then current month.
     * @param latitude  the latitude 
     * @param longitude the longitude 
     * @return list of all <Crime> within 1 mile of this date and location
     */
    public List<Crime> getStreetLevelCrime(Date date, double latitude, double longitude) {
        return asList(
             ApiRequest.request(this)
            .addParameter("date", Util.formatDate(date))
            .addParameter("lat", latitude)
            .addParameter("lng", longitude)
            .doGet("/crimes-street/all-crime", Crime[].class, null)
        );
    }
    
    /**
     * Get a list of all crimes within custom area
     * 
     * @param date  (optional) the month if null then current month.
     * @param polygon   custom crime area. The poly parameter is formatted in lat/lng pairs, separated by colons:
     *                  [lat],[lng]:[lat],[lng]:[lat],[lng] The first and last coordinates need not be the same 
     *                  — they will be joined by a straight line once the request is made.
     * @return  list of all <Crime> at date within polygon  
     */
    public List<Crime> getStreetLevelCrimeCustomArea(Date date, String polygon) {
        return asList(
             ApiRequest.request(this)
            .addParameter("date", Util.formatDate(date))
            .addParameter("poly", polygon)
            .doPost("/crimes-street/all-crime", Crime[].class, null)
        );
    }
    
    /**
     * Get crimes with no location specified
     * 
     * @param date  (optional) the month if null then current month.
     * @param category  The category of the crimes @see uk.police.data.api.PoliceData.getCrimeCategories(Date)
     * @param force unique identifier of responsible force
     * @return list of all <Crime> at date within category with responsible force
     */
    public List<Crime> getCrimeNoLocation(Date date, String category, String force){
        return asList(
             ApiRequest.request(this)
            .addParameter("date", Util.formatDate(date))
            .addParameter("category", category)
            .addParameter("force", force)
            .doGet("/crimes-no-location", Crime[].class, null)
        );
    }
    
    /**
     * Get outcome of specific crime 
     * @param identifier    unique identifier of a <code>Crime</code>  identifier is 64-character identifier
     * @return  <code>CrimeOutcome</code> by crime with identifier
     */
    public CrimeOutcome getOutcomeForCrime(String identifier) {
        return ApiRequest.request(this).doGet("/outcomes-for-crime/" + identifier, CrimeOutcome.class, null);
    }
    
    /**
     * Get outcome of crimes at location
     * 
     * @param date  (optional) the month if null then current month.
     * @param latitude  the latitude
     * @param longitude the longitude
     * 
     * @return list of <code>CrimeOutcome</code> for specified month , latitude and longitude
     */
    public List<CrimeOutcome> getOutcomesAtLocation(Date date, double latitude, double longitude) {
        return asList(
                ApiRequest.request(this)
               .addParameter("date", Util.formatDate(date))
               .addParameter("lat", latitude)
               .addParameter("lng", longitude)
               .doPost("/outcomes-at-location", CrimeOutcome[].class, null)
           );
    }
    
    /**
     * Get outcome of crimes at location
     * 
     * @param date  (optional) the month if null then current month.
     * @param locationId unique identifier of location
     * @return  list of <code>CrimeOutcome</code> for specified month and location 
     */
    public List<CrimeOutcome> getOutcomesAtLocation(Date date, String locationId)  {
        return asList(
                ApiRequest.request(this)
               .addParameter("date", Util.formatDate(date))
               .addParameter("location_id", locationId)
               .doPost("/outcomes-at-location", CrimeOutcome[].class, null)
           );
    }
    
    /**
     * Get outcome of crimes at custom location
     * 
     * @param date  (optional) the month if null then current month.
     * @param polygon   custom outcome area. The poly parameter is formatted in lat/lng pairs, separated by colons:
     *                  [lat],[lng]:[lat],[lng]:[lat],[lng] The first and last coordinates need not be the same 
     *                  — they will be joined by a straight line once the request is made.
     * @return  list of <code>CrimeOutcome</code> for specified month and custom area
     */
    public List<CrimeOutcome> getOutcomesAtCustomArea(Date date, String polygon) {
        return asList(
                ApiRequest.request(this)
               .addParameter("date", Util.formatDate(date))
               .addParameter("poly", polygon)
               .doPost("/outcomes-at-location", CrimeOutcome[].class, null)
           );
    }
    
    /**
     * Get list of crime categories that occurred in a particular month
     * 
     * @param date  (optional) the month if null then current month.
     * @return list of <code>CrimeCategory</code> 
     */
    public List<CrimeCategory> getCrimeCategories(Date date){
        return asList(
             ApiRequest.request(this)
            .addParameter("date", Util.formatDate(date))
            .doGet("/crime-categories", CrimeCategory[].class, null)
        );
    }
    
    /**
     * Get neighbourhoods for force
     * 
     * @param forceId   unique id for force
     * @return  list of <code>Neighbourhood</code> for forceId
     */
    public List<Neighbourhood> getNeighbourhoodsForForce(String forceId){
        return asList(ApiRequest.request(this).doGet("/" + forceId + "/neighbourhoods", Neighbourhood[].class, null));
    }
    
    /**
     * Get a neighbourhood by name and responsible force
     * @param name  name of the neighbourhood
     * @param forceId   unique id for force
     * @return  <code>Neighbourhood</code> with name and responsible forceId 
     */
    public Neighbourhood getSpecificNeighbourhood(String name, String forceId) {
        return ApiRequest.request(this).doGet("/" + name + "/" + forceId, Neighbourhood.class, null);
    }
    
    /**
     * Get boundary of neighbourhood by name and responsible force
     * 
     * @param name  name of the neighbourhood
     * @param forceId   unique id for force
     * @return <code>NeighbourhoodBoundary</code> of neighbourhood
     */
    public NeighbourhoodBoundary getNeighbourhoodBoundary(String name, String forceId) {
        return ApiRequest.request(this).doGet("/" + name + "/" + forceId + "/boundary", NeighbourhoodBoundary.class, null);
    }
    
    /**
     * Get neighbourhood team members for neighbourhood 
     * 
     * @param name  name of the neighbourhood
     * @param forceId   unique id for force
     * @return  list of <code>NeighbourhoodTeam</code> for neighbourhood
     */
    public List<NeighbourhoodTeam> getNeighbourhoodTeam(String name, String forceId) {
        return asList(
            ApiRequest.request(this).doGet("/" + name + "/" + forceId + "/people", NeighbourhoodTeam[].class, null)
        );
    }
    
    /**
     * Get neighbourhood events for neighbourhood
     * 
     * @param name  name of the neighbourhood
     * @param forceId   unique id for force
     * @return  list of <code>NeighbourhoodEvent</code> for neighbourhood
     */
    public List<NeighbourhoodEvent> getNeighbourhoodEvents(String name, String forceId) {
        return asList(
            ApiRequest.request(this).doGet("/" + name + "/" + forceId + "/events", NeighbourhoodEvent[].class, null)
        );
    }
    
    /**
     * Get neighbourhood events for neighbourhood
     * 
     * @param name  name of the neighbourhood
     * @param forceId   unique id for force
     * @return  list of <code>NeighbourhoodPriority</code> for neighbourhood
     */
    public List<NeighbourhoodPriority> getNeighbourhoodPrioritys(String name, String forceId) {
        return asList(
            ApiRequest.request(this).doGet("/" + name + "/" + forceId + "/events", NeighbourhoodPriority[].class, null)
        );
    }

    /**
     * Get date this instance was created
     * 
     * @return <code>Date</code>
     */
    public Date getCreateDate(){
        return createdAt;
    }
    
    /**
     * Get base url of api endpoint 
     * 
     * @return <code>String</code> of base url for api endpoint 
     */
    public String getApiUrl() {
        return apiUrl;
    }
    
    static ObjectMapper getJsonMapper() {
        return JSON_MAPPER;
    }
    
    private static final String DEFAULT_URL = "http://data.police.uk/api";
    
    private static final ObjectMapper JSON_MAPPER = new ObjectMapper();
    
    static {
        JSON_MAPPER.registerModule(new SimpleModule().addDeserializer(NeighbourhoodBoundary.class, new NeighbourhoodBoundryDeserializer()));
        JSON_MAPPER.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
        JSON_MAPPER.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        JSON_MAPPER.setDateFormat(new SimpleDateFormat("yyyy-MM"));
        JSON_MAPPER.setPropertyNamingStrategy(PropertyNamingStrategy.CAMEL_CASE_TO_LOWER_CASE_WITH_UNDERSCORES);
    }
    
}
