package com.uniyaz;

import java.io.Serializable;

public class Sphere extends Shape{
    private final double PI=3.14;
    private double r;

    public Sphere(double r){
        this.r=r;
    }

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    public void calculateArea() {
        setArea(getR()*getR()*PI);
    }

    public void calculatePerimeter() {
        setPerimeter(PI*2*getR());
    }

    @Override
    public String toString() {
        return "Sphere{radius="+getR()+
                ", area=" + getArea() +
                ", perimeter=" + getPerimeter() +
                '}';
    }
}
