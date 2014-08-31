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
    
}
