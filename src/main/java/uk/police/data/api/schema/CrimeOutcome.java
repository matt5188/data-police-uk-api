package uk.police.data.api.schema;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class CrimeOutcome {
    
    private List<Outcome> outcome;
    private Crime crime;
    
    public List<Outcome> getOutcome() {
        return outcome;
    }
    public Crime getCrime() {
        return crime;
    }
    
    public String toString(){
        return new ToStringBuilder(this).append("crime", crime).append("outcome", outcome).toString();
    }
    
    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        return hcb.append(outcome).append(crime).toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CrimeOutcome)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        CrimeOutcome c2 = (CrimeOutcome) obj ;
        EqualsBuilder eb = new EqualsBuilder();
        return eb.append(c2.crime, crime).append(c2.outcome, outcome).isEquals();
    }
    
    
}
