package uk.police.data.api.schema;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class NeighbourhoodLocation {

    private String force;
    private String neighbourhood;

    public String toString() {
        return new ToStringBuilder(this).append("force", force).append("neighbourhood", neighbourhood).toString();
    }
}
