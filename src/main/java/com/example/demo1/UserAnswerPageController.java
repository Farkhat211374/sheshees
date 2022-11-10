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

public class UserAnswerPageController implements Initializable {
    @FXML private HBox hBox1;
    @FXML private Label carDescription, distanceLabel, moneyLabel, timeLabel;
    public void back(ActionEvent event) throws IOException {
        Data.type=2;
        SceneController.getInstance().switchToUserScene(event);
    }
    public void choose(ActionEvent event){
        distanceLabel.setText(String.valueOf(Data.distance));
        if(Data.optionType==1){
            if(Data.transportType==1){
                carDescription.setText(Data.car.getDescription());
                Data.transport.setCar(Data.car);
            }else{
                carDescription.setText(Data.plane.getDescription());
                Data.transport.setPlane(Data.plane);
            }
            moneyLabel.setText(String.valueOf(Data.transport.money(Data.distance)));
            timeLabel.setText(String.valueOf(Data.transport.displacement(Data.distance)));
        }else{
            if(Data.optionFCType==1){
                Data.transport.setCar(Data.car);
                double minMoney=Data.transport.money(Data.distance);
                Data.transport.setPlane(Data.plane);
                if(minMoney>Data.transport.money(Data.distance)){
                    minMoney=Data.transport.money(Data.distance);
                    carDescription.setText(Data.plane.getDescription());
                }else{
                    carDescription.setText(Data.car.getDescription());
                    Data.transport.setCar(Data.car);
                }
                moneyLabel.setText(String.valueOf(minMoney));
                timeLabel.setText(String.valueOf(Data.transport.displacement(Data.distance)));
            }else{
                Data.transport.setCar(Data.car);
                double minTime=Data.transport.displacement(Data.distance);
                Data.transport.setPlane(Data.plane);
                if(minTime>Data.transport.displacement(Data.distance)){
                    minTime=Data.transport.displacement(Data.distance);
                    carDescription.setText(Data.plane.getDescription());
                }else{
                    carDescription.setText(Data.car.getDescription());
                    Data.transport.setCar(Data.car);
                }
                moneyLabel.setText(String.valueOf(Data.transport.money(Data.distance)));
                timeLabel.setText(String.valueOf(minTime));
            }
        }

    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        FxmlLoader Object = new FxmlLoader();
        Pane view2;
        if(Data.optionType==1) view2 = Object.getPage("nurUserHomeChooseTransport.fxml");
        else view2 = Object.getPage("nurUserHomeChooseOptionFC.fxml");
        hBox1.getChildren().add(view2);
        view2.setStyle("-fx-translate-x: 150");
//        System.out.println(view2.getTranslateX()+" | "+view2.getWidth()+" | "+view2.getStyle());
    }
}
