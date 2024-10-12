package org.ntut.posd2024f.shapes;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;

public class PrettyPrintVisitorTest {
    @Test
    public void testPrettyPrintCircle() {
        Shape circle = new Circle(1.0); // 圓的半徑為 1.0
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();

        circle.accept(visitor);

        Assertions.assertEquals("Circle 1.0", visitor.getResult());
    }

    @Test
    public void testPrettyPrintRectangle() {
        Shape rectangle = new Rectangle(1.0, 2.0); // 寬1.0, 高2.0
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();

        rectangle.accept(visitor);
        Assertions.assertEquals("Rectangle 1.0 2.0", visitor.getResult());
    }

    @Test
    public void testPrettyPrintTriangle() {
        List<TwoDimensionalVector>vectors=new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(1, 0));
        vectors.add(new TwoDimensionalVector(0, 1));
        Shape triangle = new Triangle(vectors);
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();

        triangle.accept(visitor);

        Assertions.assertEquals("Triangle [0,0] [1,0] [0,1]", visitor.getResult());
    }

    @Test
    public void testPrettyPrintConvexPolygon() {
        List<TwoDimensionalVector>vectors=new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(1, 0));
        vectors.add(new TwoDimensionalVector(1, 1));
        vectors.add(new TwoDimensionalVector(0, 1));
        Shape polygon = new ConvexPolygon(vectors);
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();

        polygon.accept(visitor);

        Assertions.assertEquals("ConvexPolygon [0,0] [1,0] [1,1] [0,1]", visitor.getResult());
    }

    @Test
    public void testPrettyPrintCompoundShape() {
        Shape circle = new Circle(1.0);
        Shape rectangle = new Rectangle(1.0, 2.0);
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.add(circle);
        compoundShape.add(rectangle);
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();

        compoundShape.accept(visitor);

        Assertions.assertEquals("CompoundShape {\n  Circle 1.0\n  Rectangle 1.0 2.0\n}", visitor.getResult());
    }

    @Test
    public void testPrettyPrintEmptyCompoundShape() {
        CompoundShape compoundShape = new CompoundShape();
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();

        compoundShape.accept(visitor);

        Assertions.assertEquals("CompoundShape {}", visitor.getResult());
    }

    @Test
    public void testPrettyPrintTextedShape() {
        Shape circle = new Circle(1.0);
        Shape textedCircle = new TextedShape(circle, "Hello");
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();

        textedCircle.accept(visitor);

        Assertions.assertEquals("Circle 1.0, text: Hello", visitor.getResult());
    }

    @Test
    public void testPrettyPrintColoredShapeRed() {
        Shape circle = new Circle(1.0);
        Shape coloredCircle = new ColoredShape(circle, "RED");
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();

        coloredCircle.accept(visitor);

        Assertions.assertEquals("\033[0;31mCircle 1.0\033[0m", visitor.getResult()); // 紅色

    }


    @Test
    public void testPrettyPrintColoredShapeGreen() {
        Shape circle = new Circle(1.0);
        Shape coloredCircle = new ColoredShape(circle, "GREEN");
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();

        coloredCircle.accept(visitor);

        Assertions.assertEquals("\033[0;32mCircle 1.0\033[0m", visitor.getResult()); // 綠色
    }

    @Test
    public void testPrettyPrintColoredShapeBlue() {
        Shape circle = new Circle(1.0);
        Shape coloredCircle = new ColoredShape(circle, "BLUE");
        PrettyPrintVisitor visitor = new PrettyPrintVisitor();

        coloredCircle.accept(visitor);

        Assertions.assertEquals("\033[0;34mCircle 1.0\033[0m", visitor.getResult()); // 藍色
    }
}
