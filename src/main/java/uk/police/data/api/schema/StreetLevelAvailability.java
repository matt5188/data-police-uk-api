package uk.police.data.api.schema;

import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class StreetLevelAvailability {

    public Date date;
    
    public Date getDate() {
        return date;
    }
    
    @Override
    public boolean equals(Object obj) {
        return this.getDate().equals(obj);
    }
    
    @Override
    public String toString() {
        return new ToStringBuilder(this).append("date",date).toString();
    }
    
}
