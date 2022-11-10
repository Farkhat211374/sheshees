package com.example.demo1;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.ResourceBundle;

public class adminHomeController implements Initializable {

    @FXML private VBox vboxField;
    @FXML private ScrollPane sp_main;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getMessages();
    }

    private void getMessages(){

        vboxField.heightProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
                sp_main.setVvalue((Double) newValue);
            }
        });
        handle();
    }

    private void handle(){
        DBC connectNow = new DBC();
        Connection connectionDB = connectNow.getConnection();

        try {
            ResultSet queryResultUser = connectionDB.createStatement().executeQuery("SELECT * FROM users where login != 'Admin@gmail.com' order by user_id desc");

            int id = 1;
            while (queryResultUser.next()){
                retrievingData(id,queryResultUser.getString(2),queryResultUser.getString(3),queryResultUser.getString(4),
                        queryResultUser.getString(6), queryResultUser.getDate(7));
                System.out.println("Every thing ok!");
                id++;
            }



        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
    }

    private void retrievingData(int id, String firstname,String lastname, String login, String status, Date unban_date){

        String message = id + "| full name: " + firstname + " " + lastname + " | email: " + login + " | status: " + status+ " | unban date: " + unban_date;

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.CENTER_LEFT);
        hbox.setPadding(new Insets(5,10,10,20));

        Text text = new Text(message);
        TextFlow textFlow = new TextFlow(text);
        textFlow.setPadding(new Insets(10,20,10,20));
        textFlow.setStyle("-fx-color: rgb(239,242,255); -fx-background-color: rgb(93,93,93); -fx-background-radius:5px");
        text.setFill(Color.color(0.934,0.945,0.996));


        hbox.getChildren().add(textFlow);
        vboxField.getChildren().add(hbox);
    }

}
