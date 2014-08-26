package uk.police.data.api.schema;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class EngagementMethod {

    private String url;
    private String description;
    private String title;
    
    @Override
    public String toString() {
       return new ToStringBuilder(this).append("url", url).append("description", description).append("title",title).toString();
    }
}
