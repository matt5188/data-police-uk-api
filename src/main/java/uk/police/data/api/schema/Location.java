package uk.police.data.api.schema;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Location {
    
    private String name;
    private Double longitude;
    private Double latitude;
    private String postcode;
    private String address;
    private String telephone;
    private String type;
    private String description;
    
    public String getName() {
        return name;
    }
    public Double getLongitude() {
        return longitude;
    }
    public String getPostcode() {
        return postcode;
    }
    public String getAddress() {
        return address;
    }
    public String getTelephone() {
        return telephone;
    }
    public String getType() {
        return type;
    }
    public String getDescription() {
        return description;
    }
    public Double getLatitude() {
        return latitude;
    }
    
    public String toString(){
        return new ToStringBuilder(this).append("name", name).append("longitude", longitude).append("latitude", latitude).toString();
    }

    
}
