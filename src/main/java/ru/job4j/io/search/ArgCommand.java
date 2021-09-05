package ru.job4j.io.search;

import ru.job4j.io.ArgsName;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ArgCommand {

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
                throw new IllegalArgumentException("USE SAMPLE KEY(-d, -n, -t, -o)"
                        + "=ARGUMENT(FOLDER_DIRECTORY, NAME OR MASK OR REGEX, SEARCH TYPE AND OUTPUT_FILE)");
            }
            if (!splits[0].equals("-d") && !splits[0].equals("-n")
                    && !splits[0].equals("-t") && !splits[0].equals("-o")) {
                throw new IllegalArgumentException("USE SAMPLE KEY(-d, -n, -t, -o)");
            }
            if (splits[0].equals("-d")) {
                if (!Files.exists(Path.of(splits[1]))) {
                    throw new IllegalArgumentException("FOLDER " + splits[1] + " DON'T EXIST");
                }
            }
            if (splits[0].equals("-t")) {
                if (!splits[1].equals("mask") && !splits[1].equals("name") && !splits[1].equals("regex")) {
                    throw new IllegalArgumentException("FOLDER " + splits[1] + " DON'T EXIST");
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
        ArgCommand argCommand = (ArgCommand) o;
        return Objects.equals(values, argCommand.values);
    }

    @Override
    public int hashCode() {
        return Objects.hash(values);
    }

    public static ArgCommand of(String[] args) {
        ArgCommand names = new ArgCommand();
        if (args.length != 4) {
            throw new IllegalArgumentException("Usage java -jar find.jar FOLDER_DIRECTORY, NAME OR MASK OR REGEX,"
                    + " SEARCH TYPE AND OUTPUT_FILE.");
        }
        names.parse(args);
        return names;
    }
}
