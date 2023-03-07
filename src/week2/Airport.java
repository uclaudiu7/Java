package week2;

/**
 * Class inherited from Location
 */
public class Airport extends Location{
    /**
     * The airport code
     */
    private String airportCode;
    /**
     * Name of the country
     */
    private String country;
    /**
     * The number of terminals
     */
    private int numberOfTerminals;

    /**
     * Constructor of the Airport class
     * @param airportCode
     * @param country
     * @param numberOfTerminals
     * @param x
     * @param y
     */
    public Airport(String airportCode, String country, int numberOfTerminals, double x, double y) {
        super(airportCode, locationType.AIRPORT, x, y);
        this.airportCode = airportCode;
        this.numberOfTerminals = numberOfTerminals;
        this.country = country;
    }
    /**
     * Getter for the airport code
     * @return airport code
     */
    public String getAirportCode() {
        return airportCode;
    }
    /**
     * Setter for the airport code
     * @param airportCode
     */
    public void setAirportCode(String airportCode) {
        this.airportCode = airportCode;
    }
    /**
     * Getter for the number of terminals
     * @return number of terminals
     */
    public int getNumberOfTerminals() {
        return numberOfTerminals;
    }
    /**
     * Setter for the number of terminals
     * @param numberOfTerminals
     */
    public void setNumberOfTerminals(int numberOfTerminals) {
        this.numberOfTerminals = numberOfTerminals;
    }
    /**
     * Getter for the country name
     * @return country name
     */
    public String getCountry() {
        return country;
    }
    /**
     * Setter for the country name
     * @param country
     */
    public void setCountry(String country) {
        this.country = country;
    }
    /**
     * Overridden toString method for the Airport class
     * @return the name, number of terminals and country of the airport
     */
    @Override
    public String toString() {
        return "Airport{" +
                "name='" + name + '\'' +
                ", numberOfTerminals='" + numberOfTerminals + '\'' +
                ", country='" + country + '\'' +
                '}';
    }
}
