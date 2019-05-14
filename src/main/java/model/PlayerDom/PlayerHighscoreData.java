package model.PlayerDom;
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


/**
 * PlayerHigscoreData class is a static class where I work with DOM database
 * to store and extract data about players who played the game and it also
 * has two methods for these purposes.
 */
public class PlayerHighscoreData {
    /**
     * List where the data of the players are stored.
     * In this list the players are put in with an id.
     */
    private static ArrayList<Player> players;

    /**
     * This method also extracts data from a Dom Database so it can add the new
     * player to the end of its records. This is where the player (or the game)
     * gets an id that is equal with the number of records + 1.
     * @param p, player data waiting to be stored.
     */
    public static void insertIntoDatabase(@org.jetbrains.annotations.NotNull Player p) {
        try {
            //File input = new File(PlayerHighscoreData.class.getClassLoader().getResource("players.xml").getFile());
            File input = new File("players.xml");
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();

            Document document = db.parse(input);
            document.getDocumentElement().normalize();
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

    /**
     * This is where the data of the players are extracted from DOM.
     * At this faze the it's using the Player classes constructor with three parameters,
     * because the id is extracted as well. It's searching for the player element to find
     * these data.
     * @return ArrayList&lt;Player&gt; the list of players whom played the game
     */
    public static ArrayList<Player> extractFromDatabase() {
        try {

            String name;
            int score;
            int id;

            //File input =new File(PlayerHighscoreData.class.getClassLoader().getResource("players.xml").getFile());
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
