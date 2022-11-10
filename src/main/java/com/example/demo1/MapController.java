package com.example.demo1;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MapController {

    @FXML private TextField firstPointTextField;
    @FXML private TextField secondPointTextField;
    @FXML private Button submitButton;
    @FXML private Label answerLabel;

/*    public void submitButtonOnAction(ActionEvent event){
        int distance = Distance.Distance(firstPointTextField.getText(), secondPointTextField.getText());
        answerLabel.setText("Distance between " + firstPointTextField.getText() + " and " + secondPointTextField.getText() + " is - " + distance);

    }*/

}
