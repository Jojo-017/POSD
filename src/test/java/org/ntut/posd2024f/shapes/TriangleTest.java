package org.ntut.posd2024f.shapes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.ntut.posd2024f.shapes.Shapes.Triangle;

public class TriangleTest {
    @Test(expected = Exception.class)//測試是否會拋出我們預期的Exception。
    public void testTriangleShapeException() throws Exception {
        TwoDimensionalVector v1=new TwoDimensionalVector(0,0);
        TwoDimensionalVector v2=new TwoDimensionalVector(0,0);
        TwoDimensionalVector v3=new TwoDimensionalVector(4,0);
        List<TwoDimensionalVector> vectors= new ArrayList<>();
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);
        Triangle triangle=new Triangle(vectors);

    }
    @Test
    public void testTrianglePerimeter() throws Exception {
        TwoDimensionalVector v1=new TwoDimensionalVector(0,0);
        TwoDimensionalVector v2=new TwoDimensionalVector(0,3);
        TwoDimensionalVector v3=new TwoDimensionalVector(4,0);
        List<TwoDimensionalVector> vectors= new ArrayList<>();
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);
        Triangle triangle=new Triangle(vectors);
        Assertions.assertEquals(12,triangle.perimeter(),0.01);

    }
    @Test
    public void testTriangleArea() throws Exception {
        TwoDimensionalVector v1=new TwoDimensionalVector(0,0);
        TwoDimensionalVector v2=new TwoDimensionalVector(0,3);
        TwoDimensionalVector v3=new TwoDimensionalVector(4,0);
        List<TwoDimensionalVector> vectors= new ArrayList<>();
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);
        Triangle triangle=new Triangle(vectors);
        Assertions.assertEquals(6,triangle.area(),0.01);

    }
}