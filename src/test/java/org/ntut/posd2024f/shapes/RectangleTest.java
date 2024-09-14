package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class RectangleTest {
    @Test
    public void testRecAre() throws Exception {
        Rectangle r =new Rectangle(5.0,6.0);
        Assert.assertEquals(30, r.area(),0.01);
    }

    @Test
    public void testRecPerimeter() throws Exception {
        Rectangle r =new Rectangle(5.0,6.0);
        Assert.assertEquals(22, r.perimeter(),0.01);
    }

    @Test
    public void testRecToString() throws Exception {
        Rectangle r =new Rectangle(5,6);
        Assert.assertEquals("Rectangle 5.0 6.0", r.toString());
    }
}