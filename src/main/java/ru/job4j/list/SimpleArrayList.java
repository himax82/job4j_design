package ru.job4j.list;

import java.util.*;

public class SimpleArrayList<T> implements List<T> {

    private T[] container;

    private int size;

    private int modCount;

    public SimpleArrayList(int capacity) {
        this.container = (T[]) new Object[capacity];
    }

    @Override
    public void add(T value) {
        if (container.length == size) {
            container = Arrays.copyOf(container, container.length * 2);
        }
        container[size++] = value;
        modCount++;
    }

    @Override
    public T set(int index, T newValue) {
        Objects.checkIndex(index, size);
        T old = container[index];
        container[index] = newValue;
        return old;
    }

    @Override
    public T remove(int index) {
        Objects.checkIndex(index, size);
        T temp = container[index];
        System.arraycopy(container, index + 1, container, // куда копируем
                index, size - index - 1);
        container[size - 1] = null;
        size--;
        modCount++;
        return temp;
    }

    @Override
    public T get(int index) {
        Objects.checkIndex(index, size);
        return container[index];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            int index = 0;
            int expectedModCount = modCount;

            @Override
            public boolean hasNext() {
               return index < size;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return container[index++];
            }

        };
    }
}
