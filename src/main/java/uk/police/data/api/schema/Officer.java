package uk.police.data.api.schema;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Officer {

    private String name;
    private String rank;
    private String bio;
    private ContactDetails contactDetails;

    public String getName() {
        return name;
    }

    public String getRank() {
        return rank;
    }

    public String getBio() {
        return bio;
    }

    public ContactDetails getContactDetails() {
        return contactDetails;
    }

    public String toString() {
        return new ToStringBuilder(this).append("name", name).append("rank", rank).toString();

    }
    
    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        return hcb.append(name).append(rank).append(bio).toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Officer)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Officer c2 = (Officer) obj ;
        EqualsBuilder eb = new EqualsBuilder();
        return eb.append(c2.name, name).append(c2.rank, rank).append(c2.bio, bio).append(c2.contactDetails, contactDetails).isEquals();
    }

}
