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
    
}
