package uk.police.data.api.schema;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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
    
    @Override
    public int hashCode() {
       HashCodeBuilder hcb = new HashCodeBuilder();
       return hcb.append(id).append(name).toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CrimeLocationStreet)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        CrimeLocationStreet c2 = (CrimeLocationStreet) obj ;
        EqualsBuilder eb = new EqualsBuilder();
        return eb.append(c2.id, id).append(c2.name, name).isEquals();
    }
    
}
