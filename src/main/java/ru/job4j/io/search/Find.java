package ru.job4j.io.search;

import ru.job4j.io.SearchFiles;

import java.io.*;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Find {

    public List<String> find(Path path, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(path, searcher);
        return searcher.getList().stream()
                .map(p -> p.toAbsolutePath().toString())
                .collect(Collectors.toList());
    }


    public static void main(String[] args) throws IOException {
        List<String> findResult = new ArrayList<>();
        ArgCommand argCommand = ArgCommand.of(args);
        if (argCommand.get("t").equals("name")) {
            findResult = new Find().find(Path.of(argCommand.get("d")),
                    p -> p.toFile().getName().equals(argCommand.get("n")));
        }
        if (argCommand.get("t").equals("mask")) {
            findResult = new Find().find(Path.of(argCommand.get("d")),
                    p -> p.toFile().getName().endsWith(argCommand.get("n")));
        }
        if (argCommand.get("t").equals("regex")) {
            findResult = new Find().find(Path.of(argCommand.get("d")),
                    p -> p.toFile().getName().matches(argCommand.get("n")));
        }
        try (PrintWriter out = new PrintWriter(new FileOutputStream(argCommand.get("o")))) {
            for (String s : findResult) {
                out.println(s);
            }
        }
    }
}
