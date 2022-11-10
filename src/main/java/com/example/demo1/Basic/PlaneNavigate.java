package com.example.demo1.Basic;

import com.example.demo1.DataBase.DB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class PlaneNavigate {
    Connection conn = DB.getInstance().getConn();
//    public void getDistance(){
//        String city1,city2;
//        Scanner sc=new Scanner(System.in);
//        System.out.println("Write please my friend the first city from Kazakhstan please");
//        city1=sc.nextLine();
//        System.out.println("My friend please write the second city");
//        city2=sc.nextLine();
//        int distance=routes(city1,city2);
//
//    }
//    private int routes(String a2, String b2) {
//
//        try(PreparedStatement pst = conn.prepareStatement("Select * from routes where city1='"+a2+"'and city2='"+b2+"';");
//            ResultSet rs = pst.executeQuery();   ){
//            while(rs.next()) {
//                int distance=rs.getInt("distance");
//                return distance;}
//        }catch (Exception e){
//            System.out.println(e);
//
//        }
//        return 0;
//    }
}
