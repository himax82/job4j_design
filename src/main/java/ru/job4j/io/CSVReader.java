package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CSVReader {

    private final List<List<String>> lists = new ArrayList<>();

    public void readCSV(String out, String delimiter) {
        List<String> listLine = new ArrayList<>();
        try (Scanner scanner = new Scanner(Path.of(out))) {
            while (scanner.hasNextLine()) {
                Scanner scannerLine = new Scanner(scanner.nextLine()).useDelimiter(delimiter);
                while (scannerLine.hasNext()) {
                    listLine.add(scannerLine.next());
                }
                lists.add(listLine);
                listLine = new ArrayList<>();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeCSV(String path, String arg) {
        String[] argArray = arg.split(",");
        int[] argIndex = new int[argArray.length];
        for (int i = 0; i < argArray.length; i++) {
            for (String s : lists.get(0)) {
                if (argArray[i].equals(s)) {
                    argIndex[i] = lists.get(0).indexOf(s);
                }
            }
        }
        if (path.equals("stdout")) {
            for (List<String> list : lists) {
                for (int i : argIndex) {
                    System.out.print(list.get(i));
                    System.out.print(";");
                }
                System.out.print(System.lineSeparator());
            }
        }
        try (PrintWriter out = new PrintWriter(
                new BufferedOutputStream(
                        new FileOutputStream(path)
                ))) {
            for (List<String> list : lists) {
                for (int i : argIndex) {
                    out.print(list.get(i));
                    out.print(";");
                }
                out.print(System.lineSeparator());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ArgsName argsName = ArgsName.of(args);
        CSVReader csvReader = new CSVReader();
        csvReader.readCSV(argsName.get("path"), argsName.get("delimiter"));
        csvReader.writeCSV(argsName.get("out"), argsName.get("filter"));
    }
}

