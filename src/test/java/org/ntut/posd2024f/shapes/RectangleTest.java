package org.ntut.posd2024f.shapes;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.ntut.posd2024f.shapes.Shapes.Rectangle;
//import org.junit.jupiter.api.Assertions;


public class RectangleTest {

    @Test(expected = Exception.class)//測試是否會拋出我們預期的Exception。
    public void testRecException() throws Exception {
        Rectangle r =new Rectangle(-5.0,6.0);
    }

    @Test
    public void testRecAre() throws Exception {
        Rectangle r =new Rectangle(5.0,6.0);
        Assertions.assertEquals(30, r.area(),0.01);
    }

    @Test
    public void testRecPerimeter() throws Exception {
        Rectangle r =new Rectangle(5.0,6.0);
        Assertions.assertEquals(22, r.perimeter(),0.01);
    }


}