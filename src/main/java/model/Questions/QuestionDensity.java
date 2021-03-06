package model.Questions;

import model.CountryDom.InitCountriesData;

import java.util.ArrayList;
import java.util.Random;

/**
 * Question about the density of the countries
 * where the opportunities are country names.
 */
public class QuestionDensity extends Question {
    /**
     * the constructor of the class where everything is setup.
     * It can acces the getter and setters from it's parrnt class.
     */
    public QuestionDensity() {

        Random rand = new Random();
        int n = rand.nextInt(InitCountriesData.getCountryList().size());
        oportunities = new ArrayList<>();
        setText("Which countries population density is the highest? (Km**2)");
        setPoint(18);
        addOportunity(InitCountriesData.getCountryList().get(n).getName());
        setIdx(rand.nextInt(4));

        int counter = 0;
        idx = 0;
        float currentDensity = InitCountriesData.getCountryList().get(n).getDensity();

        while (oportunities.size() < 4) {
            n = rand.nextInt(InitCountriesData.getCountryList().size());
            if (!oportunities.contains(InitCountriesData.countryList.get(n).getName())) {
                addOportunity(InitCountriesData.countryList.get(n).getName());
                counter++;
                if (InitCountriesData.countryList.get(n).getDensity() > currentDensity) {
                    idx = counter;
                    currentDensity = InitCountriesData.getCountryList().get(n).getDensity();
                }
            }
        }
        System.out.println(this);

    }
}
