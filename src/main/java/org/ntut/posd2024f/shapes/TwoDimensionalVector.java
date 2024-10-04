package org.ntut.posd2024f.shapes;

public class TwoDimensionalVector {//代表2D空間向量的類，包含x和y兩個屬性
    private int x; // 向量的x座標
    private int y; // 向量的y座標

    public TwoDimensionalVector(int x, int y) {
        this.x=x;
        this.y=y;
    }

    public double length() {//計算向量的長度
        return Math.sqrt(x * x + y * y);
    }

    public int dot(TwoDimensionalVector v) {//計算兩個向量的dot product
        return this.x * v.x + this.y * v.y;
    }

    public int cross(TwoDimensionalVector v) {//計算兩個向量的cross product
        return this.x * v.y - this.y * v.x;
    }

    public TwoDimensionalVector subtract(TwoDimensionalVector v) {//減去兩個向量，並返回新的向量
        return new TwoDimensionalVector(this.x - v.x, this.y - v.y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}