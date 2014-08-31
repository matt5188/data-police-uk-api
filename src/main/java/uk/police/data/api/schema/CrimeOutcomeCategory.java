package uk.police.data.api.schema;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class CrimeOutcomeCategory {
    
    private String code;
    private String name;
    
    public String getCode() {
        return code;
    }
    public String getName() {
        return name;
    }
    
    public String toString(){
        return new ToStringBuilder(this).append("code", code).append("name", name).toString();
    }
    
    
}
