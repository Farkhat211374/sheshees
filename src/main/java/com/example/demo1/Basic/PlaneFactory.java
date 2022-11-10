package com.example.demo1.Basic;

import com.example.demo1.CarSub.Klass.Comfort;
import com.example.demo1.ConcreteObjects.Plane;
import com.example.demo1.PlaneBt;
import com.example.demo1.PlaneSub.BodyType.Biplane;
import com.example.demo1.PlaneSub.BodyType.Jet;
import com.example.demo1.PlaneSub.BodyType.Propeller;
import com.example.demo1.PlaneSub.Klass.Business;
import com.example.demo1.PlaneSub.Klass.Economy;
import com.example.demo1.PlaneSub.Klass.Luxury;

import java.util.Scanner;

public class PlaneFactory extends TransportFactory {

    public static Plane startFactory(){
        Plane plane = new Plane();
        if(PlaneBt.BodyTypePlane.equals("Biplane")) plane = new Biplane(plane);
        else if(PlaneBt.BodyTypePlane.equals("Jet")) plane = new Jet(plane);
        else if(PlaneBt.BodyTypePlane.equals("Propeller")) plane = new Propeller(plane);

        if(PlaneBt.KlassPlane.equals("business")) plane = new Business(plane);
        else if(PlaneBt.KlassPlane.equals("luxury")) plane = new Luxury(plane);
        else if(PlaneBt.KlassPlane.equals("economy")) plane = new Economy(plane);

        return plane;
 /*       System.out.println("Choose body type of plane");
        Plane plane = planeBodyTypes();
        System.out.println("Choose klass of plane");
        plane = PlaneKlasses(plane);

        return plane;*/
    }

    private static Plane planeBodyTypes() {
        System.out.println("Enter number:");
        System.out.println("1) Default");
        System.out.println("2) Biplane");
        System.out.println("3) Jet");
        System.out.println("4) Propeller");
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        while (type<1 || type>4){
            System.out.println("Please type number between 1 and 4");
            System.out.println("1) Default");
            System.out.println("2) Biplane");
            System.out.println("3) Jet");
            System.out.println("4) Propeller");
            type=sc.nextInt();
        }
        return PlaneBodyType(type);

    }
    private static Plane PlaneBodyType(int type){
        if(type==1) return new Plane();
        else if(type==2) return new Biplane(new Plane());
        else if(type==3) return new Jet(new Plane());
        else if(type==4) return new Propeller(new Plane());
        else return null;
    }
    private static Plane PlaneKlasses(Plane plane) {
        System.out.println("Enter number:");
        System.out.println("1) Default");
        System.out.println("2) Economy");
        System.out.println("3) Business");
        System.out.println("4) Luxury");
        Scanner sc = new Scanner(System.in);
        int type = sc.nextInt();
        while (type<1 || type>4){
            System.out.println("Please type number between 1 and 4");
            System.out.println("1) Default");
            System.out.println("2) Economy");
            System.out.println("3) Business");
            System.out.println("4) Luxury");
            type=sc.nextInt();
        }
        return PlaneKlass(type, plane);

    }
    private static Plane PlaneKlass(int type, Plane plane){
        if(type==1) return plane;
        else if(type==2) return new Economy(plane);
        else if(type==3) return new Business(plane);
        else if(type==4) return new Luxury(plane);
        else return null;
    }
}