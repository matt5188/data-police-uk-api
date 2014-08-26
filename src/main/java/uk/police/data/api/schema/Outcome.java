package uk.police.data.api.schema;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Outcome {
    private CrimeOutcomeCategory category;
    private String code;
    private String name;
    private Date date;
    @JsonProperty(value = "person_id")
    private Double personId;
    
    public CrimeOutcomeCategory getCategory() {
        return category;
    }
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    public Date getDate() {
        return date;
    }
    public Double getPersonId() {
        return personId;
    }
    
    
}
