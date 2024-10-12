package org.ntut.posd2024f.shapes;

public class Circle implements Shape {
    private final double PI=Math.PI;
    private double r;

    public Circle(double radius) throws ShapeException {
        if (radius <= 0) {
            throw new ShapeException("It's not a circle!");
        }
        this.r=radius;
    }

    @Override
    public  void add(Shape shape) throws ShapeException{
        //該方法應該拋出ShapeException，並帶有訊息Illegal Operation
        throw new ShapeException("Illegal Operation");

    }
    @Override
    public double area() {
        return PI*r*r;
    }
    @Override
    public double perimeter() {
        return 2*PI*r;
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitCircle(this);  // 接受訪問，讓訪問者來做事
    }

    public double getRadius() {
        return r;
    }

    @Override
    public String toString() {
        return "Circle " + r;
    }

}
