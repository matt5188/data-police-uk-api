package uk.police.data.api.schema;

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
    
    
}
