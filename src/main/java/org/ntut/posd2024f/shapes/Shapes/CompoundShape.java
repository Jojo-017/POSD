package org.ntut.posd2024f.shapes.Shapes;

import org.ntut.posd2024f.shapes.Visitor.Visitor;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CompoundShape implements Shape { //包含多個形狀
    private List<Shape> shapes;

    public CompoundShape() {
        this.shapes = new ArrayList<>();
    }

    public CompoundShape(List<Shape> shapes) {
        this.shapes=shapes;
    }
    @Override
    public double area() {//計算列表中所有形狀的總面積
        double all=0;
        for(Shape shape:shapes){
            all+=shape.area();
        }
        return all;
    }
    @Override
    public double perimeter() {//計算列表中所有形狀的總周長
        double all=0;
        for(Shape shape:shapes){
            all+=shape.perimeter();
        }
        return all;
    }

    @Override
    public void add(Shape shape) {//將一個形狀添加到列表中
        shapes.add(shape);
    }

    @Override
    public Iterator<Shape> iterator() {
        //該方法應返回一個迭代器，能遍歷CompoundShape中的元素。
        return shapes.iterator();
        //return new CompoundShapeIterator(shapes);
    }

    @Override
    public <T> void accept(Visitor<T> visitor) {
        visitor.visitCompoundShape(this);
        /*
        for (Shape shape : shapes) {
            shape.accept(visitor);
        }*/
    }

/*
    @Override
    public String toString() {
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<this.shapes.size();i++) {
            sb.append("\n");
            sb.append("  ").append(shapes.get(i).toString());
            if(i==this.shapes.size()-1)sb.append("\n");
        }
        return "CompoundShape {"+sb+"}";

    }*/


}
