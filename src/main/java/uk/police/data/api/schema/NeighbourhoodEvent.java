package uk.police.data.api.schema;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NeighbourhoodEvent {

    private ContactDetails contactDetails;
    private String description;
    private String title;
    private String address;
    private String type;
    @JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd'T'HH:mm:ss", timezone=JsonFormat.DEFAULT_LOCALE)
    private Date startDate;

    public String toString(){
        return new ToStringBuilder(this).append("title",title).append("address",address).append("startDate",startDate).toString();
    }
}
