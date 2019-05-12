package model.CountryDom;

import org.apache.log4j.Logger;


public class Country {
    private final static Logger LOGGER = Logger.getLogger(Country.class);
    private String name;
    private String capital;
    private float density;
    private float area;
    private long population;

    public Country(String name, String capital, float density, float area, long population) {
        this.name = name;
        this.capital = capital;
        this.density = density;
        this.area = area;
        this.population = population;

        LOGGER.debug(this.name + "is stored");
    }

    public String getName() {
        return name;
    }

    public String getCapital() {
        return capital;
    }


    public float getDensity() {
        return density;
    }


    public float getArea() {
        return area;
    }


    public long getPopulation() {
        return population;
    }


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
