package model.Questions;
import model.CountryDom.InitCountriesData;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class QuestionCountry extends Question {

    public QuestionCountry() {
        Random rand = new Random();
        int n = rand.nextInt(InitCountriesData.getCountryList().size());
        oportunities = new ArrayList<>();
        setText("Which countries capital is " + InitCountriesData.countryList.get(n).getCapital() + "?");
        setPoint(10);
        addOportunity(InitCountriesData.getCountryList().get(n).getName());
        setIdx(rand.nextInt(4));

       // System.out.println(this.getText());


        while (oportunities.size()<4){
            n = rand.nextInt(InitCountriesData.getCountryList().size());

            if(!oportunities.contains(InitCountriesData.countryList.get(n).getName())){
                addOportunity(InitCountriesData.countryList.get(n).getName());
            }
        }

        Collections.swap(oportunities, idx, 0);
        //System.out.println(this);
    }

}
