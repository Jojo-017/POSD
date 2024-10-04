package org.ntut.posd2024f.shapes;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NullIteratorTest {
    @Test
    public void testNullIteratorHasNext(){
        NullIterator nullIterator=new NullIterator();
        assertEquals(false,nullIterator.hasNext());
    }

    @Test(expected = Exception.class)
    public void testNullIteratorNext(){
        NullIterator nullIterator=new NullIterator();
        nullIterator.next();
    }
}
