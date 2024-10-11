package org.ntut.posd2024f.shapes;

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