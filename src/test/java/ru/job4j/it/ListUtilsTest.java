package ru.job4j.it;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertThat;

public class ListUtilsTest {

    @Test
    public void whenAddBefore() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 1, 2);
        assertThat(Arrays.asList(1, 2, 3), Is.is(input));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void whenAddBeforeWithInvalidIndex() {
        List<Integer> input = new ArrayList<>(Arrays.asList(1, 3));
        ListUtils.addBefore(input, 3, 2);
    }

    @Test
    public void whenAddAfter() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 4, 5));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3, 4, 5), Is.is(input));
    }

    @Test
    public void whenAddAfterLast() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2));
        ListUtils.addAfter(input, 2, 3);
        assertThat(Arrays.asList(0, 1, 2, 3), Is.is(input));
    }

    @Test
    public void whenRemoveIfOven() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 4, 5));
        ListUtils.removeIf(input, t -> t % 2 == 0);
        assertThat(Arrays.asList(1, 5), Is.is(input));
    }

    @Test
    public void whenReplaceIfOven() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 4, 5));
        ListUtils.replaceIf(input, t -> t % 2 == 0, 0);
        assertThat(Arrays.asList(0, 1, 0, 0, 5), Is.is(input));
    }

    @Test
    public void whenRemoveAll() {
        List<Integer> input = new ArrayList<>(Arrays.asList(0, 1, 2, 4, 5));
        List<Integer> input1 = new ArrayList<>(Arrays.asList(2, 4));
        ListUtils.removeAll(input, input1);
        assertThat(Arrays.asList(0, 1, 5), Is.is(input));
    }
}