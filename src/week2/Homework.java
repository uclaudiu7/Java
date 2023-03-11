package week2;
import java.util.*;
    /**
     * The main class of the homework
     */
public class Homework {
    public static void main(String[] args){
        Vector < Location > locations = new Vector<>();
        Vector < Road > roads = new Vector<>();

        Location newYorkCity = new City("New York City", "USA", 8398748, 40.7128, -74.0060);
        Location losAngeles = new City("Los Angeles", "USA", 3849000, 34.0522, -118.2437);
        Location chicago = new City("Chicago", "USA", 2697000, 41.8781, -87.6298);
        Location houston = new City("Houston", "USA", 2288000, 29.7604, -95.3698);
        Location philadelphia = new City("Philadelphia", "USA", 1576000, 39.9526, -75.1652);

        Location atl = new Airport("ATL", "USA", 2, 33.6407, -84.4277);
        Location lax = new Airport("LAX", "USA", 9, 33.9416, -118.4085);
        Location ord = new Airport("ORD", "USA", 4, 41.9742, -87.9073);
        Location dfw = new Airport("DFW", "USA", 5, 32.8998, -97.0403);
        Location den = new Airport("DEN", "USA", 3, 39.8561, -104.6737);

        Location petrom =  new GasStation("Petrom", "USA", 7.30, 33.6425, -117.6026);
        Location mol =  new GasStation("Mol", "USA", 7.36, 39.4699, -119.7754);
        Location omv =  new GasStation("OMV", "USA", 7.36, 35.5493, -97.5672);
        Location rompetrol =  new GasStation("Rompetrol", "USA", 7.38, 40.7048, -74.0153);
        Location lukoil =  new GasStation("Lukoil", "USA", 7.30, 33.9126, -118.3993);

        addLocation(locations, newYorkCity);
        addLocation(locations, losAngeles);
        addLocation(locations, chicago);
        addLocation(locations, houston);
        addLocation(locations, philadelphia);
        addLocation(locations, atl);
        addLocation(locations, lax);
        addLocation(locations, ord);
        addLocation(locations, dfw);
        addLocation(locations, den);
        addLocation(locations, petrom);
        addLocation(locations, mol);
        addLocation(locations, omv);
        addLocation(locations, rompetrol);
        addLocation(locations, lukoil);
        addLocation(locations, lukoil);

        addRoad(roads, new Road(RoadType.EXPRESS, 100, 70, newYorkCity, losAngeles));
        addRoad(roads, new Road(RoadType.HIGHWAY, 200, 65, losAngeles, chicago));
        addRoad(roads, new Road(RoadType.COUNTRY, 50, 45, chicago, houston));
        addRoad(roads, new Road(RoadType.EXPRESS, 150, 70, houston, atl));
        addRoad(roads, new Road(RoadType.HIGHWAY, 80, 65, atl, ord));
        addRoad(roads, new Road(RoadType.COUNTRY, 70, 45, ord, newYorkCity));
        addRoad(roads, new Road(RoadType.EXPRESS, 80, 70, dfw, den));
        addRoad(roads, new Road(RoadType.HIGHWAY, 120, 65, den, chicago));
        addRoad(roads, new Road(RoadType.COUNTRY, 40, 45, philadelphia, atl));
        addRoad(roads, new Road(RoadType.HIGHWAY, 160, 65, losAngeles, lukoil));

        if(canTravel(newYorkCity, chicago)){
            System.out.println("We have found a road for your desired locations!");
        }
        else{
            System.out.println("Sorry! Cannot find a road for your locations!");
        }

    }
    /**
     * Adds a location to the vector of locations
     * @param locations the vector of locations
     * @param location the location to be added
     */
    public static void addLocation(Vector<Location> locations, Location location){
        if(!locations.contains(location)){
            locations.add(location);
        }
    }
    /**
     * Adds a road to the vector of roads if the road is valid
     * @param roads the vector of roads
     * @param road the road to be added
     */
    public static void addRoad(Vector<Road> roads, Road road){
        if(!isRoadValid(road)) {
            throw new IllegalArgumentException("Length of the road cannot be less than the euclidian distance between the locations!");
        }
        if(!roads.contains(road)){
            roads.add(road);
            road.getStartLocation().addPassingRoad(road);
            road.getEndLocation().addPassingRoad(road);
        }
    }
    /**
     * Checks if the road is valid
     * @param road the road to be checked
     * @return true if the road is valid, false otherwise
     */
    public static boolean isRoadValid(Road road){
        double startLocationX = road.getStartLocation().getX();
        double startLocationY = road.getStartLocation().getY();
        double endLocationX = road.getEndLocation().getX();
        double endLocationY = road.getEndLocation().getY();

        double euclidianDistance = Math.sqrt(Math.pow(endLocationX- startLocationX, 2) + Math.pow(endLocationY - startLocationY, 2));
        return !(road.getLength() < euclidianDistance);
    }
    /**
     * Checks if we can travel from a location to another
     * @param startLocation the start location
     * @param endLocation the end location
     * @return true if we can travel, false otherwise
     */
    public static boolean canTravel(Location startLocation, Location endLocation){
        HashSet<Location> visitedLocations = new HashSet<>();

        LinkedList<Location> queue = new LinkedList<>();
        visitedLocations.add(startLocation);
        queue.add(startLocation);

        while(!queue.isEmpty()){
            Location currentLocation = queue.poll();
            if(currentLocation.equals(endLocation)){
                return true;
            }
            for(Road road : currentLocation.getPassingRoads()){
                Location nextRoad = road.getEndLocation();
                if(!visitedLocations.contains(nextRoad)){
                    visitedLocations.add(nextRoad);
                    queue.add(nextRoad);
                }
            }
        }
        return false;
    }
}
