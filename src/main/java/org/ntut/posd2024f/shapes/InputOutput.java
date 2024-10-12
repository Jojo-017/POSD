package org.ntut.posd2024f.shapes;

import org.ntut.posd2024f.shapes.Shapes.Circle;
import org.ntut.posd2024f.shapes.Shapes.Rectangle;
import org.ntut.posd2024f.shapes.Shapes.Shape;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;

public class InputOutput {
    public InputOutput() {
    }

    //NumberFormatException：將string轉int時，若其中有字母或符號(非數字)的字時，會出現的Exception

    // 讀取輸入檔案，將形狀轉換為 Shape 物件列表
    public ArrayList<Shape> handleInput(String inputFileName) throws NumberFormatException, Exception {
        ArrayList<Shape> shapes = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFileName))) {
            String s;
            while ((s = reader.readLine()) != null) {
                Shape shape = ConstructShape(s);
                if(shape!=null)shapes.add(shape);
            }
        } catch (Exception e) {
            throw new Exception("Error reading input file: " + inputFileName, e);
        }

        return shapes;
    }


    // 根據條件進行排序
    public ArrayList<Shape> handleSort(ArrayList<Shape> Shapes, String compare, String order) {
        Comparator<Shape> comparator = null;

        if (compare.equals("area")) {
            if(order.equals("inc")) comparator=Sort.BY_AREA_ASCENDING;
            else if(order.equals("dec"))comparator=Sort.BY_AREA_DESCENDING;
        } else if (compare.equals("perimeter")) {
            if(order.equals("inc")) comparator=Sort.BY_PERIMETER_ASCENDING;
            else if(order.equals("dec"))comparator=Sort.BY_PERIMETER_DESCENDING;
        }

        //如果沒有compare、order，comparator會等於null，then input file會等於output file
        if (comparator != null) {
            Shapes.sort(comparator); //用comparator排序
            //返回<0，表示left < right
            //返回=0，表示left = right
            //返回>0，表示left > right
        }
        //因為sort排序會用compare的回傳值判斷，若>0就對調，否則不變（所以升序left、right，降序right、left）


        return Shapes;
    }

    public void handleOutput(ArrayList<Shape> Shapes, String outputFileName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(outputFileName))) {
            for (Shape temp : Shapes) {
                writer.write(temp.toString());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //根據str，建構對應的shape object
    private Shape ConstructShape(String str) throws NumberFormatException, Exception {

        String[] s = str.split(" ");//透過空格將字串分開
        String shapeType = s[0]; //第一個是形狀

        try {
            switch (shapeType.toLowerCase()) {//轉小寫
                case "circle"://string int
                    if (s.length != 2) {
                        throw new Exception("It's not a circle!");
                    }
                    double r = Double.parseDouble(s[1]);
                    return new Circle(r);

                case "rectangle"://str int int
                    if (s.length != 3) {
                        throw new Exception("It's not a rectangle!");
                    }
                    double l = Double.parseDouble(s[1]);
                    double w = Double.parseDouble(s[2]);
                    return new Rectangle(l, w);

                /*
                case "triangle"://str int int int
                    if (s.length != 4) {
                        throw new Exception("It's not a triangle!");
                    }
                    TwoDimensionalVector v1=new TwoDimensionalVector(Integer.parseInt(s[1]),0);
                    TwoDimensionalVector v2=new TwoDimensionalVector(0,3);
                    TwoDimensionalVector v3=new TwoDimensionalVector(4,0);
                    List<TwoDimensionalVector> vectors= new ArrayList<>();
                    vectors.add(v1);
                    vectors.add(v2);
                    vectors.add(v3);

                    double a = Double.parseDouble(s[1]);
                    double b = Double.parseDouble(s[2]);
                    double c = Double.parseDouble(s[3]);
                    return new Triangle(vectors);*/
                default:
                    return null;
            }
        } catch (NumberFormatException e) {
            throw new Exception("Invalid number format!");
        }
    }


}
