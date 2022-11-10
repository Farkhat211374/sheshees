package com.example.demo1.Basic;

import com.example.demo1.ConcreteObjects.Car;
import com.example.demo1.ConcreteObjects.Plane;
import com.example.demo1.DataBase.DB;

import java.util.Scanner;

public class Navigator {
    Scanner sc = new Scanner(System.in);
    TransportFactory tf = new TransportFactory();
    Transport transport = new Transport(new Car(), null);
    Car car = new Car();
    Plane plane = new Plane();
    String A, B;
    DB db = DB.getInstance();
    int[] distance = new int[5];
    private boolean isCar;
    public boolean main(){
        Scanner scanner = new Scanner(System.in);
        int option = 1;
        while (option != 0){
            switch (option) {
                case 1 -> {
                    enterCities();
                    distance[1] = db.routes(A, B);
                    System.out.println("Distance is " + distance[1] + " km");
                }
                case 2 -> {
                    Transport transportx = customize();
                    if(isCar){
                        transport.setCar(transportx.car);
                        System.out.println("");
                    }else {
                        transport.setPlane(transportx.plane);
                    }
                    System.out.println(transport.getDescription(isCar));
                    System.out.println("Distance from "+ A + " to "+ B + " is "+distance[1]+" km");
                    System.out.println("Money is - " + transport.money(distance[1]) + " tg");
                    System.out.println("Time is - " + transport.displacement(distance[1])+ " hour");
                }
                case 3 -> {
                    System.out.println("Choose type of transport");
                    System.out.println("1. Plane");
                    System.out.println("2. Car");
                    option = sc.nextInt();
                    if(option == 1){
                        System.out.println(transport.getDescription(false));
                        transport.setPlane(transport.plane);
                    }else{
                        System.out.println(transport.getDescription(true));
                        transport.setCar(transport.car);
                    }
                    System.out.println("Distance from "+ A + " to "+ B + " is "+distance[1]+" km");
                    System.out.println("Money is - " + transport.money(distance[1]) + " tg");
                    System.out.println("Time is - " + transport.displacement(distance[1])+ " hour");
                }
                case 4 -> {
                    System.out.println("Distance from "+ A + " to "+ B + " is "+distance[1]+" km");
                }
                case 5 -> {
                    System.out.println("Choose option");
                    System.out.println("1. Cheapest transport");
                    System.out.println("2. Fastest transport");
                    option = sc.nextInt();
                    if(option == 1){
                        cheapTrip(distance[1]);
                    }else {
                        fastTrip(distance[1]);
                    }
                }
                case 6 -> {
                    return true;
                }
                case 7 -> {
                    return false;
                }
                default -> {
                    System.out.println("\nInput number invalid");
                }
            }
            System.out.println("Choose option");
            System.out.println("1. Change distance");
            System.out.println("2. Customize transport");
            System.out.println("3. See one type of transport");
            System.out.println("4. See distance");
            System.out.println("5. Choose option");
            System.out.println("6. Exit from account");
            System.out.println("7. Exit from program");
            option = sc.nextInt();
        }
        return false;
    }
    private void enterCities(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("All cities: Almaty, Astana, Shymkent, Aktobe, Karaganda, Taraz, Pavlodar, Ust-kamenogorsk, Semey, Atyrau, Kyzylorda, Kostanai, Uralsk, Aktau.");
        System.out.println("Destination point A");
//        A = sc.nextLine();
        A = scanner.nextLine();
        System.out.println("Destination point B");
        B = scanner.nextLine();
        System.out.println(A + " | " + B);
    }
    public void qwerty(String A, String B, int distance){
        this.A=A;
        this.B=B;
        System.out.println("");
        System.out.println("1. Customize");
        System.out.println("2. Choose option(cheapest or fastest)");
        int option = sc.nextInt();
        if(option==1){
            transport = customize();
            if(transport.car==null){
                plane = transport.plane;
            }else{
                car = transport.car;
            }
            System.out.println(transport.getDescription());
            System.out.println("Distance from "+ A + " to "+ B + " is "+distance+" km");
            System.out.println("Money is - " + transport.money(distance) + " tg");
            System.out.println("Time is - " + transport.displacement(distance)+ " hour");
        }else{
            System.out.println("Choose option:");
            System.out.println("1. Cheapest");
            System.out.println("2. Fastest");
            option = sc.nextInt();
            if(option==1) cheapTrip(distance);
            else fastTrip(distance);
        }
    }

    public Transport customize(){
        whileStatement:
        while (true) {
            System.out.println("\nWould you like to travel by a plane or a car?\n");
            System.out.println("1. Plane");
            System.out.println("2. Car");
            System.out.println("0. Exit");

            System.out.print("\nEnter option (1-2): ");
            int option = sc.nextInt();
            switch (option) {
                case 1:
                    isCar = false;
                    break;
                case 2:
                    isCar = true;
                    break;
                case 0:
                    System.out.println("\nAuf viedersehn!");
                    break whileStatement;
                default:
                    System.out.println("\nInput number invalid");
                    break;
            }
            return tf.createTransport(isCar);
        }
        return null;
    }
    public void cheapTrip(int distance){
        transport.setCar(car);
        double minMoney=transport.money(distance),time;
        String minTransport="Car";
        transport.setPlane(plane);
        if(minMoney>transport.money(distance)){
            minMoney=transport.money(distance);
            minTransport="Plane";
        }

        if(minTransport.equals("Car")){
            System.out.println(car.getDescription()+" is cheapest and");
            transport.setCar(car);
            time=transport.displacement(distance);
        } else {
            System.out.println("Plane is cheapest and");
            transport.setPlane(plane);
            time=transport.displacement(distance);
        }

        System.out.println("Distance from "+ A + " to "+ B + " is "+distance+" km");
        System.out.println("Money is - " + minMoney + " tg");
        System.out.println("Time is - " + time+ " hour");
    }
    public void fastTrip(int distance){
        transport.setCar(car);
        double minTime=transport.displacement(distance), money;
        String minTransport="Car";
        transport.setPlane(plane);
        if(minTime>transport.displacement(distance)){
            minTime=transport.displacement(distance);
            minTransport="Plane";
        }

        if(minTransport.equals("Car")){
            System.out.println(car.getDescription()+" is fastest and");
            transport.setCar(car);
            money = transport.money(distance);
        } else {
            System.out.println(plane.getDescription()+" is fastest and");
            transport.setPlane(plane);
            money = transport.money(distance);
        }
        System.out.println("Distance from "+ A + " to "+ B + " is "+distance+" km");
        System.out.println("Money is - " + money + " tg");
        System.out.println("Time is - " + minTime+ " hour");
//        String s="User with "+user.getUserId()+" create route from "+A+" to "+B+" and choose option fastest";
//        s+=" and answer was "+minTransport+ " fuel to distance ratio is "+fuel+" time to distance is "+minTime;
//        user.notifyObservers(s,db);
    }
}
