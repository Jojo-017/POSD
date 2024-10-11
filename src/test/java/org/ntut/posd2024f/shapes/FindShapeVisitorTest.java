package org.ntut.posd2024f.shapes;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class FindShapeVisitorTest {

    @Test
    public void testFindShapeInComplexShape() {
        // 創建基本形狀
        Shape circle = new Circle(2.0); // 半徑為2.0的圓
        Shape rectangle = new Rectangle(2.0, 5.0); // 寬2.0, 高5.0的矩形
        List<TwoDimensionalVector> vectors=new ArrayList<>();
        vectors.add(new TwoDimensionalVector(0, 0));
        vectors.add(new TwoDimensionalVector(1, 0));
        vectors.add(new TwoDimensionalVector(0, 1));
        Shape triangle = new Triangle( vectors);

        // 創建CompoundShape並添加基本形狀
        CompoundShape compoundShape = new CompoundShape();
        compoundShape.add(circle);
        compoundShape.add(rectangle);
        compoundShape.add(triangle);

        // 使用TextedShape和ColoredShape進行裝飾
        Shape textedCircle = new TextedShape(circle, "Hello Circle");
        Shape coloredRectangle = new ColoredShape(rectangle, "RED");
        compoundShape.add(textedCircle);
        compoundShape.add(coloredRectangle);

        // 定義查找條件，面積大於6
        Predicate<Shape> condition = shape -> shape.area() > 6;

        // 創建FindShapeVisitor
        FindShapeVisitor visitor = new FindShapeVisitor(condition);

        // 執行訪問，並檢查結果
        compoundShape.accept(visitor);
        List<Shape> result = visitor.getResult();

        // 驗證查找到的形狀
        Assertions.assertEquals(7, result.size()); // 預期返回三個形狀
        Assertions.assertTrue(result.contains(circle)); // 圓形應該在結果中，面積大於6
        Assertions.assertTrue(result.contains(rectangle)); // 矩形應該在結果中，面積大於6
        Assertions.assertTrue(result.contains(textedCircle)); // 被裝飾的圓形也應該在結果中
    }

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
