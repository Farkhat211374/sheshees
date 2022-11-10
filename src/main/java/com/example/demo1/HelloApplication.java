package com.example.demo1;

import com.example.demo1.AdminNotify.AdminNotification;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        ActiveCookie cookie = new ActiveCookie();

        if(cookie.checkCookie()==true){

            if(UserDate.login.equals("Admin@gmail.com")){
                Parent root = FXMLLoader.load(getClass().getResource("adminScene.fxml"));
                Scene scene = new Scene(root, 1024, 600);
                stage.getIcons().add(new Image(String.valueOf("C:\\my\\Web-work\\2022\\designPatternn-main\\src\\main\\resources\\com\\images\\3gisLogo.png")));
                stage.setTitle("3Gis");
                stage.setScene(scene);
                stage.show();

            }else{
                //if()



                Parent root = FXMLLoader.load(getClass().getResource("splashScreen.fxml"));
                Scene scene = new Scene(root, 600, 330);
                stage.getIcons().add(new Image(String.valueOf("C:\\my\\Web-work\\2022\\designPatternn-main\\src\\main\\resources\\com\\images\\3gisLogo.png")));
                stage.setTitle("3Gis");
                stage.setScene(scene);
                stage.show();
            }

        }else {
            Parent root = FXMLLoader.load(getClass().getResource("login.fxml"));
            Scene scene = new Scene(root, 520, 400);
            stage.getIcons().add(new Image(String.valueOf("C:\\my\\Web-work\\2022\\designPatternn-main\\src\\main\\resources\\com\\images\\3gisLogo.png")));
            stage.setTitle("3Gis");
            stage.setScene(scene);
            stage.show();

        }
    }

    public static void main(String[] args) {
        launch();
    }
}