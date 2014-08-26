package uk.police.data.api.schema;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Neighbourhood {
    
    private String urlForce;
    private String urlBoundary;
    private ContactDetails contactDetails;
    private String name;
    private String welcomeMessage;
    private Point centre;
    private List<Location> locations;
    private String id;
    private Integer population;
    private Date fetchedAt;
    
    public String toString(){
        return new ToStringBuilder(this).append("id", id).append("name", name).toString();
    }
    public String getUrlForce() {
        return urlForce;
    }

    public String getUrlBoundary() {
        return urlBoundary;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public String getName() {
        return name;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public Point getCentre() {
        return centre;
    }

    public List<Location> getLocations() {
        return locations;
    }

    public String getId() {
        return id;
    }

    public Integer getPopulation() {
        return population;
    }

    public Date getFetchedAt() {
        return fetchedAt;
    }
    
}
