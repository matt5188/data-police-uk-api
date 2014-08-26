package uk.police.data.api;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import uk.police.data.api.schema.CrimeOutcome;
import uk.police.data.api.schema.Force;
import uk.police.data.api.schema.Neighbourhood;
import uk.police.data.api.schema.NeighbourhoodBoundry;
import uk.police.data.api.schema.NeighbourhoodEvent;
import uk.police.data.api.schema.NeighbourhoodTeam;

import com.fasterxml.jackson.databind.ObjectMapper;

public class Test {

    public static void main(String[] args) throws IOException {
        PoliceAPIGateway base = PoliceAPIGateway.getNewGateway();
        List<Force> forces = base.getForces();
//        for (Force f : forces) {
//            f.fetch();
//            System.out.println(f);
//        }
//        List<StreetLevelAvailability> dates = base.getStreetLevelAvailability();
//        for (StreetLevelAvailability f : dates) {
//            System.out.println(f.toString());
//            List<Crime> crimes; // = base.getCrimeAtLocation(f.getDate(), 52.629729, -1.131592);
////            for(Crime c : crimes){
////                System.out.println(c.toString());
////            }
////            crimes = base.getStreetLevelCrime(f.getDate(), 52.629729, -1.131592);
////            for(Crime c : crimes){
////                System.out.println(c.toString());
////            }
//            crimes = base.getStreetLevelCrimeCustomArea(f.getDate(), "52.268,0.543:52.794,0.238:52.130,0.478");
//            System.out.println(crimes.size());
//            for(Crime c : crimes){
////                System.out.println(c.toString());
//            }
//        }
        


        
  

        
        Calendar c = Calendar.getInstance();
        c.set(Calendar.MONTH, 5);
        List<CrimeOutcome> outcome = base.getOutcomesAtCustomArea(c.getTime(), "g52.4268,0.543:52.794,0.238:52.130,0.478");
        
        System.out.println(outcome);
        
        List<Neighbourhood> list = base.getNeighbourhoodsForForce("leicestershire");
        for(Neighbourhood n : list){
            System.out.println(n);
        }
        
        NeighbourhoodBoundry n = base.getNeighbourhoodBoundry("leicestershire", "C01");
        System.out.println(n);
        
        List<NeighbourhoodTeam> team = base.getNeighbourhoodTeam("leicestershire", "C01");
        for(NeighbourhoodTeam t : team){
            System.out.println(n);
        }
        
        List<NeighbourhoodEvent> team2 = base.getNeighbourhoodEvents("leicesstershire", "C01");
        for(NeighbourhoodEvent t : team2){
            System.out.println(t);
        }
    }
}
