package model.CountryDom;

import model.CountryDom.Country;
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

public class InitCountriesData {

    public static List<Country> countryList;
    public static List<Country> getCountryList() {
        return countryList;
    }


    public static void InitCountriesData() {
        try {

            String name;
            String capital;
            float density;
            float area;
            long population;
            File input = new File("countries.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document document = db.parse(input);

            //System.out.println(document.getDocumentElement().getNodeName());

            document.getDocumentElement().normalize();

            NodeList nodelist = document.getElementsByTagName("country");

            countryList = new ArrayList<>();
            for(int i=0; i<nodelist.getLength(); i++)
            {
                Node node = nodelist.item(i);
                //System.out.println(node.getNodeName());

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    //System.out.println("Neptun kod: " + element.getAttribute("neptun"));
                    name = element.getElementsByTagName("name").item(0).getTextContent();
                    capital = element.getElementsByTagName("capital").item(0).getTextContent();
                    density = Float.parseFloat(element.getElementsByTagName("density").item(0).getTextContent());
                    area =  Float.parseFloat(element.getElementsByTagName("area").item(0).getTextContent());
                    population =  Long.parseLong(element.getElementsByTagName("population").item(0).getTextContent());

                    countryList.add(new Country(name, capital, density, area, population));
                }
            }

            for (var x: countryList)
                System.out.println(x);

        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }
    }


}

