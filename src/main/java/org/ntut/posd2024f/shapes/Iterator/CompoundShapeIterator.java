package org.ntut.posd2024f.shapes.Iterator;

import org.ntut.posd2024f.shapes.Shapes.Shape;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CompoundShapeIterator implements Iterator<Shape> {
    private final List<Shape> shapes;
    private int position = 0;

    public CompoundShapeIterator(List<Shape> shapes) {
        this.shapes = shapes;
    }

    @Override
    public boolean hasNext() {
        return position < shapes.size();
    }

    @Override
    public Shape next() throws NoSuchElementException{
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the iterator.");
        }
        return shapes.get(position++);
    }
}
