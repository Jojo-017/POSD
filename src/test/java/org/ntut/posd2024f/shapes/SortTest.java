package org.ntut.posd2024f.shapes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class SortTest {
    @Test
    public void testByAreaAscending() throws Exception {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(3, 4));//12
        shapes.add(new Circle(2));//12.56
        TwoDimensionalVector v1=new TwoDimensionalVector(0,0);
        TwoDimensionalVector v2=new TwoDimensionalVector(0,3);
        TwoDimensionalVector v3=new TwoDimensionalVector(4,0);
        List<TwoDimensionalVector> vectors= new ArrayList<>();
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);
        shapes.add(new Triangle(vectors));//6

        //Collections可以儲存一個或多於一個元素的集合
        Collections.sort(shapes, Sort.BY_AREA_ASCENDING);
        assertEquals(6, shapes.get(0).area(), 0.01);//Triangle
        assertEquals(12, shapes.get(1).area(), 0.01);//Rectangle
        assertEquals(12.56, shapes.get(2).area(), 0.01);//Circle
    }

    @Test
    public void testByAreaDescending() throws Exception {
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(3, 4));//12
        shapes.add(new Circle(2));//12.56
        TwoDimensionalVector v1=new TwoDimensionalVector(0,0);
        TwoDimensionalVector v2=new TwoDimensionalVector(0,3);
        TwoDimensionalVector v3=new TwoDimensionalVector(4,0);
        List<TwoDimensionalVector> vectors= new ArrayList<>();
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);
        shapes.add(new Triangle(vectors));//6
        //Collections可以儲存一個或多於一個元素的集合
        Collections.sort(shapes, Sort.BY_AREA_DESCENDING);
        assertEquals(6, shapes.get(2).area(), 0.01);//Triangle
        assertEquals(12, shapes.get(1).area(), 0.01);//Rectangle
        assertEquals(12.56, shapes.get(0).area(), 0.01);//Circle
    }

    @Test
    public void testByPerimeterAscending() throws Exception{
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(3, 4));//14
        shapes.add(new Circle(2));//12.56
        TwoDimensionalVector v1=new TwoDimensionalVector(0,0);
        TwoDimensionalVector v2=new TwoDimensionalVector(0,3);
        TwoDimensionalVector v3=new TwoDimensionalVector(4,0);
        List<TwoDimensionalVector> vectors= new ArrayList<>();
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);
        shapes.add(new Triangle(vectors));//6

        Collections.sort(shapes, Sort.BY_PERIMETER_ASCENDING);
        assertEquals(14.0, shapes.get(2).perimeter(), 0.01); //Rectangle
        assertEquals(12.56, shapes.get(1).perimeter(), 0.01); //Circle
        assertEquals(12.0, shapes.get(0).perimeter(), 0.01); //Triangle
    }

    @Test
    public void testByPerimeterDescending() throws Exception{
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(3, 4));//14
        shapes.add(new Circle(2));//12.56
        TwoDimensionalVector v1=new TwoDimensionalVector(0,0);
        TwoDimensionalVector v2=new TwoDimensionalVector(0,3);
        TwoDimensionalVector v3=new TwoDimensionalVector(4,0);
        List<TwoDimensionalVector> vectors= new ArrayList<>();
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);
        shapes.add(new Triangle(vectors));//6

        Collections.sort(shapes, Sort.BY_PERIMETER_DESCENDING);
        assertEquals(14.0, shapes.get(0).perimeter(), 0.01); //Rectangle
        assertEquals(12.56, shapes.get(1).perimeter(), 0.01); //Circle
        assertEquals(12.0, shapes.get(2).perimeter(), 0.01); //Triangle
    }

    @Test
    public void testInvalidSortCondition() throws Exception{
        ArrayList<Shape> shapes = new ArrayList<>();
        shapes.add(new Rectangle(3 ,4));
        shapes.add(new Circle(2));
        TwoDimensionalVector v1=new TwoDimensionalVector(0,0);
        TwoDimensionalVector v2=new TwoDimensionalVector(0,3);
        TwoDimensionalVector v3=new TwoDimensionalVector(4,0);
        List<TwoDimensionalVector> vectors= new ArrayList<>();
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);
        shapes.add(new Triangle(vectors));//6

        //若不是周長、面積或升序、降序，INPUT FILE要等於OUTPUT FILE;
        ArrayList<Shape> sortedShapes = new InputOutput().handleSort(shapes, "volume", "inc");
        assertEquals(shapes, sortedShapes); // Order remains the same
    }
}