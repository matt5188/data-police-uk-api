package uk.police.data.api.schema;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class EngagementMethod {

    private String url;
    private String description;
    private String title;
    
    @Override
    public String toString() {
       return new ToStringBuilder(this).append("url", url).append("description", description).append("title",title).toString();
    }

    public String getUrl() {
        return url;
    }

    public String getDescription() {
        return description;
    }

    public String getTitle() {
        return title;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof EngagementMethod)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        EngagementMethod e2 = (EngagementMethod) obj ;
        EqualsBuilder eb = new EqualsBuilder();
        return eb.append(e2.url, url).append(e2.description, description).append(e2.title, title).isEquals();
    }
    
    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        return hcb.append(title).append(url).append(description).toHashCode();
     
    }
    
}
