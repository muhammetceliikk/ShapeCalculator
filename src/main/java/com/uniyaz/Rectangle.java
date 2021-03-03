package com.uniyaz;

import java.io.Serializable;

public class Rectangle extends Edged{

    public Rectangle(int length,int width){
        setLength(length);
        setWidth(width);
    }

    public void calculateArea() {
        setArea(getWidth()*getLength());
    }

    public void calculatePerimeter() {
        setPerimeter((getLength()+getWidth())*2);
    }

    @Override
    public String toString() {
        return "Rectangle{"+super.toString();
    }
}
