package uk.police.data.api.schema;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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
    
    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Crime)){
            return false;
        }
        if(this == obj){
            return true;
        }
        Crime c2 = (Crime) obj;
        EqualsBuilder eb = new EqualsBuilder();
        eb.append(c2.category, category)
        .append(c2.persistentId, persistentId);
        return eb.isEquals();
    }            
    
    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(persistentId)
        .append(category)
        .append(month)
        .append(location)
        .append(locationSubtype);
        return hcb.toHashCode();
    }

}
