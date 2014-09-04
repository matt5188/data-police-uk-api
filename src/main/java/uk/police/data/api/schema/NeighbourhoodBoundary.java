package uk.police.data.api.schema;

import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class NeighbourhoodBoundary {

    private List<Point> points;
    
    public void setPoints(List<Point> points){
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }
    
    public String toString(){
        return new ToStringBuilder(this).append("points", points).toString();
    }
    
    @Override
    public int hashCode() {
        return super.hashCode();
    }
    
    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof NeighbourhoodBoundary)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        NeighbourhoodBoundary c2 = (NeighbourhoodBoundary) obj ;
        
        return c2.getPoints().equals(this.getPoints());
    }
    
}
