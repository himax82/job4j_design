package ru.job4j.io;

import org.hamcrest.Matchers;
import org.junit.Test;
import ru.job4j.collection.SimpleQueue;

import java.util.NoSuchElementException;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class ConfigTest {

    @Test
    public void whenPairWithoutComment() {
        String path = "./data/pair_without_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Maksim"));
    }

    @Test
    public void whenPairWithCommentAndEmptyLine() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        assertThat(config.value("name"), is("Maksim"));
        assertThat(config.value("surname"), is("Pleskov"));
        assertThat(config.size(), is(2));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void whenEmptyKey() {
        String path = "./data/pair_with_comment.properties";
        Config config = new Config(path);
        config.load();
        config.value("fio");
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotSample() {
        String path = "./data/pair_with_not_sample.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotSampleLengthLess2() {
        String path = "./data/pair_with_not_sample_length.properties";
        Config config = new Config(path);
        config.load();
    }

    @Test(expected = IllegalArgumentException.class)
    public void whenNotSampleLengthMore2() {
        String path = "./data/pair_with_not_sample_length_more_2.properties";
        Config config = new Config(path);
        config.load();
    }
}