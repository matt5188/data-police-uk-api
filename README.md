data-police-uk-api
==================
Java wrapper for interactions with data.police.uk crime statistics API at http://data.police.uk/. Full documentation 
available at http://data.police.uk/docs

## Why?
There were no existing Java libraries providing total access to this information in an easy way. 

## Example Usage
```java
PoliceAPIGateway base = PoliceAPIGateway.getNewGateway();
// Get all forces
List<Force> forces = base.getForces();
// Get specific force
Force force = base.getSpecificForce("leicestershire");
// Get list of dates crime information is available for
List<StreetLevelAvailability> crimeDates = base.getStreetLevelAvailability();
// Get crime data for each data at latitude longitude
for (StreetLevelAvailability sla : crimeDates) {
    base.getCrimeAtLocation(sla.getDate(), 52.629729, -1.131592);
}
```
