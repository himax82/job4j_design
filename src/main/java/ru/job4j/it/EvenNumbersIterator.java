package ru.job4j.it;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class EvenNumbersIterator implements Iterator<Integer> {

    private int[] data;
    private int index;

    public EvenNumbersIterator(int[] data) {
        this.data = data;
    }

    public List<Integer> evenList(int[] dataOrig) {
        return Arrays.stream(dataOrig)
                .boxed()
                .filter(x -> x % 2 == 0)
                .collect(Collectors.toList());
    }

    @Override
    public boolean hasNext() {
        return evenList(data).size() > index;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        return evenList(data).get(index++);
    }
}
