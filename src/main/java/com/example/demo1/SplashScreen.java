package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;

import java.io.File;
import java.net.URL;
import java.security.MessageDigestSpi;
import java.util.ResourceBundle;


public class SplashScreen implements Initializable {

    @FXML public MediaView splashScreen;
    private MediaPlayer mediaPlayer;
    private Media media;
    private File file;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            file = new File("C:\\my\\Web-work\\2022\\designPatternn-main\\src\\main\\resources\\com\\video\\screen.mp4");
            media = new Media(file.toURI().toString());
            mediaPlayer = new MediaPlayer(media);
            splashScreen.setMediaPlayer(mediaPlayer);
            mediaPlayer.play();


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();

        }
    }


    @FXML
     void closeSplash(KeyEvent event){
        if(event.getCode() == KeyCode.ENTER){
            System.out.println("SPACE ENTERED!");
            try {

                SceneController scene = SceneController.getInstance();
                mediaPlayer.stop();
                scene.switchToUserMainScene(event);

            }catch (Exception e){
                e.printStackTrace();
                e.getCause();

            }
        }
    }
}
