package week2;

import java.util.Objects;
import java.util.*;
    /**
     * enum for the type of the location
     */
enum locationType{
    CITY, AIRPORT, GAS_STATION, VILLAGE
}
    /**
     * Class that represents a location
     */
public class Location {
    /**
     * The name of the location
     */
    String name;
    /**
     * The type of the location
     */
    locationType type;
    /**
     * The x and y coordinate of the location
     */
    double x, y;
    /**
     * The roads that pass through the location
     */
    Vector<Road> passingRoads;
    /**
     * Constructor of the Location class
     * @param name
     * @param type
     * @param x
     * @param y
     */
    public Location(String name, locationType type, double x, double y) {
        this.name = name;
        this.type = type;
        this.x = x;
        this.y = y;
        this.passingRoads = new Vector<>();
    }
    /**
     * Adds a road to the passing roads of the location
     * @param road
     */
    public void addPassingRoad(Road road){
        if(!passingRoads.contains(road)){
            passingRoads.add(road);
        }
    }
    /**
     * Getter for the passing roads
     * @return passing roads of the location
     */
    public Vector<Road> getPassingRoads() {
        return passingRoads;
    }
    /**
     * Setter for the passing roads
     * @param passingRoads
     */
    public void setPassingRoads(Vector<Road> passingRoads) {
        this.passingRoads = passingRoads;
    }
    /**
     * Getter for the name of the location
     * @return name of the location
     */
    public String getName() {
        return name;
    }
    /**
     * Setter for the name of the location
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * Getter for the type of the location
     * @return type of the location
     */
    public locationType getType() {
        return type;
    }
    /**
     * Setter for the type of the location
     * @param type
     */
    public void setType(locationType type) {
        this.type = type;
    }
    /**
     * Getter for the x coordinate of the location
     * @return x coordinate of the location
     */
    public double getX() {
        return x;
    }
    /**
     * Setter for the x coordinate of the location
     * @param x
     */
    public void setX(double x) {
        this.x = x;
    }
    /**
     * Getter for the y coordinate of the location
     * @return y coordinate of the location
     */
    public double getY() {
        return y;
    }
    /**
     * Setter for the y coordinate of the location
     * @param y
     */
    public void setY(double y) {
        this.y = y;
    }
    /**
     * toString method for the Location class
     * @return the name, type, x and y coordinate of the location
     */
    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", type=" + type +
                ", x=" + x +
                ", y=" + y +
                '}';
    }
    /**
     * Equals method for the Location class
     * @param o
     * @return true if the name, type, x and y coordinate of the location are the same
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return Double.compare(location.getX(), getX()) == 0 && Double.compare(location.getY(), getY()) == 0 && Objects.equals(getName(), location.getName()) && getType() == location.getType();
    }
    /**
     * Hashcode method for the Location class
     * @return the hashcode of the name, type, x and y coordinate of the location
     */
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getType(), getX(), getY());
    }
}