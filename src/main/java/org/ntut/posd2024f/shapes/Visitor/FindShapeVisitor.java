package org.ntut.posd2024f.shapes.Visitor;

import org.ntut.posd2024f.shapes.Shapes.Rectangle;
import org.ntut.posd2024f.shapes.Shapes.*;
import org.ntut.posd2024f.shapes.Shapes.TextedShape;
import org.ntut.posd2024f.shapes.Shapes.Triangle;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class FindShapeVisitor implements Visitor<List<Shape>> {
    //找到符合特定條件的shape
    //例如：條件是面積等於10，Visitor應返回面積等於10的形狀
    private final Predicate<Shape> condition;
    private List<Shape> result;

    public FindShapeVisitor(Predicate<Shape> condition) {
        this.condition=condition;
        this.result = new ArrayList<>();
    }

    @Override
    public void visitCircle(Circle circle) {
        if (condition.test(circle)) {
            result.add(circle);
        }
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        if (condition.test(rectangle)) {
            result.add(rectangle);
        }
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        if (condition.test(triangle)) {
            result.add(triangle);
        }
    }

    @Override
    public void visitConvexPolygon(ConvexPolygon convexPolygon) {
        if (condition.test(convexPolygon)) {
            result.add(convexPolygon);
        }
    }

    @Override
    public void visitCompoundShape(CompoundShape compoundShape) {
        if (condition.test(compoundShape)) {
            result.add(compoundShape);
        }
        for (Iterator<Shape> it = compoundShape.iterator(); it.hasNext(); ) {
            Shape shape = it.next();
            shape.accept(this);
        }
    }

    @Override
    public void visitTextedShape(TextedShape textedShape) {
        if (condition.test(textedShape)) {
            result.add(textedShape);
        }
        textedShape.getShape().accept(this);
    }

    @Override
    public void visitColoredShape(ColoredShape coloredShape) {
        if (condition.test(coloredShape)) {
            result.add(coloredShape);
        }
        coloredShape.getShape().accept(this);
    }



    public List<Shape> getResult() {
        return result;
    }
}