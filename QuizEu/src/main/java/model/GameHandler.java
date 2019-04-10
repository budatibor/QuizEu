package model;

import controller.QuizMain;
import controller.gameController;
import model.Questions.*;

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

    public Question getActualQuestion() {
        return actualQuestion;
    }

    public int getCurrentScore() {
        return currentScore;
    }

    public int getSpree() {
        return spree;
    }

    public GameHandler(gameController gm) {
        this.gm = gm;
        pastQuestions = new ArrayList<Question>();
        spree = 0;
        lifes = 3;
        score = 0;
        currentScore = 0;

        initialize();
    }

    public int getScore() {
        return score;
    }

    public int getLifes() {
        return lifes;
    }

    public void isCorrect(int idx) {
        if (actualQuestion.getIdx() == idx) {
            spree++;
            currentScore+=actualQuestion.getPoint();
            initialize();

        } else {
            score+=spree*currentScore;
            currentScore=0;
            lifes--;
            spree = 0;
            if (lifes > 0)
                initialize();
            else{
                System.out.println(getScore());

                QuizMain.getProba().close();
            }

        }

    }

    public void initialize() {
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
        gm.upload(this);

    }
}
