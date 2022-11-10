package com.example.demo1;

import com.example.demo1.Basic.CarFactory;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class UserPlaneDecorationController {
    @FXML private Button biplane, jet, propeller;
    @FXML private Button businessBut, luxuryBut, economyBut;

    public void setPlaneBodyType(ActionEvent event){
        if(event.getSource().equals(biplane)){
            biplane.setDefaultButton(true);
            jet.setDefaultButton(false);
            propeller.setDefaultButton(false);
            PlaneBt.BodyTypePlane = "Biplane";
        }else if(event.getSource().equals(jet)){
            biplane.setDefaultButton(false);
            jet.setDefaultButton(true);
            propeller.setDefaultButton(false);
            PlaneBt.BodyTypePlane = "Jet";
        }else if(event.getSource().equals(propeller)){
            biplane.setDefaultButton(false);
            jet.setDefaultButton(false);
            propeller.setDefaultButton(true);
            PlaneBt.BodyTypePlane = "Propeller";
        }
    }
    public void setPlaneClassType(ActionEvent event){
        if(event.getSource().equals(businessBut)){
            businessBut.setDefaultButton(true);
            luxuryBut.setDefaultButton(false);
            economyBut.setDefaultButton(false);
            PlaneBt.KlassPlane = "business";
        }else if(event.getSource().equals(luxuryBut)){
            businessBut.setDefaultButton(false);
            luxuryBut.setDefaultButton(true);
            economyBut.setDefaultButton(false);
            PlaneBt.KlassPlane = "luxury";
        }else if(event.getSource().equals(economyBut)){
            businessBut.setDefaultButton(false);
            luxuryBut.setDefaultButton(false);
            economyBut.setDefaultButton(true);
            PlaneBt.KlassPlane = "economy";
        }
    }
}
