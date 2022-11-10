package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserSeeDistanceController implements Initializable{
    @FXML private Label city1, city2, distanceLabel;
    @FXML private Button back;
    public void back(ActionEvent event) throws IOException {
        Data.type=2;
        SceneController.getInstance().switchToUserScene(event);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        city1.setText(Data.A);
        city2.setText(Data.B);
        distanceLabel.setText(String.valueOf(Data.distance));
    }
}