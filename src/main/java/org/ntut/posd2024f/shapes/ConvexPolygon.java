package org.ntut.posd2024f.shapes;

import java.util.Iterator;
import java.util.List;

public class ConvexPolygon implements Shape {
    //該形狀由一組向量組成，這些向量需要按順時針或逆時針排序
    //如果未排序的話，應該拋出ShapeException異常。
    private List<TwoDimensionalVector> vectors;

    public ConvexPolygon(List<TwoDimensionalVector> vectors)throws ShapeException {
        if (!isConvex(vectors)) {
            throw new ShapeException("It's not a convex polygon!");
        }
        this.vectors = vectors;

    }

    // 檢查向量是否按順時針或逆時針排序
    private boolean isConvex(List<TwoDimensionalVector> vectors) {
        int n = vectors.size();
        if (n < 3) {
            return false; // 少於3個點無法構成多邊形
        }

        int crossProduct = 0;//用於記錄邊的方向（順時針或逆時針）
        for (int i = 0; i < n; i++) {//檢查三個相鄰向量 v1, v2, v3 之間的旋轉方向是否一致
            TwoDimensionalVector v1 = vectors.get(i);
            TwoDimensionalVector v2 = vectors.get((i + 1) % n);
            TwoDimensionalVector v3 = vectors.get((i + 2) % n);

            int cross = v2.subtract(v1).cross(v3.subtract(v2));
            // 向量減法，計算從一個點到另一個點的向量
            // 判斷兩個向量之間的旋轉方向
            // 若結果為正，表示是逆時針
            // 為負，則是順時針
            // 為 0 表示兩個向量共線（方向相同或相反）

            if (crossProduct == 0) {// 第一次判斷旋轉方向
                crossProduct = cross;// 將 crossProduct 設置為當前計算的cross結果
            } else if (crossProduct * cross < 0) { // 計算出新的 cross，如果 crossProduct * cross < 0，表示旋轉方向改變
                return false;
            }
        }
        return true;

    }

    @Override
    public double area() {
        //Shoelace Formula
        //Area(P1, P2, P3) = (x1y2 - x1y3 - x2y1 + x3y1 + x2y3 - x3y2) / 2
        double all = 0;
        int n = vectors.size();
        for (int i = 0; i < n; i++) {
            TwoDimensionalVector v1 = vectors.get(i);
            TwoDimensionalVector v2 = vectors.get((i + 1) % n);
            all += v1.cross(v2);
        }
        return Math.abs(all) / 2.0;
    }

    @Override
    public double perimeter() {
        double all = 0;
        int n = vectors.size();
        for (int i = 0; i < n; i++) {
            TwoDimensionalVector v1 = vectors.get(i);
            TwoDimensionalVector v2 = vectors.get((i + 1) % n);
            all += v1.subtract(v2).length();
        }
        return all;
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitConvexPolygon(this);
    }

    public List<TwoDimensionalVector> getVectors() {
        return vectors;
    }

   @Override
   public String toString() {
       StringBuffer sb=new StringBuffer();
       for (TwoDimensionalVector td : vectors) {
           sb.append(" ").append(td.toString());
       }
       return "ConvexPolygon"+sb;
   }

}