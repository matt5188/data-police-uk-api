package uk.police.data.api.schema;

import java.util.List;
import java.util.Set;

public class NeighbourhoodBoundary {

    private List<Point> points;
    
    public void setPoints(List<Point> points){
        this.points = points;
    }

    public List<Point> getPoints() {
        return points;
    }
    
}
