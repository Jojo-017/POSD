package org.ntut.posd2024f.shapes;

import java.util.Iterator;

public class TextedShape implements Shape {
    private Shape shape;
    private String text;
    public TextedShape(Shape shape, String text) {
        this.shape=shape;
        this.text=text;
    }
    @Override
    public  void add(Shape shape) throws ShapeException{
        //該方法應該拋出ShapeException，並帶有訊息Illegal Operation
        throw new ShapeException("Illegal Operation IN TextedShape");

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

    public String getText() {
        return this.text;
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitTextedShape(this);
    }
}
