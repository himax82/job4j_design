package ru.job4j.it;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Optional;

public class MatrixIt implements Iterator<Integer> {
    private final int[][] data;
    private int row = 0;
    private int column = 0;

    public MatrixIt(int[][] data) {
        this.data = data;
    }

    @Override
    public boolean hasNext() {
        return row < data.length && column < data[data.length - 1].length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int rsl = 0;
        if (column < data[row].length - 1) {
                rsl = data[row][column++];
            }
         else {
            try {
                rsl = data[row++][column];
                column = 0;
            } catch (ArrayIndexOutOfBoundsException e) {
               rsl = next();
            }
        }
        return rsl;
    }
}
