package model.CountryDom;

import org.apache.log4j.Logger;

/**
 * Class representing coubtries
 */
public class Country {
    private final static Logger LOGGER = Logger.getLogger(Country.class);
    private String name;
    private String capital;
    private float density;
    private float area;
    private long population;

    /**
     * This is the contructor of the country class
     * @param name String, name of the country
     * @param capital String, capital of the country
     * @param density float, desity of the country
     * @param area float, area of the country
     * @param population long, population of the country
     */
    public Country(String name, String capital, float density, float area, long population) {
        this.name = name;
        this.capital = capital;
        this.density = density;
        this.area = area;
        this.population = population;

        LOGGER.debug(this.name + "is stored");
    }

    /**
     * Retrieves the nem of the country
     * @return String, the name of the of the country
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the capital city of the country
     * @return String , the capital of the country
     */
    public String getCapital() {
        return capital;
    }

    /**
     * Retrieves the population density of the a country in square kilometers
     * @return float, population density od the country
     */
    public float getDensity() {
        return density;
    }

    /**
     * Retrieves the area of a country in square kilometers
     * @return float, the area of the country
     */
    public float getArea() {
        return area;
    }

    /**
     * Retrieves the number of people that lives in the country
     * @return long, population of the country
     */
    public long getPopulation() {
        return population;
    }

    /**
     * the toString() method of country class
     * @return String, data about the country itself
     */
    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", capital='" + capital + '\'' +
                ", density=" + density +
                ", area=" + area +
                ", population=" + population +
                '}';
    }
}
