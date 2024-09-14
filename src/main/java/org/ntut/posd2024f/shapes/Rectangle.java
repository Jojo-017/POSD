package org.ntut.posd2024f.shapes;

public class Rectangle implements Shape {
    private double w;
    private double l;

    public Rectangle(double length, double width) throws Exception {
        if (length <= 0 || width <= 0) {
            throw new Exception("It's not a rectangle!");
        }
        this.w=width;
        this.l=length;
    }

	public double area() {
        return w*l;
    }
    
    public double perimeter() {
        return 2*(l+w);
    }

    public String toString() {
        return "Rectangle " + l + " " + w;
    }
}