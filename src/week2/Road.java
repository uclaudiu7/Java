package week2;

import java.util.Objects;
    /**
     * enum for the type of the road
     */
enum RoadType{
    HIGHWAY, EXPRESS, COUNTRY
}
    /**
     * Class that represents a road
     */
public class Road {
    /**
     * The type of the road
     */
    RoadType type;
    /**
     * The length of the road
     */
    int length;
    /**
     * The speed limit of the road
     */
    int speedLimit;
    /**
     * The start location of the road
     */
    private Location startLocation;
    /**
     * The end location of the road
     */
    private Location endLocation;
    /**
     * Constructor of the Road class
     * @param type
     * @param length
     * @param speedLimit
     * @param startLocation
     * @param endLocation
     */
    public Road(RoadType type, int length, int speedLimit, Location startLocation, Location endLocation) {
        this.type = type;
        this.length = length;
        this.speedLimit = speedLimit;
        this.startLocation = startLocation;
        this.endLocation = endLocation;
    }
    /**
     * Getter for the start location
     * @return start location
     */
    public Location getStartLocation() {
        return startLocation;
    }
    /**
     * Setter for the start location
     * @param startLocation
     */
    public void setStartLocation(Location startLocation) {
        this.startLocation = startLocation;
    }
    /**
     * Getter for the end location
     * @return end location
     */
    public Location getEndLocation() {
        return endLocation;
    }
    /**
     * Setter for the end location
     * @param endLocation
     */
    public void setEndLocation(Location endLocation) {
        this.endLocation = endLocation;
    }
    /**
     * Getter for the type
     * @return type
     */
    public RoadType getType() {
        return type;
    }
    /**
     * Setter for the type
     * @param type
     */
    public void setType(RoadType type) {
        this.type = type;
    }
    /**
     * Getter for the length
     * @return length
     */
    public int getLength() {
        return length;
    }
    /**
     * Setter for the length
     * @param length
     */
    public void setLength(int length) {
        this.length = length;
    }
    /**
     * Getter for the speed limit
     * @return speed limit
     */
    public int getSpeedLimit() {
        return speedLimit;
    }
    /**
     * Setter for the speed limit
     * @param speedLimit
     */
    public void setSpeedLimit(int speedLimit) {
        this.speedLimit = speedLimit;
    }
    /**
     * toString method for the Road class
     * @return string representation of the road
     */
    @Override
    public String toString() {
        return "Road{" +
                "type=" + type +
                ", length=" + length +
                ", speedLimit=" + speedLimit +
                ", startLocation=" + startLocation +
                ", endLocation=" + endLocation +
                '}';
    }
    /**
     * equals method for the Road class
     * @param o
     * @return true if the roads are equal, false otherwise
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Road road)) return false;
        return getLength() == road.getLength() && getSpeedLimit() == road.getSpeedLimit() && getType() == road.getType() && Objects.equals(getStartLocation(), road.getStartLocation()) && Objects.equals(getEndLocation(), road.getEndLocation());
    }
    /**
     * hashCode method for the Road class
     * @return hash code of the road
     */
    @Override
    public int hashCode() {
        return Objects.hash(getType(), getLength(), getSpeedLimit(), getStartLocation(), getEndLocation());
    }

}
