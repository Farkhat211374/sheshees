package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class adminMessengerController {

    @FXML private TextArea messengerArea;
    @FXML private Button submitButton;
    @FXML private Label statusLabel;

    public void submitButtonOnAction(ActionEvent event){
        if(messengerArea.getText().isBlank()==false){
            sendMessenger();
        }else{
            statusLabel.setText("Please enter your message");
        }
    }

    private void sendMessenger(){
        DBC connection = new DBC();
        Connection connectDB = connection.getConnection();

        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        String message = messengerArea.getText();

        String insertFields = "INSERT INTO user_notification(messages, date) VALUES ";
        String insertValues = "('"+ message + "','" + dateFormat.format(now) +"')";
        String insertToRegister = insertFields + insertValues;

        try {
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);

            statusLabel.setText("Success!");

        }catch (Exception e){
            statusLabel.setText("Something went wrong!");
            e.printStackTrace();
            e.getCause();

        }
    }


}
