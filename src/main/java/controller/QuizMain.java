package controller;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.CountryDom.InitCountriesData;
import model.PlayerDom.Player;
import model.PlayerDom.PlayerHighscoreData;


public class QuizMain extends Application {
    public static Stage getProba() {
        return proba;
    }

    private static Stage proba;
    public static void main(String[] args)
    {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        proba = stage;
        stage.setTitle("QuizEu");
        AnchorPane a = (AnchorPane) FXMLLoader.load(getClass().getClassLoader().getResource("menu.fxml"));
        Scene scene1 = new Scene(a);
        stage.setScene(scene1);
        InitCountriesData.InitCountriesData();
        stage.show();

    }


}
