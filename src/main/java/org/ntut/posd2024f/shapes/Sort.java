package org.ntut.posd2024f.shapes;

import org.ntut.posd2024f.shapes.Shapes.Shape;

import java.util.Comparator;

public class Sort{
    public static Comparator<Shape> BY_AREA_ASCENDING = new ByAreaAscending();
    public static Comparator<Shape> BY_AREA_DESCENDING = new ByAreaDescending();
    public static Comparator<Shape> BY_PERIMETER_ASCENDING = new ByPerimeterAscending();
    public static Comparator<Shape> BY_PERIMETER_DESCENDING = new ByPerimeterDescending();



    //面積升序
    private static class ByAreaAscending implements Comparator<Shape> {
        public int compare(Shape left, Shape right){
            return Double.compare(left.area(), right.area());
            //返回<0，表示left < right
            //返回=0，表示left = right
            //返回>0，表示left > right
        }
    }

    //面積降序
    private static class ByAreaDescending implements Comparator<Shape> {
        public int compare(Shape left, Shape right){
            return Double.compare(right.area(), left.area());
        }
    }

    //周長升序
    private static class ByPerimeterAscending implements Comparator<Shape> {
        public int compare(Shape left, Shape right){
            return Double.compare(left.perimeter(), right.perimeter());
        }
    }

    //周長降序
    private static class ByPerimeterDescending implements Comparator<Shape> {
        public int compare(Shape left, Shape right){
            return Double.compare(right.perimeter(), left.perimeter());
        }
    }

}





