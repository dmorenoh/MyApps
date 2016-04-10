package com.app.triagle.model;

/**
 * Created by dmorenoh on 10/4/16.
 */
public class Triangle {
    private double sideOne;
    private double sideTwo;
    private double sideThree;

    private String triangleType;

    public Triangle(double sideOne, double sideTwo, double sideThree) {
        this.setSideOne(sideOne);
        this.setSideThree(sideThree);
        this.setSideTwo(sideTwo);
    }

    public double getSideOne() {
        return sideOne;
    }

    public void setSideOne(double sideOne) {
        this.sideOne = sideOne;
    }

    public double getSideTwo() {
        return sideTwo;
    }

    public void setSideTwo(double sideTwo) {
        this.sideTwo = sideTwo;
    }

    public double getSideThree() {
        return sideThree;
    }

    public void setSideThree(double sideThree) {
        this.sideThree = sideThree;
    }


    public String getTriangleType() {
        return triangleType;
    }

    public void setTriangleType(String triangleType) {
        this.triangleType = triangleType;
    }
}
