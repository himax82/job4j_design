package ru.job4j.io;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ConsoleChat {

    private final String path;
    private final String botAnswers;
    private static final String OUT = "закончить";
    private static final String STOP = "стоп";
    private static final String CONTINUE = "продолжить";

    public ConsoleChat(String path, String botAnswers) {
        this.path = path;
        this.botAnswers = botAnswers;
    }

    public void run() {
        List<String> log = new ArrayList<>();
        List<String> answers = readPhrases();
        System.out.println("Консольный чат");
        Scanner scanner = new Scanner(System.in);
        String phrase = scanner.nextLine();
        log.add(phrase);
        while (!phrase.equals(OUT)) {
                if (phrase.equals(STOP)) {
                    phrase = scanner.nextLine();
                    log.add(phrase);
                    while (!phrase.equals(CONTINUE)) {
                        phrase = scanner.nextLine();
                        log.add(phrase);
                    }
                }
                String answ = answers.get((int) (Math.random() * (answers.size() - 1)));
                System.out.println(answ);
                log.add(answ);
                phrase = scanner.nextLine();
                log.add(phrase);
        }
        saveLog(log);
    }

    private List<String> readPhrases() {
        List<String> list = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(botAnswers, StandardCharsets.UTF_8))) {
            list = br.lines().collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private void saveLog(List<String> log) {
        try (PrintWriter pw = new PrintWriter(
                new FileWriter(path, StandardCharsets.UTF_8, true))) {
            for (String str : log) {
                pw.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        ConsoleChat cc = new ConsoleChat("c:\\projects\\job4j_design\\data\\log.txt",
                "c:\\projects\\job4j_design\\data\\answer.txt");
        cc.run();
    }
}
