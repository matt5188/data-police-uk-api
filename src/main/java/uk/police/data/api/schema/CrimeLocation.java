package uk.police.data.api.schema;

import org.apache.commons.lang3.builder.ToStringBuilder;


public class CrimeLocation {
    
    private Double latitude;
    private Double longitude;
    private CrimeLocationStreet street;
    
    public Double getLatitude() {
        return latitude;
    }
    public Double getLongitude() {
        return longitude;
    }
    public CrimeLocationStreet getStreet() {
        return street;
    }
    
    public String toString(){
        return new ToStringBuilder(this).append("latitude",latitude).append("longitude", longitude).append("street",street).toString();
    }
    
}
