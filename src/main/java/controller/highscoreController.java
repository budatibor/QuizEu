package controller;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.PlayerDom.Player;
import model.PlayerDom.PlayerHighscoreData;

import java.io.IOException;


public class highscoreController {

    public TableView scoreTable;
    public TableColumn<Player, String> nameCollumn;
    public TableColumn<Player, String> scoreCollumn;

    public void updateTable()
    {
        nameCollumn.setCellValueFactory(y->new SimpleStringProperty(y.getValue().getName()));
        scoreCollumn.setCellValueFactory(y->new SimpleStringProperty(String.valueOf(y.getValue().getScore())));
        scoreTable.setItems(FXCollections.observableList(PlayerHighscoreData.extractFromDatabase()));
        scoreTable.setEditable(false);
    }

    public void backClick(MouseEvent mouseEvent) throws IOException {

        Stage stage = QuizMain.getProba();

        FXMLLoader fl = new FXMLLoader(getClass().getClassLoader().getResource("menu.fxml"));

        AnchorPane a = fl.load();

        Scene scene1 = new Scene(a);

        stage.setScene(scene1);

        stage.show();

    }
}
