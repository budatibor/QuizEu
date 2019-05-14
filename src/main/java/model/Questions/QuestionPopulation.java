package model.Questions;

import model.CountryDom.InitCountriesData;

import java.util.ArrayList;
import java.util.Random;

/**
 * Question about the population of the countries
 * where the opportunities are country names.
 */
public class QuestionPopulation extends Question {
    /**
     * the constructor of the class where everything is setup.
     * It can acces the getter and setters from it's parrnt class.
     */
    public QuestionPopulation() {
        Random rand = new Random();
        int n = rand.nextInt(InitCountriesData.getCountryList().size());
        oportunities = new ArrayList<>();
        setText("Which countries population is the highest?");
        setPoint(14);
        addOportunity(InitCountriesData.getCountryList().get(n).getName());
        setIdx(rand.nextInt(4));

        int counter = 0;
        idx = 0;
        long currentPopulation = InitCountriesData.getCountryList().get(n).getPopulation();

        while (oportunities.size() < 4) {
            n = rand.nextInt(InitCountriesData.getCountryList().size());
            if (!oportunities.contains(InitCountriesData.countryList.get(n).getName())) {
                addOportunity(InitCountriesData.countryList.get(n).getName());
                counter++;
                if (InitCountriesData.countryList.get(n).getPopulation() > currentPopulation) {
                    idx = counter;
                    currentPopulation = InitCountriesData.getCountryList().get(n).getPopulation();
                }
            }
        }
        System.out.println(this);
    }
}
