package ru.job4j.map;

import org.junit.Assert;
import org.junit.Test;
import ru.job4j.list.List;
import ru.job4j.list.SimpleArrayList;

import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class SimpleMapTest {

    @Test
    public void whenAddOne() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        simpleMap.put(2, "two");
        Iterator<Integer> iterator = simpleMap.iterator();
        Assert.assertEquals(Integer.valueOf(2), iterator.next());
    }

    @Test
    public void whenAddMany() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        simpleMap.put(2, "two");
        simpleMap.put(5, "five");
        simpleMap.put(6, "six");
        Iterator<Integer> iterator = simpleMap.iterator();
        ArrayList<Integer> list = new ArrayList<>();
        Assert.assertTrue(iterator.hasNext());
        list.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        list.add(iterator.next());
        Assert.assertTrue(iterator.hasNext());
        list.add(iterator.next());
        Assert.assertFalse(iterator.hasNext());
        assertThat(list.contains(6), is(true));
        assertThat(list.contains(5), is(true));
        assertThat(list.contains(2), is(true));
    }

    @Test
    public void whenGetOne() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        simpleMap.put(2, "two");
        simpleMap.put(5, "five");
        simpleMap.put(6, "six");
        assertThat(simpleMap.get(5), is("five"));
        assertThat(simpleMap.get(2), is("two"));
    }

    @Test
    public void whenGetOneAfterAdd() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        simpleMap.put(2, "two");
        simpleMap.put(5, "five");
        simpleMap.put(6, "six");
        assertThat(simpleMap.get(2), is("two"));
        simpleMap.put(10, "ten");
        simpleMap.put(1, "one");
        assertThat(simpleMap.get(5), is("five"));
    }

    @Test
    public void whenGetNull() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        simpleMap.put(2, "two");
        simpleMap.put(5, "five");
        simpleMap.put(6, "six");
        assertNull(simpleMap.get(10));
    }

    @Test
    public void whenRemoveTrue() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        simpleMap.put(2, "two");
        simpleMap.put(5, "five");
        simpleMap.put(6, "six");
        assertTrue(simpleMap.remove(5));
        assertNull(simpleMap.get(5));
    }

    @Test
    public void whenRemoveFalse() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        simpleMap.put(2, "two");
        simpleMap.put(5, "five");
        simpleMap.put(6, "six");
        assertFalse(simpleMap.remove(1));
    }

    @Test
    public void whenExpandTrue() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        simpleMap.put(2, "two");
        simpleMap.put(5, "five");
        simpleMap.put(6, "six");
        simpleMap.put(1, "one");
        simpleMap.put(3, "three");
        simpleMap.put(4, "for");
        simpleMap.put(10, "ten");
        simpleMap.put(7, "seven");
        simpleMap.put(9, "nine");
        assertThat(simpleMap.get(9), is("nine"));
    }

    @Test(expected = ConcurrentModificationException.class)
    public void whenAddAfterGetIteratorThenMustBeException() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        simpleMap.put(2, "two");
        simpleMap.put(5, "five");
        Iterator<Integer> iterator = simpleMap.iterator();
        iterator.next();
        simpleMap.put(1, "one");
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void whenGetIteratorFromEmptyListThenNextThrowException() {
        SimpleMap<Integer, String> simpleMap = new SimpleMap<>();
        Iterator<Integer> iterator = simpleMap.iterator();
        iterator.next();
    }

}