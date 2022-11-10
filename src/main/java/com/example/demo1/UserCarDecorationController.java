package com.example.demo1;

import com.example.demo1.Basic.CarFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class UserCarDecorationController {
    @FXML private Button HatchbackBut, SedanBut, SportBut, MinivanBut, SuvBut, SuperBut;
    @FXML private Button gasBut, petrolBut, electricBut, hybridBut, dieselBut;
    @FXML private Button businessBut, comfortBut, economyBut;
    @FXML private Button americaBut, europeBut, asianBut;

    public void setCarBodyType(ActionEvent event){
        if(event.getSource().equals(HatchbackBut)){
            HatchbackBut.setDefaultButton(true);
            SedanBut.setDefaultButton(false);
            SportBut.setDefaultButton(false);
            MinivanBut.setDefaultButton(false);
            SuvBut.setDefaultButton(false);
            SuperBut.setDefaultButton(false);
            CarBt.BodyTypeCAR = "HatchbackBut";
        }else if(event.getSource().equals(SedanBut)){
            HatchbackBut.setDefaultButton(false);
            SedanBut.setDefaultButton(true);
            SportBut.setDefaultButton(false);
            MinivanBut.setDefaultButton(false);
            SuvBut.setDefaultButton(false);
            SuperBut.setDefaultButton(false);
            CarBt.BodyTypeCAR = "SedanBut";
        }else if(event.getSource().equals(SportBut)){
            HatchbackBut.setDefaultButton(false);
            SedanBut.setDefaultButton(false);
            SportBut.setDefaultButton(true);
            MinivanBut.setDefaultButton(false);
            SuvBut.setDefaultButton(false);
            SuperBut.setDefaultButton(false);
            CarBt.BodyTypeCAR = "SportBut";
        }else if(event.getSource().equals(MinivanBut)){
            HatchbackBut.setDefaultButton(false);
            SedanBut.setDefaultButton(false);
            SportBut.setDefaultButton(false);
            MinivanBut.setDefaultButton(true);
            SuvBut.setDefaultButton(false);
            SuperBut.setDefaultButton(false);
            CarBt.BodyTypeCAR = "MinivanBut";
        }else if(event.getSource().equals(SuvBut)){
            HatchbackBut.setDefaultButton(false);
            SedanBut.setDefaultButton(false);
            SportBut.setDefaultButton(false);
            MinivanBut.setDefaultButton(false);
            SuvBut.setDefaultButton(true);
            SuperBut.setDefaultButton(false);
            CarBt.BodyTypeCAR = "SuvBut";
        }else if(event.getSource().equals(SuperBut)){
            HatchbackBut.setDefaultButton(false);
            SedanBut.setDefaultButton(false);
            SportBut.setDefaultButton(false);
            MinivanBut.setDefaultButton(false);
            SuvBut.setDefaultButton(false);
            SuperBut.setDefaultButton(true);
            CarBt.BodyTypeCAR = "SuperBut";
        }
    }
    public void setCarFuelType(ActionEvent event){
        if(event.getSource().equals(gasBut)){
            gasBut.setDefaultButton(true);
            petrolBut.setDefaultButton(false);
            electricBut.setDefaultButton(false);
            hybridBut.setDefaultButton(false);
            dieselBut.setDefaultButton(false);
            CarBt.FuelTypeCAR = "gasBut";
        }else if(event.getSource().equals(petrolBut)){
            gasBut.setDefaultButton(false);
            petrolBut.setDefaultButton(true);
            electricBut.setDefaultButton(false);
            hybridBut.setDefaultButton(false);
            dieselBut.setDefaultButton(false);
            CarBt.FuelTypeCAR = "petrolBut";
        }else if(event.getSource().equals(electricBut)){
            gasBut.setDefaultButton(false);
            petrolBut.setDefaultButton(false);
            electricBut.setDefaultButton(true);
            hybridBut.setDefaultButton(false);
            dieselBut.setDefaultButton(false);
            CarBt.FuelTypeCAR = "electricBut";
        }else if(event.getSource().equals(hybridBut)){
            gasBut.setDefaultButton(false);
            petrolBut.setDefaultButton(false);
            electricBut.setDefaultButton(false);
            hybridBut.setDefaultButton(true);
            dieselBut.setDefaultButton(false);
            CarBt.FuelTypeCAR = "hybridBut";
        }else if(event.getSource().equals(dieselBut)){
            gasBut.setDefaultButton(false);
            petrolBut.setDefaultButton(false);
            electricBut.setDefaultButton(false);
            hybridBut.setDefaultButton(false);
            dieselBut.setDefaultButton(true);
            CarBt.FuelTypeCAR = "dieselBut";
        }
    }
    public void setCarClassType(ActionEvent event){
        if(event.getSource().equals(businessBut)){
            businessBut.setDefaultButton(true);
            comfortBut.setDefaultButton(false);
            economyBut.setDefaultButton(false);
            CarBt.KlassCAR = "business";
        }else if(event.getSource().equals(comfortBut)){
            businessBut.setDefaultButton(false);
            comfortBut.setDefaultButton(true);
            economyBut.setDefaultButton(false);
            CarBt.KlassCAR = "comfort";
        }else if(event.getSource().equals(economyBut)){
            businessBut.setDefaultButton(false);
            comfortBut.setDefaultButton(false);
            economyBut.setDefaultButton(true);
            CarBt.KlassCAR = "economy";
        }
    }
    public void setCarManufacturerType(ActionEvent event){
        if(event.getSource().equals(americaBut)){
            americaBut.setDefaultButton(true);
            europeBut.setDefaultButton(false);
            asianBut.setDefaultButton(false);
            CarBt.ManufacturerCAR = "america";
        }else if(event.getSource().equals(europeBut)){
            americaBut.setDefaultButton(false);
            europeBut.setDefaultButton(true);
            asianBut.setDefaultButton(false);
            CarBt.ManufacturerCAR = "europe";
        }else if(event.getSource().equals(asianBut)){
            americaBut.setDefaultButton(false);
            europeBut.setDefaultButton(false);
            asianBut.setDefaultButton(true);
            CarBt.ManufacturerCAR = "asian";
        }
    }
}
