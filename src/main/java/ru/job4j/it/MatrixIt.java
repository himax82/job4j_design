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
        for (int i = row; i < data.length; i++) {
            if (data[i].length == 0 || data[i].length == column) {
                row++;
                column = 0;
            } else {
            break;
            }
        }
        return row < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return data[row][column++];
    }
}
