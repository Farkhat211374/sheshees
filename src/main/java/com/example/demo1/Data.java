package com.example.demo1;

import com.example.demo1.Basic.Transport;
import com.example.demo1.ConcreteObjects.Car;
import com.example.demo1.ConcreteObjects.Plane;

public class Data {
    public static String A, B;
    public static int type = 1;
    public static Car car = new Car();
    public static Plane plane=new Plane();
    public static int distance;
    public static int transportType = 1, optionType=1, optionFCType=1;
    public static Transport transport = new Transport(car, plane);
}
