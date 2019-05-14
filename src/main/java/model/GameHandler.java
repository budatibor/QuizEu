package model;

import controller.QuizMain;
import controller.GameController;
import controller.SavingController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Questions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 *  The class which handles the game and it's in consistent
 *  communication with the controller.
 *  This is where the game initializes, handles the data of countries, questions and players.
 *  The player has 3 lives and each bad choice looses him one.
 *  The Handler is constantly generating new questions to be answered.
 *  At the end the game handler calclates the score and opens a new window where the player can save his score.
 */
public class GameHandler {
    /**
     * spree - how mony consecutive answers does the player have?
     */
    private int spree;
    /**
     * the current score of the player during a spree
     */
    private int currentScore;
    /**
     * lifes of the player
     */
    private int lifes;
    /**
     *  final score of the player
     */
    private int score;
    /**
     *  the question waiting to be answered
     */
    private Question actualQuestion;
    /**
     *  questions already answered
     */
    private List<Question> pastQuestions;
    /**
     *  the controller with which the handler communicates
     */
    private GameController gm;
    /**
     *  the controller where the player saves his score
     */
    private SavingController sc;

    /**
     * the boolean to check if it's a test or not
     */
    private boolean fx;

    /**
     * empty contructor
     */
    public GameHandler() {
    }

    /**
     * Retrieves the current question
     * @return Question the current question
     */
    public Question getActualQuestion() {
        return actualQuestion;
    }

    /**
     * retrieves the score during the spree
     * @return the score during the spree
     */
    public int getCurrentScore() {
        return currentScore;
    }

    /**
     * Retrieves the spree of the player
     * @return int , spree of the player
     */
    public int getSpree() {
        return spree;
    }

    /**
     * It's where the game starts. Storeing the refference of the controller and checking if its a test or not.
     * All the variables are initializes for the game to start.
     * @param gm game controller
     * @param fx test or not
     */
    public GameHandler(GameController gm, boolean fx) {
        this.gm = gm;
        pastQuestions = new ArrayList<Question>();
        spree = 0;
        lifes = 3;
        score = 0;
        currentScore = 0;
        this.fx = fx;


        initialize(fx);
    }

    /**
     * Retrieves the score of the player
     * @return int , score of the player
     */
    public int getScore() {
        return score;
    }

    /**
     * Retrieves the number of lives of the player
     * @return int lifes of the player
     */
    public int getLifes() {
        return lifes;
    }

    /**
     * sts up the communication with the controller to save the players score after the game
     * @throws IOException
     */
    public void saveScoreToDatabase() throws IOException {

        sc = new SavingController();
        Stage stage = QuizMain.getProba();

        FXMLLoader fl = new FXMLLoader(getClass().getClassLoader().getResource("saving.fxml"));

        fl.setController(sc);

        AnchorPane a = fl.load();

        Scene scene1 = new Scene(a);

        stage.setScene(scene1);

        stage.show();

        sc.changeScoreLabel(getScore());
    }

    /**
     * Checks if the players answer is correct. If so adds 1 to spree and doesn't substract from lives.
     * If the answer is incorrect the sprre sets to zero and currentScore ads to Score
     * @param idx button inde pressed by the player
     * @throws IOException
     */
    public void isCorrect(int idx) throws IOException {
        if (actualQuestion.getIdx() == idx) {
            spree++;
            currentScore += actualQuestion.getPoint();
            initialize(fx);

        } else {
            score += spree * currentScore;
            currentScore = 0;
            lifes--;
            spree = 0;
            if (lifes > 0)
                initialize(fx);
            else {
                System.out.println(getScore());
                saveScoreToDatabase();
                //QuizMain.getProba().close();
            }

        }

    }

    /**
     * Here is where the communication with the controller is maintained.
     * It generates a new question and ads the old want to the past questions list
     * @param fx boolean if it's a test or not
     */
    public void initialize(boolean fx) {
        Random rand = new Random();
        switch (rand.nextInt(5)) {
            case 0:
                actualQuestion = new QuestionCountry();
                break;
            case 1:
                actualQuestion = new QuestionCapital();
                break;
            case 2:
                actualQuestion = new QuestionDensity();
                break;
            case 3:
                actualQuestion = new QuestionArea();
                break;
            case 4:
                actualQuestion = new QuestionPopulation();
                break;
        }

        pastQuestions.add(actualQuestion);
        if(fx) {
            gm.upload(this);
        }
    }
}
