package week2;
    /**
     * Class inherited from Location
     */
public class GasStation extends Location{
    /**
     * The name of the gas station
     */
    private String name;
    /**
     * Name of the gas station
     */
    private String country;
    /**
     * The price of diesel for the gas station
     */
    private double price;
    /**
     * Constructor of the GasStation class
     * @param name
     * @param country
     * @param price
     * @param x
     * @param y
     */
    public GasStation(String name, String country, double price, double x, double y) {
        super(name, locationType.GAS_STATION, x, y);
        this.name = name;
        this.country = country;
        this.price = price;
    }
    /**
     * Getter for the name of the gas station
     * @return name of the gas station
     */
    public String getName() {
        return name;
    }
    /**
     * Setter for the name of the gas station
     * @param name
     */
    public void setName(String name) {
        this.name = name;
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
     * Getter for the price of diesel
     * @return price of diesel
     */
    public double getPrice() {
        return price;
    }
    /**
     * Setter for the price of diesel
     * @param price
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * Overriding the toString method for the GasStation class
     * @return name of the gas station, country name and price of diesel
     */
    @Override
    public String toString() {
        return "GasStation{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", price=" + price +
                '}';
    }
}
