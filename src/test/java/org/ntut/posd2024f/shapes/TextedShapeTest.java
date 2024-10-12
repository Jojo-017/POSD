package org.ntut.posd2024f.shapes;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.ntut.posd2024f.shapes.Shapes.*;
import org.ntut.posd2024f.shapes.Visitor.PrettyPrintVisitor;

public class TextedShapeTest {

    @Test
    public void testCompoundShapeInTextedShapeWithAdd(){
        Shape circle = new Circle(1.0); //  π
        Shape rectangle = new Rectangle(2.0, 3.0); //  6
        Shape compoundShape=new CompoundShape();
        compoundShape.add(circle);
        compoundShape.add(rectangle);

        ColoredShape coloredShape = new ColoredShape(circle, "Hello");

        TextedShape textedShape = new TextedShape(compoundShape, "Hello");
        //ColoredShape coloredShape = new ColoredShape(compoundShape, "RED");
        textedShape.getShape().add(coloredShape);
        Assertions.assertEquals("Hello", textedShape.getText());

    }

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
