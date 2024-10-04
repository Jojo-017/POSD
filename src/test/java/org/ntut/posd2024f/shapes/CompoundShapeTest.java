package org.ntut.posd2024f.shapes;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

public class CompoundShapeTest {
    @Test
    public void TestCompoundShapeArea(){
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

        CompoundShape compoundShape=new CompoundShape(shapes);
        assertEquals(30.56,compoundShape.area(),0.01);

    }

    @Test
    public void TestCompoundShapePerimeter(){
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
        shapes.add(new Triangle(vectors));//12

        CompoundShape compoundShape=new CompoundShape(shapes);
        assertEquals(38.56,compoundShape.perimeter(),0.01);

    }
    @Test
    public void testCompoundShapeIterator(){
        CompoundShape compoundShape=new CompoundShape();

        TwoDimensionalVector v1=new TwoDimensionalVector(0,0);
        TwoDimensionalVector v2=new TwoDimensionalVector(0,3);
        TwoDimensionalVector v3=new TwoDimensionalVector(4,0);
        List<TwoDimensionalVector> vectors= new ArrayList<>();
        vectors.add(v1);
        vectors.add(v2);
        vectors.add(v3);
        Triangle triangle=new Triangle(vectors);
        compoundShape.add(triangle);
        Rectangle rectangle=new Rectangle(3,4);
        compoundShape.add(rectangle);//14
        Circle circle=new Circle(2);
        compoundShape.add(circle);//12.56

        Iterator<Shape> iterator = compoundShape.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(triangle, iterator.next());
        assertEquals(rectangle, iterator.next());
        assertEquals(circle, iterator.next());
        assertFalse(iterator.hasNext());
    }
}
