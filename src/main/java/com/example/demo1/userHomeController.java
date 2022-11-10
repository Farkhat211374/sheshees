package com.example.demo1;

import com.example.demo1.Basic.CarFactory;
import com.example.demo1.Basic.Transport;
import com.example.demo1.Basic.TransportFactory;
import com.example.demo1.ConcreteObjects.Car;
import com.example.demo1.DataBase.DB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Box;

public class userHomeController {

    @FXML private TextField firstPointTextField;
    @FXML private TextField secondPointTextField;
    @FXML private Button submitButton;
    @FXML private Label answerLabel;
    @FXML private Button carButton;
    @FXML private Button planeButton;
    @FXML private VBox mainPane;


    //BodyType
    @FXML private Button HatchbackBut;
    @FXML private Button SedanBut;
    @FXML private Button SportBut;
    @FXML private Button MinivanBut;
    @FXML private Button SuvBut;
    @FXML private Button SuperBut;

    //FuelType
    @FXML private Button gasBut;
    @FXML private Button petrolBut;
    @FXML private Button electricBut;
    @FXML private Button hybridBut;
    @FXML private Button dieselBut;

    //Class
    @FXML private Button businessBut;
    @FXML private Button comfortBut;
    @FXML private Button economyBut;

    //Manufacturer
    @FXML private Button americaBut;
    @FXML private Button europeBut;
    @FXML private Button asianBut;

    // Something непонятный
    Car car = new Car();
    Transport transport = new Transport(car,null);

    public static int distance;

    DB db = DB.getInstance();

    public void submitButtonOnAction(ActionEvent event){
        //int distance = Distance.Distance(firstPointTextField.getText(), secondPointTextField.getText());
        this.distance = db.routes(firstPointTextField.getText(), secondPointTextField.getText());

        answerLabel.setText("Distance: " + distance + "km");

    }


    public void setCarButtonOnAction(ActionEvent event){
        planeButton.setStyle("-fx-background-color: #99cc66");
        carButton.setStyle("-fx-background-color:#0099cc");
        mainPane.setStyle("-fx-background-color: #ccccff");
        FxmlLoader Object = new FxmlLoader();
        Pane view = Object.getPage("carOptionScene.fxml");
        try {
            mainPane.getChildren().remove(0);
        }catch (Exception e){}

        mainPane.getChildren().add(view);

    }





    public void setPlaneButtonOnAction(ActionEvent event){
        planeButton.setStyle("-fx-background-color:#0099cc");
        carButton.setStyle("-fx-background-color:#99cc66");
        mainPane.setStyle("-fx-background-color: #ccccff");
        FxmlLoader Object = new FxmlLoader();
        Pane view = Object.getPage("planeOptionScene.fxml");

        try {
            mainPane.getChildren().remove(0);
        }catch (Exception e){}

        mainPane.getChildren().add(view);


    }

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
        car = CarFactory.startFactory();
        transport.setCar(car);
        System.out.println(transport.getDescription());
        System.out.println("Money "+ transport.money(this.distance));
        System.out.println("Time "+ transport.displacement(this.distance));
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
        car = CarFactory.startFactory();
        transport.setCar(car);
        System.out.println(transport.getDescription());
        System.out.println("Money "+ transport.money(this.distance));
        System.out.println("Time "+ transport.displacement(this.distance));

    }


}
