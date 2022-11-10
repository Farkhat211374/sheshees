package com.example.demo1;
import java.math.*;

public class findDistance {

    findPoints p1 = null;
    findPoints p2 = null;
    int distance= 0;

    public findDistance(findPoints p1, findPoints p2){
        this.p1 = p1;
        this.p2 = p2;
        getDistance();
    }

    private void getDistance() {
        double theta = p1.lng - p2.lng;
        double dist = Math.sin(deg2rad(p1.lat)) * Math.sin(deg2rad(p2.lat)) + Math.cos(deg2rad(p1.lat)) * Math.cos(deg2rad(p2.lat)) * Math.cos(deg2rad(theta));
        dist = Math.acos(dist);
        dist = rad2deg(dist);
        dist = dist * 60 * 1.1515;
        dist = dist * 1.609344;
        distance = (int)dist; // convert into Integer
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts decimal degrees to radians             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double deg2rad(double deg) {
        return (deg * Math.PI / 180.0);
    }

    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    /*::  This function converts radians to decimal degrees             :*/
    /*:::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::::*/
    private double rad2deg(double rad) {
        return (rad * 180.0 / Math.PI);
    }

}
