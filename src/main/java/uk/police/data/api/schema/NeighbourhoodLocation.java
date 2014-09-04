package uk.police.data.api.schema;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class NeighbourhoodLocation {

    private String force;
    private String neighbourhood;

    public String toString() {
        return new ToStringBuilder(this).append("force", force).append("neighbourhood", neighbourhood).toString();
    }

    public String getForce() {
        return force;
    }

    public String getNeighbourhood() {
        return neighbourhood;
    }
    
    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        return hcb.append(force).append(neighbourhood).toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof NeighbourhoodLocation)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        NeighbourhoodLocation p2 = (NeighbourhoodLocation) obj ;
        EqualsBuilder eb = new EqualsBuilder();
        return eb.append(p2.force, force).append(p2.neighbourhood, neighbourhood).isEquals();
    }
    
}
