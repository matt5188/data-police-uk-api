package uk.police.data.api;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.police.data.api.schema.Crime;
import uk.police.data.api.schema.CrimeOutcome;
import uk.police.data.api.schema.Force;
import uk.police.data.api.schema.Neighbourhood;
import uk.police.data.api.schema.NeighbourhoodBoundary;
import uk.police.data.api.schema.NeighbourhoodEvent;
import uk.police.data.api.schema.NeighbourhoodTeam;
import uk.police.data.api.schema.StreetLevelAvailability;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

    public static void main(String[] args) throws IOException {
// Create a new gateway to the API
PoliceData base = PoliceData.create();
// Get all forces
List<Force> forces = base.getForces();
for(Force f : forces){
    print(f);
}

// Get specific force
Force force = base.getSpecificForce("leicestershire");
print(force);

// Get list of dates crime information is available for
List<StreetLevelAvailability> crimeDates = base.getStreetLevelAvailability();
// Get crime data for each data at latitude longitude
    for (StreetLevelAvailability sla : crimeDates) {
        List<Crime> crimes = base.getCrimeAtLocation(sla.getDate(), 52.629729, -1.131592);
        print(crimes);
    }
    
}

private static void print(Object f) {
    System.out.println(f);
}
}
