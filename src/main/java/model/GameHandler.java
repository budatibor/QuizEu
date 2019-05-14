package model;

import controller.QuizMain;
import controller.gameController;
import controller.savingController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Questions.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameHandler {
    private int spree;
    private int currentScore;
    private int lifes;
    private int score;
    private Question actualQuestion;
    private List<Question> pastQuestions;
    private controller.gameController gm;
    private controller.savingController sc;
    private boolean fx;

    public GameHandler() {
    }

    public Question getActualQuestion() {
        return actualQuestion;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public int getSpree() {
        return spree;
    }

    public GameHandler(gameController gm, boolean fx) {
        this.gm = gm;
        pastQuestions = new ArrayList<Question>();
        spree = 0;
        lifes = 3;
        score = 0;
        currentScore = 0;
        this.fx = fx;


        initialize(fx);
    }


    public int getScore() {
        return score;
    }

    public int getLifes() {
        return lifes;
    }

    public void saveScoreToDatabase() throws IOException {

        sc = new savingController();
        Stage stage = QuizMain.getProba();

        FXMLLoader fl = new FXMLLoader(getClass().getClassLoader().getResource("saving.fxml"));

        fl.setController(sc);

        AnchorPane a = fl.load();

        Scene scene1 = new Scene(a);

        stage.setScene(scene1);

        stage.show();

        sc.changeScoreLabel(getScore());
    }

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
