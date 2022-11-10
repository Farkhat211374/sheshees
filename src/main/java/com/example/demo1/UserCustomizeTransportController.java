package com.example.demo1;

import com.example.demo1.Basic.CarFactory;
import com.example.demo1.Basic.PlaneFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserCustomizeTransportController implements Initializable {
    FxmlLoader Object = new FxmlLoader();
    @FXML private VBox decoration;
    @FXML private Button customizeButton, carButton, planeButton;
    private int type=1;
    public void choose(ActionEvent event){
        Pane view;
        if(event.getSource().equals(carButton)){
            carButton.setStyle("-fx-background-color:#0099cc");
            planeButton.setStyle("-fx-background-color:#99cc66");
            view = Object.getPage("nurUserHomeCarDecoration.fxml");
            type=1;
        }else{
            planeButton.setStyle("-fx-background-color:#0099cc");
            carButton.setStyle("-fx-background-color:#99cc66");
            view = Object.getPage("nurUserHomePlaneDecoration.fxml");
            type=2;
        }
        decoration.getChildren().remove(0);
        decoration.getChildren().add(view);
    }
    public void setCustomizeButton(ActionEvent event) throws IOException {
        Data.type=2;
        if(type==1) Data.car = CarFactory.startFactory();
        else if(type==2) Data.plane = PlaneFactory.startFactory();
        SceneController.getInstance().switchToUserScene(event);
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Pane view = Object.getPage("nurUserHomeCarDecoration.fxml");
        decoration.getChildren().add(view);
    }
}
