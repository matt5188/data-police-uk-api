package uk.police.data.api.schema;

import java.util.List;

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
    
    
}
