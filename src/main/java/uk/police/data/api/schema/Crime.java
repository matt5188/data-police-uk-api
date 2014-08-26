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

    public String toString(){
        return new ToStringBuilder(this).append("persistentId", persistentId).append("category", category).toString();
    }
    
    



}
