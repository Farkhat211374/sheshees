package com.example.demo1;

import com.example.demo1.DataBase.DB;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;
import java.util.ResourceBundle;

public class adminSettingsController implements Initializable {

    ObservableList<String> statusList = FXCollections.observableArrayList("available", "ban", "deleted");
    ObservableList<String> usersList = FXCollections.observableArrayList();
    @FXML private ChoiceBox username;
    @FXML private ChoiceBox status;
    @FXML private Label warning;

    public void submitButtonOnAction(ActionEvent event){

        DBC connectNow = new DBC();
        Connection connectionDB = connectNow.getConnection();

        LocalDate unban_date;
        if(status.getValue().equals("ban")){
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "yyyy-dd-MM" );
            LocalDateTime now = LocalDateTime.now();
            LocalDate localDate = LocalDate.parse ( formatter.format(now) , formatter );
            LocalDate yearLater = localDate.plusYears ( 1 );
            System.out.println(yearLater);

            unban_date = yearLater;
        }else{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern ( "yyyy-dd-MM" );
            LocalDateTime now = LocalDateTime.now();
            LocalDate localDate = LocalDate.parse ( formatter.format(now) , formatter );
            LocalDate yearLater = localDate.plusYears ( -1 );
            System.out.println(yearLater);

            unban_date = yearLater;
        }

        String sqlStatement = String.format("UPDATE users SET status = '%s', unban_date = '%s' WHERE login = '%s'",
                status.getValue(),unban_date, username.getValue());
        String query = sqlStatement;

        try {
            Statement statement = connectionDB.createStatement();
            statement.executeUpdate(query);

            System.out.println("Status updated");
            warning.setText("Status was updated!");

        }catch (Exception e){
            e.getCause();
            e.printStackTrace();

        }

    }

    public void handleHomeAction(){
        username.setItems(usersList);
        status.setItems(statusList);
        username.setValue(usersList.get(0));
        status.setValue(statusList.get(0));

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        getUserList();
        handleHomeAction();
    }

    private void getUserList(){
        DBC connectNow = new DBC();
        Connection connectionDB = connectNow.getConnection();

        try {
            ResultSet queryResultUser = connectionDB.createStatement().executeQuery("SELECT * FROM users where login != 'Admin@gmail.com' order by user_id desc");
            while (queryResultUser.next()){
                usersList.add(queryResultUser.getString(4));
            }

        } catch (SQLException e) {
            e.printStackTrace();
            e.getCause();

        }
    }


}
