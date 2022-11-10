package com.example.demo1;

import com.example.demo1.Basic.CarFactory;
import com.example.demo1.Basic.Transport;
import com.example.demo1.Basic.TransportFactory;
import com.example.demo1.ConcreteObjects.Car;
import com.example.demo1.DataBase.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
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
import java.util.Objects;
import java.util.ResourceBundle;
import java.util.Scanner;

public class UserChooseTransportController {

    @FXML Button carButton, planeButton;
    public void choose(ActionEvent event){
        if(event.getSource().equals(carButton)){
            Data.transportType=1;
            carButton.setStyle("-fx-background-color:#0099cc");
            planeButton.setStyle("-fx-background-color:#99cc66");
        }else{
            Data.transportType=2;
            planeButton.setStyle("-fx-background-color:#0099cc");
            carButton.setStyle("-fx-background-color:#99cc66");
        }
    }
}
