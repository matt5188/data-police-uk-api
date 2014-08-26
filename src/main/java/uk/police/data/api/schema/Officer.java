package uk.police.data.api.schema;

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

}
