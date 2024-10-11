package org.ntut.posd2024f.shapes;

import org.junit.Test;

import org.junit.jupiter.api.Assertions;

public class NullIteratorTest {
    @Test
    public void testNullIteratorHasNext(){
        NullIterator nullIterator=new NullIterator();
        Assertions.assertFalse(nullIterator.hasNext());
    }

    @Test(expected = Exception.class)
    public void testNullIteratorNext(){
        NullIterator nullIterator=new NullIterator();
        nullIterator.next();
    }
}
