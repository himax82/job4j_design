package ru.job4j.io;

import java.io.*;
import java.nio.file.Path;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Zip {

    public static void packFiles(List<Path> sources, File target) {
            try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
                for (Path p : sources) {
                    zip.putNextEntry(new ZipEntry(p.toFile().getPath()));
                    try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(p.toFile().getPath()))) {
                        zip.write(out.readAllBytes());
                        zip.closeEntry();
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

    public static void packSingleFile(File source, File target) {
        try (ZipOutputStream zip = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)))) {
            zip.putNextEntry(new ZipEntry(source.getPath()));
            try (BufferedInputStream out = new BufferedInputStream(new FileInputStream(source))) {
                zip.write(out.readAllBytes());
                zip.closeEntry();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        ArgsName jvm = ArgsName.of(args);
        List<Path> zipList = Search.search(Path.of(jvm.get("d")), p -> p.toFile().toString().endsWith(jvm.get("e")));
        Zip.packFiles(zipList, Path.of(jvm.get("o")).toFile());
    }
}

