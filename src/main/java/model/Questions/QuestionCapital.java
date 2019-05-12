package model.Questions;

import model.CountryDom.InitCountriesData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuestionCapital extends Question {

    public QuestionCapital() {
        Random rand = new Random();
        int n = rand.nextInt(InitCountriesData.getCountryList().size());
        oportunities = new ArrayList<>();
        setText("Which city is " + InitCountriesData.countryList.get(n).getName() + "'s capital?");
        setPoint(12);
        addOportunity(InitCountriesData.getCountryList().get(n).getCapital());
        setIdx(rand.nextInt(4));


        while (oportunities.size() < 4) {
            n = rand.nextInt(InitCountriesData.getCountryList().size());
            if (!oportunities.contains(InitCountriesData.countryList.get(n).getCapital()))
                addOportunity(InitCountriesData.countryList.get(n).getCapital());
        }
        Collections.swap(oportunities, idx, 0);
        //System.out.println(this);
    }
}
