package org.ntut.posd2024f.shapes;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ShapeTest {
    //因為Shape是抽象類別，無法直接用，所以用子類別來測試他的通用。

    @Test
    public void testAreaForRectangle() throws Exception {
        Shape  r =new Rectangle(5.0,6.0);
        Assert.assertEquals(30, r.area(),0.01);
    }

    @Test
    public void testPerimeterForTriangle() throws Exception {
        TwoDimensionalVector v1=new TwoDimensionalVector(0,0);
        TwoDimensionalVector v2=new TwoDimensionalVector(0,3);
        TwoDimensionalVector v3=new TwoDimensionalVector(4,0);
        List<TwoDimensionalVector> vectors= new ArrayList<>();
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);
        Shape  t =new Triangle(vectors);
        Assert.assertEquals(6, t.area(),0.01);
    }

    @Test
    public void testToStringForCircle() throws Exception {
        Shape  c=new Circle(1.0);
        Assert.assertEquals(3.14, c.area(),0.01);
    }
}