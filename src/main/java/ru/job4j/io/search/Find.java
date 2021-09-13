package ru.job4j.io.search;

import ru.job4j.io.SearchFiles;

import java.io.*;
import java.util.List;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.function.Predicate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Find {

    public List<String> find(Path path, Predicate<Path> condition) throws IOException {
        SearchFiles searcher = new SearchFiles(condition);
        Files.walkFileTree(path, searcher);
        return searcher.getList().stream()
                .map(p -> p.toAbsolutePath().toString())
                .collect(Collectors.toList());
    }

    public Predicate<Path> getPredicate(String key, String value) {
        if (key.equals("name")) {
            return p -> p.toFile().getName().equals(value);
        }
        if (key.equals("mask")) {
            return p -> Pattern.compile(".*\\." + value.substring(2)).matcher(p.toFile().getName()).matches();
        }
        if (key.equals("regex")) {
            return p -> Pattern.compile(value).matcher(p.toFile().getName()).matches();
        }
        return null;
    }

    public void print(String outPath, List<String> list) throws IOException {
        try (PrintWriter out = new PrintWriter(new FileOutputStream(outPath))) {
            for (String s : list) {
                out.println(s);
            }
        }
    }


    public static void main(String[] args) throws IOException {
        List<String> findResult;
        ArgCommand argCommand = ArgCommand.of(args);
        Find find = new Find();
        findResult = find.find(Path.of(argCommand.get("d")),
                find.getPredicate(argCommand.get("t"), argCommand.get("n")));
        find.print(argCommand.get("o"), findResult);
    }
}
