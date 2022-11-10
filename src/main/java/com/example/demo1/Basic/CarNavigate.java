package com.example.demo1.Basic;

import com.example.demo1.ConcreteObjects.Car;
import com.example.demo1.DataBase.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class CarNavigate {
    Connection conn = DB.getInstance().getConn();
    Car car=new Car();
    double velocity=car.getSpeed();

    double kpl= car.getKpl();
    double driver= car.getDriver();
    double road= car.getRoad();
    double distance =getDistance();
    double FP= car.getFuelPrice()*distance*kpl;
    public void CarTime(){
        double time=distance/velocity;
        System.out.println("The time is"+time);
    }
    public void CarMoney(){
        double money=FP+road+driver;
        System.out.println("The money is "+money);
    }
    public int getDistance(){
        String city1,city2;
        Scanner sc=new Scanner(System.in);
        System.out.println("Write please my friend the first city from Kazakhstan please");
        city1=sc.nextLine();
        System.out.println("My friend please write the second city");
        city2=sc.nextLine();
        int distance=routes(city1,city2);
        return distance;
    }
    private int routes(String a2, String b2) {

        try(PreparedStatement pst = conn.prepareStatement("Select * from routes where city1='"+a2+"'and city2='"+b2+"';");
            ResultSet rs = pst.executeQuery();   ){
            while(rs.next()) {
                int distance=rs.getInt("distance");
                return distance;}
        }catch (Exception e){
            System.out.println(e);

        }
        return 0;
    }
}
