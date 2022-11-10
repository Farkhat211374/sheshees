package com.example.demo1.Strategy;

import com.example.demo1.ConcreteObjects.Plane;

public class PlaneMoneyCons implements MoneyStrategy {
    Plane plane = new Plane();
    @Override
    public double money(double distance){
        double expenditure = 0.0473; //на каждый метр, (100km - 4,73) for one passenger
        return expenditure*distance;
    }
}
