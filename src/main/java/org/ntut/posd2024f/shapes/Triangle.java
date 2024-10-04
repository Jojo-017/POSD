package org.ntut.posd2024f.shapes;

import java.util.List;

public class Triangle implements Shape {
    //使用TwoDimensionalVector來構造三角形
    private TwoDimensionalVector v1, v2, v3;


    public Triangle(List<TwoDimensionalVector> vectors) throws ShapeException{
        if (vectors.size() != 3) {
            throw new ShapeException("It's not a triangle!");
        }
        this.v1 = vectors.get(0);
        this.v2 = vectors.get(1);
        this.v3 = vectors.get(2);

        // 檢查是否形成一個有效的三角形（沒平行）
        if (v1.subtract(v2).cross(v1.subtract(v3)) == 0) {
            throw new ShapeException("It's not a triangle!");
        }
    }


    public double perimeter() {
        // 計算三個頂點之間的距離
        double side1 = v1.subtract(v2).length();
        double side2 = v2.subtract(v3).length();
        double side3 = v3.subtract(v1).length();
        return side1 + side2 + side3;
    }

    public double area() {
        // 使用兩個向量的叉積來計算三角形的面積
        TwoDimensionalVector v1v2 = v2.subtract(v1);
        TwoDimensionalVector v1v3 = v3.subtract(v1);
        return Math.abs(v1v2.cross(v1v3)) / 2.0;
    }
}
