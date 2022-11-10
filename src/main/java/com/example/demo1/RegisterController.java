package com.example.demo1;

import com.example.demo1.AdminNotify.AdminNotification;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.sql.*;
import java.sql.PreparedStatement;
import java.util.ResourceBundle;

public class RegisterController implements Initializable{

    @FXML private Button closeButton;
    @FXML private Button registerButton;
    @FXML private Label registrationMessageLabel;
    @FXML private PasswordField setPasswordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private Label confirmPasswordLabel;
    @FXML private TextField firstnameTextField;
    @FXML private TextField lastnameTextField;
    @FXML private TextField loginTextField;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //nothing already!
    }

    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }

    public void registerButtonOnAction(ActionEvent event){

        if(setPasswordField.getText().equals(confirmPasswordField.getText())){
            registerUser(event);
            confirmPasswordLabel.setText("");
        }else {
            confirmPasswordLabel.setText("password does not match");
        }

    }

    public void registerUser(ActionEvent event){
        DBC connection = new DBC();
        Connection connectDB = connection.getConnection();

        String firstName = firstnameTextField.getText();
        String lastName = lastnameTextField.getText();
        String login = loginTextField.getText();
        String password = setPasswordField.getText();
        String status = "available";

        String insertFields = "INSERT INTO users(first_name, last_name, login, password, status) VALUES ";
        String insertValues = "('"+ firstName + "','" + lastName + "','" + login + "','" + password + "','" + status +"')";
        String insertToRegister = insertFields + insertValues;

        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToRegister);
            //registrationMessageLabel.setText("User has been registered successfully!");

            /** -- Calling Methods to Observer Pattern -- **/

            AdminNotification.userCreated(firstnameTextField.getText(), lastnameTextField.getText(), loginTextField.getText());

            /** -- -- -- -- -- -- -- -- -- -- -- -- -- -- **/

            UserDate.first_name = firstnameTextField.getText();
            UserDate.last_name = lastnameTextField.getText();
            UserDate.login = loginTextField.getText();
            UserDate.password = setPasswordField.getText();

            ActiveCookie cookie = new ActiveCookie();
            cookie.createCookie();

            SceneController scene = SceneController.getInstance();
            scene.switchToSplashScreenScene(event);

        }catch (Exception e){
            registrationMessageLabel.setText("This email already exist!");
            e.printStackTrace();
            e.getCause();
        }


    }
}
