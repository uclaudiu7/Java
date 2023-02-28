package week2;

enum locationType{
    CITY, AIRPORT, GAS_STATION, VILLAGE
}
public class Location {
    String name;
    locationType type;

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", type=" + type +
                '}';
    }

    public Location(String name, locationType type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public locationType getType() {
        return type;
    }

    public void setType(locationType type) {
        this.type = type;
    }
}