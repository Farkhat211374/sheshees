package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.PasswordField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.io.IOException;

public class SceneController {
    public static SceneController uniqueSceneController;
    private SceneController(){}
    public static SceneController getInstance(){
        if(uniqueSceneController==null){
            uniqueSceneController = new SceneController();
        }
        return uniqueSceneController;
    }
    private Stage stage;
    private Scene scene;
    private Parent root;


    public void switchToRegisterScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("register.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 520, 600);
        stage.setTitle("3Gis");
        stage.setScene(scene);
        stage.show();
    }

    public void switchToAdminMainScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("adminScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 600);
        stage.setTitle("3Gis");
        stage.setScene(scene);
        stage.show();
    }

    public void switchToUserMainScene(KeyEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("userScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 600);
        stage.setTitle("3Gis");
        stage.setScene(scene);
        stage.show();
    }

    public void switchToUserMainScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("userScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 600);
        stage.setTitle("3Gis");
        stage.setScene(scene);
        stage.show();
    }

    public void switchToUserScene() throws IOException {
        stage.close();
        root = FXMLLoader.load(getClass().getResource("userScene.fxml"));
        scene = new Scene(root, 1024, 600);
        stage.setScene(scene);
        stage.show();
    }
    public void switchToUserScene(ActionEvent event) throws IOException {
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        root = FXMLLoader.load(getClass().getResource("userScene.fxml"));
        scene = new Scene(root, 1024, 600);
        stage.setTitle("3Gis");
        stage.setScene(scene);
        stage.show();
    }

    public void switchToSplashScreenScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("splashScreen.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 600, 330);
        stage.setTitle("3Gis");
        stage.setScene(scene);
        stage.show();
    }

    public void switchToBanedScene(ActionEvent event) throws IOException {
        root = FXMLLoader.load(getClass().getResource("banedScene.fxml"));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root, 1024, 600);
        stage.setTitle("3Gis");
        stage.setScene(scene);
        stage.show();
    }

}
