package uk.police.data.api.schema;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class CrimeLocationStreet {
    
    private Long id;
    private String name;
    
    public Long getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    
    public String toString(){
        return new ToStringBuilder(this).append("id",id).append("name",name).toString();
    }
    
}
