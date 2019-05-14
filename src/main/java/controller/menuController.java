package controller;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.GameHandler;

import java.io.IOException;

public class menuController {
    public void initQuiz(MouseEvent mouseEvent) throws IOException {
        //System.out.println("Amerre en jarok, lopnak a ciganyok");
        gameController gm = new gameController();

        Stage stage = QuizMain.getProba();

        FXMLLoader fl = new FXMLLoader(getClass().getClassLoader().getResource("game.fxml"));

        fl.setController(gm);

        AnchorPane a = fl.load();

        Scene scene1 = new Scene(a);

        stage.setScene(scene1);

        stage.show();

        GameHandler gh = new GameHandler(gm, true);

        // gm.upload();
    }

    public void openScoreboard(MouseEvent mouseEvent) throws IOException {

        highscoreController hc = new highscoreController();

        Stage stage = QuizMain.getProba();

        FXMLLoader fl = new FXMLLoader(getClass().getClassLoader().getResource("highscore.fxml"));

        fl.setController(hc);

        AnchorPane a = fl.load();

        Scene scene1 = new Scene(a);

        stage.setScene(scene1);

        stage.show();

        hc.updateTable();

    }
}
