package org.ntut.posd2024f.shapes;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class TriangleTest {
    @Test
    public void testTriAre() throws Exception {
        Triangle t =new Triangle(3,4,5);
        Assert.assertEquals(6, t.area(),0.01);
    }

    @Test
    public void testTriPerimeter() throws Exception {
        Triangle t =new Triangle(3,4,5);
        Assert.assertEquals(12, t.perimeter(),0.01);
    }

    @Test
    public void testTriToString() throws Exception {
        Triangle t =new Triangle(3,4,5);
        Assert.assertEquals("Triangle 3.0 4.0 5.0", t.toString());
    }
}