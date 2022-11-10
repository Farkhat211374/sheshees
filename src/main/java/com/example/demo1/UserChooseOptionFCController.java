package com.example.demo1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class UserChooseOptionFCController {

    @FXML
    Button cheapestButton, fastestButton;
    public void choose(ActionEvent event){
        if(event.getSource().equals(cheapestButton)){
            Data.optionFCType=1;
            cheapestButton.setStyle("-fx-background-color:#0099cc");
            fastestButton.setStyle("-fx-background-color:#99cc66");
        }else{
            Data.optionFCType=2;
            fastestButton.setStyle("-fx-background-color:#0099cc");
            cheapestButton.setStyle("-fx-background-color:#99cc66");
        }
    }
}
