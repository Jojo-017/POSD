package org.ntut.posd2024f.shapes;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.ntut.posd2024f.shapes.Shapes.Circle;

public class CircleTest {

    @Test(expected = Exception.class)//測試是否會拋出我們預期的Exception。
    public void testCircleShapeException() throws Exception {
        Circle c=new Circle(-1);
    }

    @Test
    public void testCircleAre() throws Exception {
        Circle c=new Circle(1.0);
        Assertions.assertEquals(3.14, c.area(),0.01);
    }



    @Test
    public void testCirclePerimeter() throws Exception {
        Circle c=new Circle(1.0);
        Assertions.assertEquals(6.28, c.perimeter(),0.01);
    }


    @Test
    public void testCircleToString(){
        Circle circle=new Circle(1.0);
        Assertions.assertEquals("Circle 1.0",circle.toString());
    }




}