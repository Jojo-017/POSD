package org.ntut.posd2024f.shapes;

public class Circle implements Shape {
    private final double PI=Math.PI;
    private double r;

    public Circle(double radius) throws Exception {
        if (radius <= 0) {
            throw new Exception("It's not a circle!");
        }
        this.r=radius;
    }

    public double area() {
        //return 1;
        return PI*r*r;
    } 

    public double perimeter() {
        return 2*PI*r;
    }

    public String toString() {
       return "Circle " + r;
    }
}
