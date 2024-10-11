package org.ntut.posd2024f.shapes;

import java.util.Iterator;

public interface Shape {
    public double area();
    public double perimeter();
    public String toString();
    public default void add(Shape shape) throws ShapeException{
        //該方法應該拋出ShapeException，並帶有訊息Illegal Operation
        //throw new ShapeException("Illegal Operation");

    }
    public default Iterator<Shape> iterator() {
        //返回一個null iterator。
        return  new NullIterator();
    }
    public <T> void accept(Visitor<T> visitor);

}
