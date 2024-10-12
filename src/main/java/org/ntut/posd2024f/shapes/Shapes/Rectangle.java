package org.ntut.posd2024f.shapes.Shapes;

import org.ntut.posd2024f.shapes.ShapeException;
import org.ntut.posd2024f.shapes.Visitor.Visitor;

public class Rectangle implements Shape {
    private double w;
    private double l;
    public Rectangle(double length, double width) throws ShapeException {
        if (length <= 0 || width <= 0) {
            throw new ShapeException("It's not a rectangle!");
        }
        this.w=width;
        this.l=length;
    }
    @Override
	public double area() {
        return w*l;
    }
    @Override
    public  void add(Shape shape) throws ShapeException{
        //該方法應該拋出ShapeException，並帶有訊息Illegal Operation
        throw new ShapeException("Illegal Operation");

    }
    @Override
    public double perimeter() {
        return 2*(l+w);
    }
    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitRectangle(this);
    }

    public double getLength() {
        return l;
    }

    public double getWidth() {
        return w;
    }
    @Override
    public String toString() {
        return "Rectangle " + l + " " + w;
    }
}