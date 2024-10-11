package org.ntut.posd2024f.shapes;

import java.util.Iterator;

public class ColoredShape implements Shape {
    private Shape shape;
    private String color;
    public ColoredShape(Shape shape, String color) {
        this.shape=shape;
        this.color=color;
    }

    @Override
    public  void add(Shape shape) throws ShapeException{
        //該方法應該拋出ShapeException，並帶有訊息Illegal Operation
        throw new ShapeException("Illegal Operation IN ColoredShape");

    }

    @Override
    public double area() {
        return this.shape.area();
    }

    @Override
    public double perimeter() {
        return this.shape.perimeter();
    }

    @Override
    public Iterator<Shape> iterator() {
        return shape.iterator();
    }

    public Shape getShape() {
        return this.shape;
    }

    public String getColor() {
        return  this.color;
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitColoredShape(this);
        this.color="";
    }

    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();
        switch (this.color) {
            case "RED":
                sb.append("\033[0;31m");
                break;
            case "GREEN":
                sb.append("\033[0;32m");
                break;
            case "BLUE":
                sb.append("\033[0;34m");
                break;
            default:
                sb.append("\033[0m");
                break;
        }
        sb.append(this.shape.toString()).append("\033[0m");
        return sb.toString();
    }
}
