package ru.job4j.io;

import ru.job4j.map.Map;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Analizy {
    public void unavailable(String source, String target) {
        List<String> list = new ArrayList<>();
        try (BufferedReader read = new BufferedReader(new FileReader(source));
             PrintWriter out = new PrintWriter(new FileOutputStream(target))) {
            String l;
            String key = null;
            while ((l = read.readLine()) != null) {
                if (l.startsWith("500") || l.startsWith("400")) {
                    if (key == null) {
                        String[] ar = l.split(" ");
                        key = ar[1];
                    }
                    }
                if (l.startsWith("200") || l.startsWith("300")) {
                    if (key != null) {
                        String[] ar = l.split(" ");
                        out.println(key + ";" + ar[1]);
                        key = null;
                    }
                }
                }
            }
        catch (IOException e) {
            e.printStackTrace();
        }
    }



    public static void main(String[] args) {
        try (PrintWriter out = new PrintWriter(new FileOutputStream("unavailable.csv"))) {
            out.println("15:01:30;15:02:32");
            out.println("15:10:30;23:12:32");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}