package ru.job4j.io.duplicates;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;

public class DuplicatesVisitor extends SimpleFileVisitor<Path> {

    private final HashSet<FileProperty> fileSetAll = new HashSet<>();
    private final HashSet<FileProperty> fileSetDubl = new HashSet<>();

    public HashSet<FileProperty> getPathSetDubl() {
        return fileSetDubl;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        FileProperty fileProperty = new FileProperty(attrs.size(), file.getFileName().toString());
        if (file.toFile().isFile()) {
            if (!fileSetAll.add(fileProperty)) {
                fileSetDubl.add(fileProperty);
            }
        }
        return FileVisitResult.CONTINUE;
    }
}