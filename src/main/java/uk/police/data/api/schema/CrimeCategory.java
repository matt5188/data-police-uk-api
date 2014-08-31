package uk.police.data.api.schema;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class CrimeCategory {

    private String url;
    private String name;
    
    public String getUrl() {
        return url;
    }
    public String getName() {
        return name;
    }
    
    public String toString(){
        return new ToStringBuilder(this).append("url",url).append("name",name).toString();
    }
    
}
