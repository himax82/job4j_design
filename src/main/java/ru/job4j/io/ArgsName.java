package ru.job4j.io;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ArgsName {

    private final Map<String, String> values = new HashMap<>();

    public String get(String key) {
        if (values.size() == 0) {
            throw new IllegalArgumentException();
        }
        return values.get(key);
    }

    private void parse(String[] args) {
        for (String s : args) {
            String[] splits = s.split("=");
            if (splits.length != 2) {
                throw new IllegalArgumentException("USE SAMPLE KEY(-path, -delimiter, -out, -filter)"
                        + "=ARGUMENT(SCV_IN_FILE, DELIMITER, OUT(FILENAME OR STDOUT) AND FILTER_ATRIBUTS)");
            }
            if (!splits[0].equals("-path") && !splits[0].equals("-delimiter")
                    && !splits[0].equals("-out") && !splits[0].equals("-filter")) {
                throw new IllegalArgumentException("USE SAMPLE KEY(-path, -delimiter, -out, -filter)");
            }
            if (splits[0].equals("-path")) {
                if (!Files.exists(Path.of(splits[1]))) {
                    throw new IllegalArgumentException("FILE " + splits[1] + " DON'T EXIST");
                }
            }
            values.put(splits[0].substring(1), splits[1]);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ArgsName argsName = (ArgsName) o;
        return Objects.equals(values, argsName.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    public static ArgsName of(String[] args) {
        ArgsName names = new ArgsName();
        if (args.length != 4) {
            throw new IllegalArgumentException("Usage java -jar CSV.jar SCV_IN_FILE, DELIMITER,"
                    + " OUT(FILENAME OR STDOUT) AND FILTER_ATRIBUTS.");
        }
        names.parse(args);
        return names;
    }

}
