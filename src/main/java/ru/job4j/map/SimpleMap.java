package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class SimpleMap<K, V> implements Map<K, V> {

    private static final float LOAD_FACTOR = 0.75f;

    private int capacity = 8;

    private int count = 0;

    private int modCount = 0;

    private MapEntry<K, V>[] table = new MapEntry[capacity];

    @Override
    public boolean put(K key, V value) {
        int index = indexFor(hash(key.hashCode()));
        if (count >= capacity * LOAD_FACTOR) {
           expand();
        }
        if (table[index] == null) {
            table[index] = new MapEntry<>(key, value);
            count++;
            modCount++;
            return true;
        } else {
            if (table[index].value.equals(value)) {
                table[index].value = value;
            }
        }
        return false;
    }

    private int hash(int hashCode) {
        return hashCode & (capacity-1);
    }

    private int indexFor(int hash) {
        return Math.abs(hash);
    }

    private void expand() {
        capacity = capacity * 2;
        MapEntry<K, V>[] newTable = new MapEntry[capacity];
        for (int i = 0; i < count; i++) {
            if (table[i] != null) {
                newTable[indexFor(hash(table[i].key.hashCode()))]
                        = new MapEntry<>(table[i].key, table[i].value);
            }
        }
        table = newTable;
    }

    private boolean isPresent(K key) {
        return table[indexFor(hash(key.hashCode()))] != null
                && table[indexFor(hash(key.hashCode()))].key.equals(key);
    }

    @Override
    public V get(K key) {
        if (isPresent(key)) {
            return table[indexFor(hash(key.hashCode()))].value;
        }
        return null;
    }

    @Override
    public boolean remove(K key) {
        if (isPresent(key)) {
            table[indexFor(hash(key.hashCode()))] = null;
            count--;
            modCount++;
            return true;
        }
        return false;
    }

    @Override
    public Iterator<K> iterator() {
        return new Iterator<>() {

            int index = 0;
            int expectedModCount = modCount;
            int size = 0;

            @Override
            public boolean hasNext() {
                return index < count;
            }

            @Override
            public K next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                for (int i = size; i < capacity; i++) {
                    if (table[i] != null) {
                        index++;
                        size++;
                        return table[i].key;
                    }
                    size++;
                }
                return null;
            }
        };
    }

    private static class MapEntry<K, V> {

        K key;
        V value;

        public MapEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }

    }

}
