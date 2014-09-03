package uk.police.data.api.schema;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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
    
    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        return hcb.append(code).append(name).toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CrimeOutcomeCategory)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        CrimeOutcomeCategory c2 = (CrimeOutcomeCategory) obj ;
        EqualsBuilder eb = new EqualsBuilder();
        return eb.append(c2.code, code).append(c2.name, name).isEquals();
    }
    
    
    
    
}
