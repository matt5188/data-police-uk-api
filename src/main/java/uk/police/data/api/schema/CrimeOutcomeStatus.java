package uk.police.data.api.schema;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class CrimeOutcomeStatus {
    
    private String category;
    private Date date;
    
    public String getCategory() {
        return category;
    }
    public Date getDate() {
        return date;
    }
    
    public String toString(){
        return new ToStringBuilder(this).append("category", category).append("date", date).toString();
    }
    
}
