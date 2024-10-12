package org.ntut.posd2024f.shapes;

import java.util.Iterator;

public class PrettyPrintVisitor implements Visitor<String> {
    private StringBuffer sb=new StringBuffer();
   // private final String indent="  ";
    private int indentCount=0;

    public StringBuffer dealWithIndent(StringBuffer sb,int indentCount){
        for (int i = 0; i < indentCount; ++i)
        {
            sb.append("  ");
        }
        return sb;
    }

    @Override
    public void visitCircle(Circle circle) {
        //sb=dealWithIndent(sb,indentCount);
        //circle.accept(this);
        sb.append(circle.toString());
    }

    @Override
    public void visitRectangle(Rectangle rectangle) {
        //sb=dealWithIndent(sb,indentCount);
        //rectangle.accept(this);
        sb.append(rectangle.toString());
    }

    @Override
    public void visitTriangle(Triangle triangle) {
        //sb=dealWithIndent(sb,indentCount);
        //triangle.accept(this);
        sb.append(triangle.toString());
    }

    @Override
    public void visitConvexPolygon(ConvexPolygon convexPolygon) {
        //sb=dealWithIndent(sb,indentCount);
        //convexPolygon.accept(this);
        //sb.append(convexPolygon.toString());

        sb.append("ConvexPolygon");
        //append(convexPolygon.getVectors().toString()).append("\n");
        for (TwoDimensionalVector td : convexPolygon.getVectors()) {
            sb.append(" ").append(td.toString());
        }

    }

    @Override
    public void visitCompoundShape(CompoundShape compoundShape) {
        //sb=dealWithIndent(sb,indentCount);
        //sb.append("CompoundShape {");

        //sb.append(compoundShape.toString());
        //sb.append("}");

        sb.append("CompoundShape {");
        indentCount++;
        for (Iterator<Shape> it = compoundShape.iterator(); it.hasNext(); )  {
            sb.append("\n");
            sb=dealWithIndent(sb,indentCount);
            Shape shape = it.next();
            shape.accept(this);
            if(!it.hasNext())sb.append("\n").append("}");
        }
        indentCount--;
        //sb.append("}");
    }

    @Override
    public void visitTextedShape(TextedShape textedShape) {
        //sb=dealWithIndent(sb,indentCount);
        //, text: Hello
        textedShape.getShape().accept(this);
        sb.append(", text: ").append(textedShape.getText());
    }

    @Override
    public void visitColoredShape(ColoredShape coloredShape) {
        //sb=dealWithIndent(sb,indentCount);
        //sb.append(coloredShape.toString());

        switch (coloredShape.getColor()) {
            case "RED":
                sb.append("\033[0;31m");
                break;
            case "GREEN":
                sb.append("\033[0;32m");
                break;
            case "BLUE":
                sb.append("\033[0;34m");
                break;
            default:
                sb.append("\033[0m");
                break;
        }
        //Shape temp=coloredShape.getShape();
        //String tempS=temp.toString();
        coloredShape.getShape().accept(this);
        sb.append("\033[0m");
    }

    @Override
    public String getResult() {
       return sb.toString();
    }
}
