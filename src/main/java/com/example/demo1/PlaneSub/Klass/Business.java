package com.example.demo1.PlaneSub.Klass;

import com.example.demo1.ConcreteObjects.Plane;
import com.example.demo1.PlaneSub.PlaneDecorator;

public class Business extends PlaneDecorator {
    public Business(Plane plane) {
        super(plane);
    }
    @Override
    public double getSpeed() {
        return plane.getSpeed();
    }
    public double getBaggage() {
        return plane.getBaggage()*4;
    }

    public String getDescription(){
        return plane.getDescription()+" Business class";
    }
}

