package com.example.demo1;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class adminNotificationList implements Initializable {


    @FXML private ListView<String> listNotification;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        load();
    }

///////////////////////////////////////////////////////////////////////////////
    ObservableList<String> mesList = FXCollections.observableArrayList();

    private void load() {
        DBC connectNow = new DBC();
        Connection connectionDB = connectNow.getConnection();
        String sql = "SELECT * FROM admin_notification order by notification_id desc limit 6";
        try {
            ResultSet queryResultUser = connectionDB.createStatement().executeQuery(sql);


            while (queryResultUser.next()){
                mesList.add("Created new user, (" + queryResultUser.getString(2) + ")\n"
                + "whose email is - (" + queryResultUser.getString(3) + ")\n"
                + "date: " + queryResultUser.getString(4) + "\n");
            }

            listNotification.setItems(mesList);


        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
    }

}
