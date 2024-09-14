package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ShapeTest {
    //因為Shape是抽象類別，無法直接用，所以用子類別來測試他的通用。

    @Test
    public void testAreaForRectangle() throws Exception {
        Shape  r =new Rectangle(5.0,6.0);
        Assert.assertEquals(30, r.area(),0.001);
    }

    @Test
    public void testPerimeterForTriangle() throws Exception {
        Shape  t =new Triangle(3,4,5);
        Assert.assertEquals(6, t.area(),0.001);
    }

    @Test
    public void testToStringForCircle() throws Exception {
        Shape  c=new Circle(1.0);
        Assert.assertEquals(3.14, c.area(),0.001);
    }
}