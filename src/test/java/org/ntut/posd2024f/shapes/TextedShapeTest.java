package org.ntut.posd2024f.shapes;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

public class TextedShapeTest {

    @Test
    public void testGetText() {
        Shape circle = new Circle(1.0);
        TextedShape textedShape = new TextedShape(circle, "Hello");

        Assertions.assertEquals("Hello", textedShape.getText());
    }

    @Test
    public void testGetShape() {
        Shape circle = new Circle(1.0);
        TextedShape textedShape = new TextedShape(circle, "Hello");

        Assertions.assertEquals(circle, textedShape.getShape());
    }

    @Test
    public void testArea() {
        Shape circle = new Circle(1.0);
        TextedShape textedShape = new TextedShape(circle, "Hello");

        Assertions.assertEquals(circle.area(), textedShape.area());
    }

    @Test
    public void testPerimeter() {
        Shape circle = new Circle(1.0);
        TextedShape textedShape = new TextedShape(circle, "Hello");

        Assertions.assertEquals(circle.perimeter(), textedShape.perimeter());
    }

    @Test
    public void testAcceptVisitor() {
        Shape circle = new Circle(1.0);
        TextedShape textedShape = new TextedShape(circle, "Hello");

        PrettyPrintVisitor visitor = new PrettyPrintVisitor();
        textedShape.accept(visitor);
        Assertions.assertEquals("Circle 1.0, text: Hello", visitor.getResult());
    }

}
