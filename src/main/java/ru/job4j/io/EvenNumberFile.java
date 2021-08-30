package ru.job4j.io;

import java.io.FileInputStream;

public class EvenNumberFile {

    public String read(String path) {
        try (FileInputStream in = new FileInputStream(path)) {
            StringBuilder text = new StringBuilder();
            int read;
            while ((read = in.read()) != -1) {
                text.append((char) read);
            }
            return text.toString();
        } catch (Exception e) {
                e.printStackTrace();
            }
        return null;
    }

    public void printEven(String text) {
        String[] lines = text.split(System.lineSeparator());
        for (String line : lines) {
            if (Integer.parseInt(line) % 2 == 0) {
                System.out.println(line + " число четное");
            } else {
                System.out.println(line + " число нечетное");
            }
        }
    }

    public static void main(String[] args) {
        EvenNumberFile readFile = new EvenNumberFile();
        readFile.printEven(readFile.read("even.txt"));
    }
}