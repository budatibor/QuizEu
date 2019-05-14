package model.Questions;

import model.CountryDom.InitCountriesData;

import java.util.ArrayList;
import java.util.Random;

/**
 * Question about the area of the countries
 * where the opportunities are country names
 */
public class QuestionArea extends Question {
    /**
     * the constructor of the class where everything is setup.
     * It can acces the getter and setters from it's parrnt class.
     */
    public QuestionArea() {
        Random rand = new Random();
        int n = rand.nextInt(InitCountriesData.getCountryList().size());
        oportunities = new ArrayList<>();
        setText("Which countries area is bigger? (Km**2)");
        setPoint(16);
        addOportunity(InitCountriesData.getCountryList().get(n).getName());
        setIdx(rand.nextInt(4));

        int counter = 0;
        idx = 0;
        float currentArea = InitCountriesData.getCountryList().get(n).getArea();

        while (oportunities.size() < 4) {
            n = rand.nextInt(InitCountriesData.getCountryList().size());
            if (!oportunities.contains(InitCountriesData.countryList.get(n).getName())) {
                addOportunity(InitCountriesData.countryList.get(n).getName());
                counter++;
                if (InitCountriesData.countryList.get(n).getArea() > currentArea) {
                    idx = counter;
                    currentArea = InitCountriesData.getCountryList().get(n).getArea();
                }
            }
        }
        System.out.println(this);
    }
}
