package uk.police.data.api.schema;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class NeighbourhoodTeam {
    
    private String bio;
    private ContactDetails contactDetails;
    private String name;
    private String rank;
    
    public String toString(){
        return new ToStringBuilder(this).append("name",name).append("rank",rank).toString();
    }

    public String getBio() {
        return bio;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }
    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        return hcb.append(rank).append(contactDetails).append(name).append(bio).toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof NeighbourhoodTeam)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        NeighbourhoodTeam p2 = (NeighbourhoodTeam) obj ;
        EqualsBuilder eb = new EqualsBuilder();
        return eb.append(p2.bio, bio).append(p2.contactDetails, contactDetails).append(p2.name, name).append(p2.rank, rank).isEquals();
    }
    
}
