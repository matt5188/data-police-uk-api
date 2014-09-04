package uk.police.data.api.schema;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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

    public String getIssue() {
        return issue;
    }

    public Date getIssueDate() {
        return issueDate;
    }

    public String getAction() {
        return action;
    }

    public Date getActionDate() {
        return actionDate;
    }
    
    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        return hcb.append(issue).append(issueDate).append(action).append(actionDate).toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof NeighbourhoodPriority)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        NeighbourhoodPriority p2 = (NeighbourhoodPriority) obj ;
        EqualsBuilder eb = new EqualsBuilder();
        return eb.append(p2.issue, issue).append(p2.actionDate, actionDate).append(p2.issueDate, issueDate).isEquals();
    }
    
    

}
