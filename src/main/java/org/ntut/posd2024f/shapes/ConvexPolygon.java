package org.ntut.posd2024f.shapes;

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

        boolean flag = false;
        for (int i = 0; i < n; i++) {
            TwoDimensionalVector v1 = vectors.get(i);
            TwoDimensionalVector v2 = vectors.get((i + 1) % n);
            TwoDimensionalVector v3 = vectors.get((i + 2) % n);

            // 計算v1v2和v2v3的cross product來判斷方向
            TwoDimensionalVector v1v2 = v2.subtract(v1);
            TwoDimensionalVector v2v3 = v3.subtract(v2);
            int crossProduct = v1v2.cross(v2v3);

            if (i == 0) {
                flag = crossProduct > 0;
            } else if (flag != (crossProduct > 0)) {
                return false; // 如果cross product符號不同，return false
            }
        }
        return true;
    }

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
}