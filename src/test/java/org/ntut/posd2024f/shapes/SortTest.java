package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
import java.util.Collections;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SortTest {
    @Test
    public void testByAreaAscending() throws Exception {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(3, 4));//12
        shapes.add(new Circle(2));//12.56
        shapes.add(new Triangle(3, 4, 5));//6

        //Collections可以儲存一個或多於一個元素的集合
        Collections.sort(shapes, Sort.BY_AREA_ASCENDING);
        Assert.assertEquals(6, shapes.get(0).area(), 0.001);//Triangle
        Assert.assertEquals(12, shapes.get(1).area(), 0.001);//Rectangle
        Assert.assertEquals(12.56, shapes.get(2).area(), 0.001);//Circle
    }

    @Test
    public void testByPerimeterDescending() throws Exception{
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(3, 4));//14
        shapes.add(new Circle(2));//12.56
        shapes.add(new Triangle(3, 4, 5));//12

        Collections.sort(shapes, Sort.BY_PERIMETER_DESCENDING);
        Assert.assertEquals(14.0, shapes.get(0).perimeter(), 0.001); //Rectangle
        Assert.assertEquals(12.56, shapes.get(1).perimeter(), 0.001); //Circle
        Assert.assertEquals(12.0, shapes.get(2).perimeter(), 0.001); //Triangle
    }

    @Test
    public void testInvalidSortCondition() throws Exception{
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(3 ,4));
        shapes.add(new Circle(2));
        shapes.add(new Triangle(3, 4, 5));

        //若不是周長、面積或升序、降序，INPUT FILE要等於OUTPUT FILE;
        ArrayList<Shape> sortedShapes = new InputOutput().handleSort(shapes, "volume", "inc");
        Assert.assertEquals(shapes, sortedShapes); // Order remains the same
    }
}