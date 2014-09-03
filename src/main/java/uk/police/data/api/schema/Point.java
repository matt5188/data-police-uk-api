package uk.police.data.api.schema;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

public class Point {

    private Double latitude;
    private Double longitude;
    
    public Double getLatitude() {
        return latitude;
    }
    public Double getLongitude() {
        return longitude;
    }
    
    public String toString(){
        return new ToStringBuilder(this).append("latitude",latitude).append("longitude",longitude).toString();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Point)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        Point p2 = (Point) obj ;
        EqualsBuilder eb = new EqualsBuilder();
        return eb.append(p2.latitude, latitude).append(p2.longitude, longitude).isEquals();
    }
    
    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        return hcb.append(longitude).append(latitude).toHashCode();
    }
    
    
}
