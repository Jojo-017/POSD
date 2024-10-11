package org.ntut.posd2024f.shapes;

import java.util.List;

public class Triangle implements Shape {
    //使用TwoDimensionalVector來構造三角形
    private List<TwoDimensionalVector> vectors;
    //private TwoDimensionalVector v1, v2, v3;


    public Triangle(List<TwoDimensionalVector> vectors) throws ShapeException{
        if (vectors.size() != 3) {
            throw new ShapeException("It's not a triangle!");
        }
        this.vectors=vectors;

        // 檢查是否形成一個有效的三角形（沒平行）
        if (vectors.get(0).subtract(vectors.get(1)).cross(vectors.get(0).subtract(vectors.get(2))) == 0) {
            throw new ShapeException("It's not a triangle!");
        }
    }

    @Override
    public  void add(Shape shape) throws ShapeException{
        //該方法應該拋出ShapeException，並帶有訊息Illegal Operation
        throw new ShapeException("Illegal Operation IN Triangle");

    }

    @Override
    public double perimeter() {
        // 計算三個頂點之間的距離
        double side1 = vectors.get(0).subtract(vectors.get(1)).length();
        double side2 = vectors.get(1).subtract(vectors.get(2)).length();
        double side3 = vectors.get(2).subtract(vectors.get(0)).length();
        return side1 + side2 + side3;
    }
    @Override
    public double area() {
        // 使用兩個向量的叉積來計算三角形的面積
        TwoDimensionalVector v1v2 = vectors.get(1).subtract(vectors.get(0));
        TwoDimensionalVector v1v3 = vectors.get(2).subtract(vectors.get(0));
        return Math.abs(v1v2.cross(v1v3)) / 2.0;
    }
    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitTriangle(this);
    }

    public List<TwoDimensionalVector> getVectors() {
        return this.vectors;
    }
    @Override
    public String toString() {
        return "Triangle " + vectors.get(0).toString() + " " + vectors.get(1).toString() + " " + vectors.get(2).toString();
    }
}
