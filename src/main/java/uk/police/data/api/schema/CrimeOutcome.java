package uk.police.data.api.schema;

import java.util.List;

public class CrimeOutcome {
    
    private List<Outcome> outcome;
    private Crime crime;
    
    public List<Outcome> getOutcome() {
        return outcome;
    }
    public Crime getCrime() {
        return crime;
    }
    
    
}
