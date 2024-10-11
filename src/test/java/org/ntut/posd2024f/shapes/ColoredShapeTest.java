package org.ntut.posd2024f.shapes;


import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ColoredShapeTest {
    @Test
    public void testGetColor() {
        Shape circle = new Circle(1.0); // 假設圓形半徑為1
        ColoredShape coloredShape = new ColoredShape(circle, "RED");
        Assertions.assertEquals("RED", coloredShape.getColor());
        //assertEquals("RED", coloredShape.getColor());
    }

    @Test
    public void testGetShape() {
        Shape rectangle = new Rectangle(2.0, 3.0); // 假設矩形寬度為2，高度為3
        ColoredShape coloredShape = new ColoredShape(rectangle, "GREEN");
        Assertions.assertEquals(rectangle,coloredShape.getShape());
        //assertTrue(coloredShape.getShape() instanceof Rectangle);
    }

    @Test
    public void testGetAreaAndPerimeter() {
        Shape rectangle = new Rectangle(2.0, 3.0); // 假設矩形寬度為2，高度為3
        ColoredShape coloredShape = new ColoredShape(rectangle, "GREEN");
        Assertions.assertEquals(rectangle.area(),coloredShape.getShape().area());
        Assertions.assertEquals(rectangle.perimeter(),coloredShape.getShape().perimeter());
        //assertTrue(coloredShape.getShape() instanceof Rectangle);
    }

    @Test
    public void testIterator(){
        Rectangle rectangle1=new Rectangle(1,2);
        Rectangle rectangle2=new Rectangle(3,4);

        List<ColoredShape>coloredShapes=new ArrayList<>();
        coloredShapes.add(new ColoredShape(rectangle1,"GREEN"));
        coloredShapes.add(new ColoredShape(rectangle2,"RED"));



        Iterator<ColoredShape> iterator = coloredShapes.iterator();
        Assertions.assertTrue(iterator.hasNext());
        Assertions.assertEquals(rectangle1, iterator.next().getShape());
        Assertions.assertEquals(rectangle2, iterator.next().getShape());
        Assertions.assertFalse(iterator.hasNext());
    }






}
