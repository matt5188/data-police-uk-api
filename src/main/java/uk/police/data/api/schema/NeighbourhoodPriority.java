package uk.police.data.api.schema;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonFormat;

public class NeighbourhoodPriority {

    private String issue;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = JsonFormat.DEFAULT_LOCALE)
    private Date issueDate;
    private String action;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss", timezone = JsonFormat.DEFAULT_LOCALE)
    private Date actionDate;
    
    public String toString(){
        return new ToStringBuilder(this)
        .append("issue",issue)
        .append("issueDate",issueDate)
        .append("action",action)
        .append("actionDate",actionDate)
        .toString();
    }

}
