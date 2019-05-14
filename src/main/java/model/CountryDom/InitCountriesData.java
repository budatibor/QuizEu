package model.CountryDom;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This is the static class where I initialize all the information about the countries
 * from database. I use it only once when I'm running the project and the data is
 * stored in the whole process. I use DOM to store my data.
 */
public class InitCountriesData {

    /**
     * This is the list of countries extracted from database.
     * The variable is static because its not worth rereading data
     * the database because these informations will not change.
     */
    public static List<Country> countryList;

    /**
     * This is how you can acces the list of countries if they are stored.
     * @return List&lt;String&gt; the list of countries
     */
    public static List<Country> getCountryList() {
        return countryList;
    }

    /**
     * The method Initializes the database which is a DOM database.
     * Its searching for "coutry" elemnt tags, extracts data from it
     * and calls the country classes contructor before adding it to
     * the list which the game can acces through the whole process
     */
    public static void InitCountriesData() {
        try {

            //File input = new File(InitCountriesData.class.getClassLoader().getResource("countries.xml").getFile());
            File input = new File("countries.xml");
            String name;
            String capital;
            float density;
            float area;
            long population;

            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document document = db.parse(input);


            document.getDocumentElement().normalize();

            NodeList nodelist = document.getElementsByTagName("country");

            countryList = new ArrayList<>();
            for (int i = 0; i < nodelist.getLength(); i++) {
                Node node = nodelist.item(i);
                //System.out.println(node.getNodeName());

                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element element = (Element) node;

                    name = element.getElementsByTagName("name").item(0).getTextContent();
                    capital = element.getElementsByTagName("capital").item(0).getTextContent();
                    density = Float.parseFloat(element.getElementsByTagName("density").item(0).getTextContent());
                    area = Float.parseFloat(element.getElementsByTagName("area").item(0).getTextContent());
                    population = Long.parseLong(element.getElementsByTagName("population").item(0).getTextContent());

                    countryList.add(new Country(name, capital, density, area, population));
                }
            }

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }


}

