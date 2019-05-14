package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.PlayerDom.Player;
import model.PlayerDom.PlayerHighscoreData;

import java.io.IOException;


public class SavingController {

    public TextField playerName;
    public Label scoreLabel;

    public void changeScoreLabel(int score)
    {
        scoreLabel.setText(String.valueOf(score));
    }

    //TextField playerName = new TextField();
    public void savingScore(MouseEvent mouseEvent) throws IOException {
        if(playerName != null){
            PlayerHighscoreData.insertIntoDatabase(new Player(playerName.getText(),Integer.parseInt(scoreLabel.getText())));
            Stage stage = QuizMain.getProba();

            FXMLLoader fl = new FXMLLoader(getClass().getClassLoader().getResource("menu.fxml"));

            AnchorPane a = fl.load();

            Scene scene1 = new Scene(a);

            stage.setScene(scene1);

            stage.show();
        }

    }
}
