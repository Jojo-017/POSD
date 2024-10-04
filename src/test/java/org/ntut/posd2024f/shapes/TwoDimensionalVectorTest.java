package org.ntut.posd2024f.shapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TwoDimensionalVectorTest {
    @Test
    public void testTwoDimensionalVectorLength(){
        TwoDimensionalVector twoDimensionalVector=new TwoDimensionalVector(0,3);
        assertEquals(3,twoDimensionalVector.length(),0.1);

    }
    @Test
    public void testTwoDimensionalVectorDot(){
        TwoDimensionalVector twoDimensionalVector1=new TwoDimensionalVector(0,3);
        TwoDimensionalVector twoDimensionalVector2=new TwoDimensionalVector(3,0);
        assertEquals(0,twoDimensionalVector1.dot(twoDimensionalVector2));

    }
    @Test
    public void testTwoDimensionalVectorCross(){
        TwoDimensionalVector twoDimensionalVector1=new TwoDimensionalVector(0,3);
        TwoDimensionalVector twoDimensionalVector2=new TwoDimensionalVector(3,0);
        assertEquals(-9,twoDimensionalVector1.cross(twoDimensionalVector2));

    }

    @Test
    public void testTwoDimensionalVectorSubtract(){
        TwoDimensionalVector twoDimensionalVector1=new TwoDimensionalVector(0,3);
        TwoDimensionalVector twoDimensionalVector2=new TwoDimensionalVector(3,0);
        TwoDimensionalVector twoDimensionalVector3=new TwoDimensionalVector(-3,3);
        assertEquals(twoDimensionalVector3.getX(),twoDimensionalVector1.subtract(twoDimensionalVector2).getX());
        assertEquals(twoDimensionalVector3.getY(),twoDimensionalVector1.subtract(twoDimensionalVector2).getY());

    }
}