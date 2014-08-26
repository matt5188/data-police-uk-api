package uk.police.data.api.schema;


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
    
}
