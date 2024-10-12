package org.ntut.posd2024f.shapes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;

public class ConvexPolygonTest {
    @Test
    public void testConvexPolygonArea(){
        List<TwoDimensionalVector> vectors =new ArrayList<>();;
        TwoDimensionalVector v1=new TwoDimensionalVector(4,3);
        TwoDimensionalVector v2=new TwoDimensionalVector(4,-3);
        TwoDimensionalVector v3=new TwoDimensionalVector(-4,-3);
        TwoDimensionalVector v4=new TwoDimensionalVector(-4,3);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);
        vectors.add(v4);

        ConvexPolygon convexPolygon=new ConvexPolygon(vectors);
        Assertions.assertEquals(48,convexPolygon.area(),0.01);


    }

    @Test
    public void testConvexPolygonPerimeter(){
        List<TwoDimensionalVector> vectors=new ArrayList<> (); ;
        TwoDimensionalVector v1=new TwoDimensionalVector(4,3);
        TwoDimensionalVector v2=new TwoDimensionalVector(4,-3);
        TwoDimensionalVector v3=new TwoDimensionalVector(-4,-3);
        TwoDimensionalVector v4=new TwoDimensionalVector(-4,3);
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);
        vectors.add(v4);

        ConvexPolygon convexPolygon=new ConvexPolygon(vectors);
        Assertions.assertEquals(28,convexPolygon.perimeter(),0.01);


    }
}