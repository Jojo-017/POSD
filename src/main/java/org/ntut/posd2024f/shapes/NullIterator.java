package org.ntut.posd2024f.shapes;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NullIterator implements Iterator<Shape> {

    @Override
    public boolean hasNext(){
        return false; // 沒有下一個元素
    }

    @Override
    public Shape next() throws NoSuchElementException{
        //拋出NoSuchElementException，並帶有訊息Null iterator does not point to any element。
        throw new NoSuchElementException("Null iterator does not point to any element");
    }
}
