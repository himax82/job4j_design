package ru.job4j.io;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.StringJoiner;
import java.util.stream.Collectors;

public class Config {

    private final String path;
    private final Map<String, String> values = new HashMap<String, String>();

    public Config(final String path) {
        this.path = path;
    }

    public void load() {
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
           String l;
           while ((l = read.readLine()) != null) {
               if (!l.startsWith(" ") && !l.startsWith("#") && !l.equals("")) {
                   String[] ar = l.split("=");
                   if (ar.length != 2 || ar[0].endsWith(" ") || ar[1].startsWith(" ")){
                       throw new IllegalArgumentException();
                   } else {
                       values.put(ar[0], ar[1]);
                   }
               }
           }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int size() {
        return values.size();
    }

    public String value(String key) {
        if (values.containsKey(key)) {
            return values.get(key);
        } else {
            throw new UnsupportedOperationException("Don't impl this method yet!");
        }
    }

    @Override
    public String toString() {
        StringJoiner out = new StringJoiner(System.lineSeparator());
        try (BufferedReader read = new BufferedReader(new FileReader(this.path))) {
            read.lines().forEach(out::add);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return out.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Config("app.properties"));
    }

}