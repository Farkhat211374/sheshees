package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;

public class userSettingsCotroller implements Initializable {

    @FXML private TextField firstnameTextField;
    @FXML private TextField lastnameTextField;
    @FXML private TextField passwordTextField;
    @FXML private Label statusLabel;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        firstnameTextField.setText(UserDate.first_name);
        lastnameTextField.setText(UserDate.last_name);
        passwordTextField.setText(UserDate.password);
    }

    public void ChangeButtonOnAction(ActionEvent event){
        if(firstnameTextField.getText().equals(UserDate.first_name) && lastnameTextField.getText().equals(UserDate.last_name) &&
                passwordTextField.getText().equals(UserDate.password)) {

            statusLabel.setText("Please, write new to change it.");
        }else {
            changeRecords(event);
            UserDate.first_name = firstnameTextField.getText();
            UserDate.last_name = lastnameTextField.getText();
            UserDate.password = passwordTextField.getText();

            try {
                SceneController scene = SceneController.getInstance();
                scene.switchToUserMainScene(event);


            }catch (Exception e){
                e.printStackTrace();
                e.getCause();
            }

            statusLabel.setText("Records was changed successfully!");
        }
    }

    private void changeRecords(ActionEvent event){
        DBC connectNow = new DBC();
        Connection connectionDB = connectNow.getConnection();

        String sqlStatement = String.format("UPDATE users SET first_name= '%s', last_name = '%s', password = '%s'  Where first_name = '%s' AND last_name = '%s' AND password = '%s'",
                firstnameTextField.getText(),lastnameTextField.getText(),passwordTextField.getText(),UserDate.first_name,UserDate.last_name,UserDate.password);

        String query = sqlStatement;
        try {
            Statement statement = connectionDB.createStatement();
            statement.executeUpdate(query);

            System.out.println("Data Updated");

        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }
    }

}
