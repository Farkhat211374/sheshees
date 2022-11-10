package com.example.demo1;

import com.example.demo1.models.Notification;
import javafx.application.Platform;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import org.controlsfx.control.Notifications;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class UserController implements Initializable {
    @FXML private ImageView homeTab;
    @FXML private BorderPane mainPane;
    @FXML private ImageView messengeTab;
    @FXML private ImageView notificationTab;
    @FXML private ImageView closeTab;
    @FXML private ImageView settingsTab;
    @FXML private Label usernameLabel;
    @FXML private Button logoutButton;

    // Buttons Status
    boolean homeTabStatus = false;
    boolean notificationTabStatus = false;
    boolean settingsTabStatus = false;
    boolean messengerTabStatus = false;

    @FXML private Label warningLabel;
    public void handleHomeAction(){
        FxmlLoader Object = new FxmlLoader();
        Pane view = Object.getPage("nurUserHomeScene.fxml");
        mainPane.setCenter(view);
        homeTab.setStyle("-fx-opacity: 100%");
/*        ObservableList<Node> list = view.getChildren();
        for (Node node:
             list) {
            System.out.println(node);
        }*/
        if(Data.type==1) {
            Pane view2 = Object.getPage("nurUserHomeEnterDistance.fxml");
            view.getChildren().add(view2);
            view2.setStyle("-fx-translate-x: 150");
        }else if(Data.type==2){
            Pane view2 =Object.getPage("nurUserHomeChooseOption.fxml");
            view.getChildren().add(view2);
            view2.setStyle("-fx-translate-x: 150");
        }else if(Data.type==3){
            Pane view2 = Object.getPage("nurUserHomeCustomizeTransport.fxml");
            view.getChildren().add(view2);
            view2.setStyle("-fx-translate-x: 150");
        }else if(Data.type==4){
            Data.optionType=1;
            Pane view2 = Object.getPage("nurUserHomeAnswerPage.fxml");
            view.getChildren().add(view2);
        }else if(Data.type==5){
            Data.optionType=2;
            Pane view2 = Object.getPage("nurUserHomeAnswerPage.fxml");
            view.getChildren().add(view2);
        }else if(Data.type==6){
            Pane view2 = Object.getPage("nurUserSeeDistance.fxml");
            view.getChildren().add(view2);
            view2.setStyle("-fx-translate-x: 150");
        }

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
        Pane view = Object.getPage("UserNotificationTabScene.fxml");
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
        Pane view = Object.getPage("UserSettingScene.fxml");
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

    public void handleMessangeAction(){
        FxmlLoader Object = new FxmlLoader();
        Pane view = Object.getPage("UserMessageScene.fxml");
        mainPane.setCenter(view);
        settingsTab.setStyle("-fx-opacity: 100%");

        notificationTabStatus = false;
        homeTabStatus = false;
        messengerTabStatus = true;

        settingsTabStatus = false;

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
        getUser();

    }


    /** Notifications **/

    private void getNotification(){
        String sql = "SELECT * FROM curent_notify";
        try {
            DBC connectNow = new DBC();
            Connection connectionDB = connectNow.getConnection();
            ResultSet queryResultUser = connectionDB.createStatement().executeQuery(sql);



            while (queryResultUser.next()){
                if(queryResultUser.getString(1).isBlank()==false) {
                    String messenger = (queryResultUser.getString(1));
                    showNotification(messenger);
                }
            }

            //queryResultUser = connectionDB.createStatement().executeQuery("TRUNCATE curent_notify");


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();

        }
    }

    private void showNotification(String messenger){
        try {
            Image image = new Image("C:\\my\\Web-work\\2022\\designPatternn-main\\src\\main\\resources\\com\\icons\\messeng.png");
            Notifications notificationBuilder = Notifications.create()
                    .title("New notification")
                    .text(messenger)
                    .graphic(new ImageView(image))
                    .hideAfter(Duration.seconds(5))
                    .position(Pos.BOTTOM_RIGHT);

            notificationBuilder.showConfirm();

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

    public void getUser(){
        usernameLabel.setText(UserDate.first_name + " " + UserDate.last_name);
    }

    public void logoutButtonOnAction(ActionEvent event){
        ActiveCookie cookie = new ActiveCookie();
        cookie.deleteCookie();

        Stage stage = new Stage();
        stage.close();
        Platform.exit();
    }


}
