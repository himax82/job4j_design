package ru.job4j.io;

import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizyTest {

    @Test
    public void whenReadAndWriteLog() {
        String path = "./data/system.log";
        String out = "./data/stop.log";
        Analizy analizy = new Analizy();
        analizy.unavailable(path, out);
    }

}