data-police-uk-api
==================
Java wrapper for interactions with data.police.uk crime statistics API at http://data.police.uk/. Full documentation 
available at http://data.police.uk/docs

## Motivation
There were no existing Java libraries providing total access to this information in an easy way. 

## Example Usage
```java
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

```

## TODOs
- Increase test coverage, this is currently limited to the Force API 
- Re-factor tests to use the real API end points over static files
- Re-factor the way we construct a url for easier testing
- Increase classes with Java Doc comments
- Add hashCode and equals to all schema objects
- Make list of crime categories for use within the API

