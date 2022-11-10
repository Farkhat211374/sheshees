package com.example.demo1.Basic;

import com.example.demo1.ConcreteObjects.Plane;

public class TransportFactory {
    public Transport createTransport(boolean isCar){
        if (isCar) return new Transport(CarFactory.startFactory(),null);
        else return new Transport(null, PlaneFactory.startFactory());
    }
}
