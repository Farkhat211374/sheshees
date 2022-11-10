package com.example.demo1;

import com.example.demo1.Basic.Program;
import com.example.demo1.DataBase.DB;
import com.example.demo1.models.Notification;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserEnterDistanceController implements Initializable {
    ObservableList<String> cityList = FXCollections.observableArrayList("Almaty", "Astana", "Shymkent", "Aktobe", "Karaganda", "Taraz", "Pavlodar", "Ust-kamenogorsk", "Semey", "Atyrau", "Kyzylorda", "Kostanai", "Uralsk", "Aktau");
    @FXML private ChoiceBox city1, city2;
    @FXML private Label warning;

    public void submitButtonOnAction(ActionEvent event) throws IOException {
        if(city1.getValue().equals(city2.getValue())){
            warning.setText("Cities can not be equal");
        }else{
            Data.A = (String) city1.getValue();
            Data.B = (String) city2.getValue();
            SceneController sceneController = SceneController.getInstance();
            Data.type = 2;
            Data.distance = DB.getInstance().routes(Data.A, Data.B);
            sceneController.switchToUserScene(event);
        }
    }
    public void handleHomeAction(){
        city1.setItems(cityList);
        city2.setItems(cityList);
        city1.setValue("Astana");
        city2.setValue("Almaty");
/*        cities.add("Astana");
        cities.add("Almaty");
        cities.add("Shymkent");
        cities.add("Aktobe");
        cities.add("Karaganda");
        cities.add("Taraz");
        cities.add("Pavlodar");
        cities.add("Ust-kamenogorsk");
        cities.add("Semey");
        cities.add("Atyrau");
        cities.add("Kyzylorda");
        cities.add("Kostanai");
        cities.add("Uralsk");
        cities.add("Aktau");*/
/*        FxmlLoader Object = new FxmlLoader();
        Pane view = Object.getPage("nurUserHomeScene.fxml");
        mainPane.setCenter(view);
        homeTab.setStyle("-fx-opacity: 100%");
        Pane view2 = Object.getPage("nurUserHomeChooseOption.fxml");
        view.getChildren().add(view2);

        notificationTabStatus = false;
        settingsTabStatus = false;
        messengerTabStatus = false;

        homeTabStatus = true;

        homeOnMouseExited();
        notificationOnMouseExited();
        settingsOnMouseExited();
        MessengerOnMouseExited();
        closeOnMouseExited();*/
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        handleHomeAction();
    }
}