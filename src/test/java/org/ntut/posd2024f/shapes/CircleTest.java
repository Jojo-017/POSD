package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class CircleTest {
    @Test
    public void testCircleAre() throws Exception {
        Circle c=new Circle(1.0);
        Assert.assertEquals(3.14, c.area(),0.001);
    }

    @Test
    public void testCirclePerimeter() throws Exception {
        Circle c=new Circle(1.0);
        Assert.assertEquals(6.28, c.perimeter(),0.001);
    }

    @Test
    public void testCircleToString() throws Exception {
        Circle c=new Circle(1);
        Assert.assertEquals("Circle 1.0", c.toString());
    }





}