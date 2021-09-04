package ru.job4j.io;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
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
                throw new IllegalArgumentException("USE SAMPLE KEY(-d, -e or -o)=ARGUMENT(PACK_FOLDER, EXCLUDE FILES AND INPUT_NAME_FILE)");
            }
            if (!splits[0].equals("-d") && !splits[0].equals("-e") && !splits[0].equals("-o")) {
                throw new IllegalArgumentException("USE SAMPLE KEY(-d, -e or -o)");
            }
            if (splits[0].equals("-d")) {
                if (!Files.exists(Path.of(splits[1]))) {
                    throw new IllegalArgumentException("FOLDER" + splits[1] + "DON'T EXIST");
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
        if (args.length != 3) {
            throw new IllegalArgumentException("Usage java -jar zip.jar PACK_FOLDER, EXCLUDE FILES AND INPUT_NAME_FILE.");
        }
        names.parse(args);
        return names;
    }

}
