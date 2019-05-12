package controller;

import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import model.PlayerDom.Player;
import model.PlayerDom.PlayerHighscoreData;


public class savingController {

    public TextField playerName;
    public Label scoreLabel;

    public void changeScoreLabel(int score)
    {
        scoreLabel.setText(String.valueOf(score));
    }

    //TextField playerName = new TextField();
    public void savingScore(MouseEvent mouseEvent) {
        if(playerName != null){
            PlayerHighscoreData.insertIntoDatabase(new Player(playerName.getText(),Integer.parseInt(scoreLabel.getText())));
            QuizMain.getProba().close();
        }

    }
}
