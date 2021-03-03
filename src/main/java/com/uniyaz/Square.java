package com.uniyaz;

import java.io.Serializable;

public class Square extends Edged{

    public Square(int length,int width){
        setLength(length);
        setWidth(width);
    }

    public void calculateArea() {
        setArea(getWidth()*getLength());
    }

    public void calculatePerimeter() {
        setPerimeter(getWidth()*4);
    }

    @Override
    public String toString() {
        return "Square{"+super.toString();
    }
}
