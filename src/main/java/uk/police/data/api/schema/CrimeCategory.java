package uk.police.data.api.schema;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CrimeCategory)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
       CrimeCategory c2 = (CrimeCategory) obj ;
       EqualsBuilder eb = new EqualsBuilder();
       eb.append(c2.url, url)
       .append(c2.name, name);
       return eb.isEquals();
    }
    
    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        hcb.append(url).append(name);
        return hcb.toHashCode();
    }
    
}
