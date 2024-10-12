package org.ntut.posd2024f.shapes;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.ntut.posd2024f.shapes.Shapes.*;
import org.ntut.posd2024f.shapes.Visitor.FindShapeVisitor;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FindShapeVisitorTest {

    @Test
    public void testFindShapeWithAreaEquals() {
        Shape circle = new Circle(1.0); //  π
        Shape rectangle = new Rectangle(2.0, 3.0); //  6
        List<TwoDimensionalVector>vectors=new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(1, 0));
        vectors.add(new TwoDimensionalVector(1, 1));
        Shape triangle = new Triangle(vectors);
        vectors.add(new TwoDimensionalVector(0, 1));
        Shape convexPolygon = new ConvexPolygon(vectors);
        Shape compoundShape=new CompoundShape();
        compoundShape.add(circle);
        compoundShape.add(rectangle);
        compoundShape.add(triangle);

        Shape textedShape = new TextedShape(circle, "Hello");
        Shape coloredShape = new ColoredShape(circle, "RED");



        // 建立條件 找面積=PI的shape
        Predicate<Shape> condition = shape -> shape.area() == Math.PI;
        FindShapeVisitor visitor = new FindShapeVisitor(condition);

        circle.accept(visitor);
        rectangle.accept(visitor);
        triangle.accept(visitor);
        convexPolygon.accept(visitor);
        compoundShape.accept(visitor);
        textedShape.accept(visitor);
        coloredShape.accept(visitor);

        List<Shape> result = visitor.getResult();
        Assertions.assertEquals(6, result.size());//compoundShape+text+color+3*circle
        Assertions.assertTrue(result.contains(circle));
    }
}
