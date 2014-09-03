package uk.police.data.api.schema;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CrimeOutcomeStatus)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        CrimeOutcomeStatus c2 = (CrimeOutcomeStatus) obj ;
        EqualsBuilder eb = new EqualsBuilder();
        return eb.append(c2.date, date).append(c2.category, category).isEquals();
    }
    
    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        return hcb.append(category).append(date).toHashCode();
     
    }
    
    
    
}
