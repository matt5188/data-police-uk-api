package uk.police.data.api.schema;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
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
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof CrimeLocation)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        CrimeLocation c2 = (CrimeLocation) obj;
        EqualsBuilder eb = new EqualsBuilder();
        return eb.append(c2.latitude, latitude)
        .append(c2.longitude, longitude)
        .append(c2.street, street)
        .isEquals();
    }
    
    @Override
    public int hashCode() {
        HashCodeBuilder hcb = new HashCodeBuilder();
        return hcb.append(longitude).append(latitude).append(street).toHashCode();
    }
    
}
