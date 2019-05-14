package model.PlayerDom;


/**
 * This is the representation of the player class.
 */
public class Player {

    private String name;
    private int score;
    private int id;

    /**
     * This is the first contructor of the player class where there are two parameters
     * @param name String, the name of the player
     * @param score int, the score of the player
     */
    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    /**
     * This is the second contructor of the player class where there are three parameters
     * @param name String, the name of the player
     * @param score int, the score of the player
     * @param id int, the identity number of the player
     */
    public Player(String name, int score, int id) {
        this.name = name;
        this.score = score;
        this.id = id;
    }

    /**
     * Retrieves the name of the player
     * @return String, name of the player
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the socre of the player
     * @return int, score of the player
     */
    public int getScore() {
        return score;
    }

    /**
     * The toString() method of the player class
     * @return String, information about the player
     */
    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", score=" + score +
                ", id=" + id +
                '}';
    }
}
