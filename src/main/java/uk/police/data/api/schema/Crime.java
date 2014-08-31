package uk.police.data.api.schema;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Crime {

    private String category;
    private String persistentId;
    private Date month;

    private CrimeLocation location;

    private String context;
    private Long id;
    private String locationType;
    private String locationSubtype;
    private CrimeOutcomeStatus outcomeStatus;

    public String getCategory() {
        return category;
    }

    public String getPersistentId() {
        return persistentId;
    }

    public Date getMonth() {
        return month;
    }

    public CrimeLocation getLocation() {
        return location;
    }

    public String getContext() {
        return context;
    }

    public Long getId() {
        return id;
    }

    public String getLocationType() {
        return locationType;
    }

    public String getLocationSubtype() {
        return locationSubtype;
    }

    public CrimeOutcomeStatus getOutcomeStatus() {
        return outcomeStatus;
    }
    
    public String toString(){
        return new ToStringBuilder(this).append("persistentId", persistentId).append("category", category).toString();
    }
    

}
