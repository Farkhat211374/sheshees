package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.w3c.dom.Text;

import java.sql.Connection;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class userMessageController {

    @FXML private Button submitButton;
    @FXML private TextField messageTextField;
    @FXML private Label answerLabel;

    public void submitButtonOnAction(ActionEvent event){
        if(messageTextField.getText().isBlank()==true){
            answerLabel.setText("Write a message!");
        }else{

            DBC connectNow = new DBC();
            Connection connectionDB = connectNow.getConnection();

            DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
            LocalDateTime now = LocalDateTime.now();

            String insertFields = "INSERT INTO admin_notify(n_message, username, message_date) VALUES ";
            String insertValues = "('"+ messageTextField.getText() + "','" + UserDate.first_name +" "+UserDate.last_name + "','"  + dateFormat.format(now) +"')";
            String insertToRegister = insertFields + insertValues;

            try {
                Statement statement = connectionDB.createStatement();
                statement.executeUpdate(insertToRegister);

            }catch (Exception e){
                e.printStackTrace();
                e.getCause();

            }


            answerLabel.setText("The message has been sent. Wait for a response!");
        }
    }


}
