package uk.police.data.api.schema;

import java.io.IOException;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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

}
