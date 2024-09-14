package org.ntut.posd2024f.shapes;

import java.lang.Math;
import java.util.ArrayList;
import java.util.Arrays;

public class Triangle implements Shape
{
    private  double a;
    private  double b;
    private  double c;

    Triangle(double a, double b, double c) throws Exception {
        if (a <= 0 || b <= 0 || c <= 0 || !isTriangle(a, b, c)) {
            throw new Exception("It's not a triangle!");
        }
        this.a=a;
        this.b=b;
        this.c=c;
    }

    //用三角不等式確認是不是三角形
    private boolean isTriangle(double a, double b, double c) {
        return (a + b > c) && (a + c > b) && (b + c > a);
    }

    public double perimeter() {
        return a+b+c;
    }

    public double area() {
        double s=(a+b+c)/2;
        return Math.sqrt(s*(s-a)*(s-b)*(s-c));
    }

    public String toString() {
        return "Triangle " + a + " " + b + " " + c;
    }
}
