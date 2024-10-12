package org.ntut.posd2024f.shapes;

import java.util.ArrayList;

public final class Geo {
    /**
     * @param args The arguments of the program.
     * @throws Exception
     * @throws NumberFormatException
     */
    public static void main(String[] args) throws NumberFormatException, Exception {
        InputOutput io = new InputOutput();

        ///*
        ArrayList<Shape> Shapes = io.handleInput(args[0]);//input file
        Shapes = io.handleSort(Shapes, args[2], args[3]);//condition(條件)、order(升序/降序)
        io.handleOutput(Shapes, args[1]);//output file
        // */
        //--------------------------------------------------
        /*
        ArrayList<Shape> Shapes = io.handleInput("test_data/input.txt");//input file
        Shapes = io.handleSort(Shapes, "area", "inc");//condition(條件)、order(升序/降序)
        io.handleOutput(Shapes, "test_data/output.txt");//output file
        */
    }
}
