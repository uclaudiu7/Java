package week2;

/**
 * Class inherited from Location
 */
public class City extends Location{
    /**
     * The name of the city
     */
    private String name;
    /**
     * Name of the country
     */
    private String country;
    /**
     * The population of the city
     */
    private int population;

    /**
     * Constructor of the City class
     * @param name
     * @param country
     * @param population
     * @param x
     * @param y
     */
    public City(String name, String country, int population, double x, double y) {
        super(name, locationType.CITY, x, y);
        this.name = name;
        this.country = country;
        this.population = population;
    }

    /**
     * Getter for the city name
     * @return city name
     */
    public String getName() {
        return name;
    }

    /**
     * Setter for the city name
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
     * Getter for the population of the city
     * @return
     */
    public int getPopulation() {
        return population;
    }

    /**
     * Setter for the population of the city
     * @param population
     */
    public void setPopulation(int population) {
        this.population = population;
    }
    /**
     * toString method for the City class
     * @return the name, country and population of the city
     */
    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", population=" + population +
                '}';
    }
}
