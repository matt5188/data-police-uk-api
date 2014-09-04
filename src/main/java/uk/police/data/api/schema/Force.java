package uk.police.data.api.schema;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import uk.police.data.api.ApiRequest;
import uk.police.data.api.PoliceData;

public class Force {

    private String id;
    private String name;
    private List<EngagementMethod> engagementMethods;
    private String url;
    private String telephone;
    private String description;
    private Date fetchedAt;
    
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("url", url).append("telephone", telephone).toString();
    }

    public void fetch(PoliceData api) {
        if (fetchedAt != null) {
            return;
        }
        ApiRequest.request(api).doGet("/forces/" + id, Force.class, this);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<EngagementMethod> getEngagementMethods() {
        return engagementMethods;
    }

    public String getUrl() {
        return url;
    }

    public String getTelephone() {
        return telephone;
    }

    public String getDescription() {
        return description;
    }
    
    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        return hcb.append(description).append(telephone).append(name).toHashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Force)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Force c2 = (Force) obj ;
        EqualsBuilder eb = new EqualsBuilder();
        return eb.append(c2.id, id).append(c2.name, name).append(c2.telephone, telephone).append(c2.description, description).isEquals();
    }

}
