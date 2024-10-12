package org.ntut.posd2024f.shapes.Visitor;

import org.ntut.posd2024f.shapes.Shapes.Rectangle;
import org.ntut.posd2024f.shapes.Shapes.*;

public interface Visitor<T> {
    public void visitCircle(Circle circle);
    public void visitRectangle(Rectangle rectangle);
    public void visitTriangle(Triangle triangle);
    public void visitConvexPolygon(ConvexPolygon convexPolygon);
    public void visitCompoundShape(CompoundShape compoundShape);
    public void visitTextedShape(TextedShape textedShape);
    public void visitColoredShape(ColoredShape coloredShape);
    public T getResult();
}
