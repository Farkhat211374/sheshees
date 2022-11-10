package com.example.demo1;

import com.example.demo1.models.Notification;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;
import org.controlsfx.control.cell.MediaImageCell;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class AdminController implements Initializable {


    @FXML private ImageView homeTab;
    @FXML private BorderPane mainPane;
    @FXML private ImageView messengeTab;
    @FXML private ImageView notificationTab;
    @FXML private ImageView closeTab;
    @FXML private ImageView settingsTab;

    // Buttons Status
    boolean homeTabStatus = false;
    boolean notificationTabStatus = false;
    boolean settingsTabStatus = false;
    boolean messengerTabStatus = false;


    public void handleHomeAction(){
        FxmlLoader Object = new FxmlLoader();
        Pane view = Object.getPage("adminHomeScene.fxml");
        mainPane.setCenter(view);
        homeTab.setStyle("-fx-opacity: 100%");

        notificationTabStatus = false;
        settingsTabStatus = false;
        messengerTabStatus = false;

        homeTabStatus = true;

        homeOnMouseExited();
        notificationOnMouseExited();
        settingsOnMouseExited();
        MessengerOnMouseExited();
        closeOnMouseExited();
    }

    public void handleMessengerAction(){
        FxmlLoader Object = new FxmlLoader();
        Pane view = Object.getPage("adminMessengerScene.fxml");
        mainPane.setCenter(view);
        homeTab.setStyle("-fx-opacity: 100%");

        notificationTabStatus = false;
        settingsTabStatus = false;
        messengerTabStatus = true;
        homeTabStatus = false;

        homeOnMouseExited();
        notificationOnMouseExited();
        settingsOnMouseExited();
        MessengerOnMouseExited();
        closeOnMouseExited();
    }

    /** Tab Animations **/

    // Home tab
    public void homeOnMouseEntered(){
        homeTab.setStyle("-fx-opacity: 100%");
    }

    public void homeOnMouseExited(){
        if(homeTabStatus!=true)
        homeTab.setStyle("-fx-opacity: 60%");
    }

    //Notifications tab
    public void notificationOnMouseEntered(){
        notificationTab.setStyle("-fx-opacity: 100%");
    }

    public void notificationOnMouseExited(){
        if(notificationTabStatus!=true)
        notificationTab.setStyle("-fx-opacity: 60%");
    }

    //settings tab
    public void settingsOnMouseEntered(){
        settingsTab.setStyle("-fx-opacity: 100%");
    }

    public void settingsOnMouseExited(){
        if(settingsTabStatus!=true)
        settingsTab.setStyle("-fx-opacity: 60%");
    }

    //messenger tab
    public void MessengerOnMouseEntered(){
        messengeTab.setStyle("-fx-opacity: 100%");
    }

    public void MessengerOnMouseExited(){
        if(messengerTabStatus!=true)
        messengeTab.setStyle("-fx-opacity: 60%");
    }

    //close tab
    public void closeOnMouseEntered(){
        closeTab.setStyle("-fx-opacity: 100%");
    }

    public void closeOnMouseExited(){
        closeTab.setStyle("-fx-opacity:60%");
    }


    /** ===================================== **/

    public void handleNotificationAction(){
        FxmlLoader Object = new FxmlLoader();
        Pane view = Object.getPage("adminNotificationTabScene.fxml");
        mainPane.setCenter(view);
        notificationTab.setStyle("-fx-opacity: 100%");

        notificationTabStatus = true;

        settingsTabStatus = false;
        messengerTabStatus = false;
        homeTabStatus = false;

        homeOnMouseExited();
        notificationOnMouseExited();
        settingsOnMouseExited();
        MessengerOnMouseExited();
        closeOnMouseExited();
    }

    public void handleSettingsAction(){
        FxmlLoader Object = new FxmlLoader();
        Pane view = Object.getPage("AdminsSettingsScene.fxml");
        mainPane.setCenter(view);
        settingsTab.setStyle("-fx-opacity: 100%");

        notificationTabStatus = false;
        homeTabStatus = false;
        messengerTabStatus = false;

        settingsTabStatus = true;

        homeOnMouseExited();
        notificationOnMouseExited();
        settingsOnMouseExited();
        MessengerOnMouseExited();
        closeOnMouseExited();
    }

    public void handleCloseAction(){
        Stage stage = new Stage();
        stage.close();
        Platform.exit();
    }


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        handleHomeAction();
        getNotification();
    }


    /** Notifications **/

    private void getNotification() {
        String sql = "SELECT * FROM admin_notify order by n_id desc";
        try {
            DBC connectNow = new DBC();
            Connection connectionDB = connectNow.getConnection();
            ResultSet queryResultUser = connectionDB.createStatement().executeQuery(sql);

            String messenger = null;

            while (queryResultUser.next()) {
                    messenger = (queryResultUser.getString(2) + "\n"
                        + "from:  " + queryResultUser.getString(3) + "\n"
                        + "date: " + queryResultUser.getString(4) + "\n");
            }


            Image image = new Image("C:\\my\\Web-work\\2022\\designPatternn-main\\src\\main\\resources\\com\\icons\\close.png");
            Notifications notificationBuilder = Notifications.create()
                    .title("Created new User")
                    .text(messenger)
                    .graphic(new ImageView(image))
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT);

            notificationBuilder.showConfirm();


        } catch (Exception e) {
            e.printStackTrace();
            e.getCause();

        }


    }
}
