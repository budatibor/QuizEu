package model.PlayerDom;

public class Player {
    private String name;
    private int score;
    private int id;

    public Player(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public Player(String name, int score, int id) {
        this.name = name;
        this.score = score;
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }


}
