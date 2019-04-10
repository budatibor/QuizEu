package model.PlayerDom;
import model.CountryDom.Country;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PlayerHighscoreData {
    private static ArrayList<Player> players;

    public static void insertIntoDatabase(@org.jetbrains.annotations.NotNull Player p){
        try {
            File input = new File("players.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document document = db.parse(input);

            Element root = (Element) document.getElementsByTagName("players");
            document.appendChild(root);

            Element playerDom = document.createElement("player");

            Attr attr = document.createAttribute("id");
            attr.setValue("10");
            playerDom.setAttributeNode(attr);
            Element firstName = document.createElement("Name");
            firstName.appendChild(document.createTextNode(p.getName()));
            playerDom.appendChild(firstName);

            // lastname element
            Element lastname = document.createElement("Score");
            lastname.appendChild(document.createTextNode(String.valueOf(p.getScore())));
            playerDom.appendChild(lastname);


        } catch (
            ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static ArrayList<Player> extractFromDatabase(){
        players = new ArrayList<Player>();

        try {

            String name;
            int score;
            int id;

            File input = new File("players.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document document = db.parse(input);

            document.getDocumentElement().normalize();

            NodeList nodelist = document.getElementsByTagName("player");

            for(int i=0; i<nodelist.getLength(); i++)
            {
                Node node = nodelist.item(i);
                //System.out.println(node.getNodeName());

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;
                    //System.out.println("Neptun kod: " + element.getAttribute("neptun"));
                    name = element.getElementsByTagName("name").item(0).getTextContent();
                    score = Integer.parseInt(element.getElementsByTagName("score").item(0).getTextContent());
                    id = Integer.parseInt(element.getAttribute("id"));

                    players.add(new Player(name, score, id));
                }
            }
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        }

        return players;
    }
}
