package controller;

import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import model.GameHandler;


import java.io.IOException;



public class GameController {
    public Button firstChoice;
    public Button secondChoice;
    public Button thirdChoice;
    public Button fourthChoice;
    public Label question;
    public Label liveLabel;
    public Label scoreLabel;
    public Label comboLabel;
    GameHandler gameHandler;


    public void upload(GameHandler gameHandler, int goodAnswer) {
        this.gameHandler=gameHandler;
        firstChoice.setText(gameHandler.getActualQuestion().getOportunities().get(0));
        secondChoice.setText(gameHandler.getActualQuestion().getOportunities().get(1));
        thirdChoice.setText(gameHandler.getActualQuestion().getOportunities().get(2));
        fourthChoice.setText(gameHandler.getActualQuestion().getOportunities().get(3));
        question.setText(gameHandler.getActualQuestion().getText());
        liveLabel.setText(String.valueOf(gameHandler.getLifes()));
        scoreLabel.setText(String.valueOf(gameHandler.getScore()));
        if(goodAnswer == 0)
            question.setStyle("-fx-background-color:#c23f3f");
        if(goodAnswer == 1)
            question.setStyle("-fx-background-color:#94cc81");
        if(gameHandler.getCurrentScore() != 0)
            comboLabel.setText("+" + gameHandler.getCurrentScore() + " X " + gameHandler.getSpree() );
    }

    public void firstChoiceClicked(MouseEvent mouseEvent) throws IOException{
        gameHandler.isCorrect(0);
    }

    public void secondChoiceClicked(MouseEvent mouseEvent) throws IOException {
        gameHandler.isCorrect(1);
    }

    public void thirdChoiceClicked(MouseEvent mouseEvent) throws IOException {
        gameHandler.isCorrect(2);
    }

    public void fourthChoiceClicked(MouseEvent mouseEvent) throws IOException {
        gameHandler.isCorrect(3);
    }
}
