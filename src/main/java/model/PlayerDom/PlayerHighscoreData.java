package model.PlayerDom;

import model.CountryDom.Country;
import org.w3c.dom.*;
import org.xml.sax.SAXException;

import javax.xml.transform.*;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class PlayerHighscoreData {
    private static ArrayList<Player> players;

    public static void insertIntoDatabase(@org.jetbrains.annotations.NotNull Player p) {
        try {

            File input = new File("players.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document document = db.parse(input);
            //document.getDocumentElement().normalize();

            Element playerDom = document.createElement("player");
            Attr attr = document.createAttribute("id");
            attr.setValue(String.valueOf(document.getElementsByTagName("player").getLength() + 1));
            playerDom.setAttributeNode(attr);
            Node firstName = document.createElement("name");
            firstName.appendChild(document.createTextNode(p.getName()));
            playerDom.appendChild(firstName);
            Node score = document.createElement("score");
            score.appendChild(document.createTextNode(String.valueOf(p.getScore())));
            playerDom.appendChild(score);

            playerDom.appendChild(firstName);
            playerDom.appendChild(score);
            document.getDocumentElement().appendChild(playerDom);

            document.getDocumentElement().normalize();
            TransformerFactory tf = TransformerFactory.newInstance();
            Transformer t = tf.newTransformer();

            DOMSource source = new DOMSource(document);
            StreamResult result = new StreamResult(input);
            t.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            t.setOutputProperty(OutputKeys.INDENT, "yes");
            t.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
            t.transform(source, result);


        } catch (
                ParserConfigurationException e) {
            e.printStackTrace();
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TransformerConfigurationException e) {
            e.printStackTrace();
        } catch (TransformerException e) {
            e.printStackTrace();
        }

    }


    public static ArrayList<Player> extractFromDatabase() {
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
            players = new ArrayList<>();

            for (int i = 0; i < nodelist.getLength(); i++) {
                Node node = nodelist.item(i);

                System.out.println(node);

                if (node.getNodeType() == Node.ELEMENT_NODE) {

                    Element element = (Element) node;
                    if (element != null) {
                        System.out.println(element);
                        //System.out.println("Neptun kod: " + element.getAttribute("neptun"));
                        name = element.getElementsByTagName("name").item(0).getTextContent();
                        score = Integer.parseInt(element.getElementsByTagName("score").item(0).getTextContent());
                        id = Integer.parseInt(element.getAttribute("id"));

                        players.add(new Player(name, score, id));
                    }
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
