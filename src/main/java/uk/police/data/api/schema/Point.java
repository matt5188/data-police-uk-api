package uk.police.data.api.schema;

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
    
    
}
