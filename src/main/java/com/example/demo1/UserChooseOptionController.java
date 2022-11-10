package com.example.demo1;

import com.example.demo1.Basic.CarFactory;
import com.example.demo1.Basic.Transport;
import com.example.demo1.Basic.TransportFactory;
import com.example.demo1.ConcreteObjects.Car;
import com.example.demo1.DataBase.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class UserChooseOptionController {
    //FuelType
    @FXML private Button changeDistance;
    @FXML private Button customizeTransport;
    @FXML private Button typeTransport;
    @FXML private Button chooseOptionFC;
    @FXML private Button distance;

    public void chooseOption(ActionEvent event) throws IOException {
        if(event.getSource().equals(changeDistance)){
            Data.type=1;
        }else if(event.getSource().equals(customizeTransport)){
            Data.type=3;
        }else if(event.getSource().equals(typeTransport)){
            Data.type=4;
        }else if(event.getSource().equals(chooseOptionFC)){
            Data.type=5;
        }else if(event.getSource().equals(distance)){
            Data.type=6;
        }
        SceneController.getInstance().switchToUserScene(event);
    }
}
