package ru.job4j.question;

import java.util.*;
import java.util.regex.Pattern;

public class Analize {

    public static Info diff(Set<User> previous, Set<User> current) {
        Set<User> addSet = new HashSet<>(previous);
        addSet.addAll(current);
        Map<Integer, User> chMap = new HashMap<>();
        for (User u : addSet) {
            chMap.put(u.getId(), u);
        }
        int ch = addSet.size() - chMap.size();
        int add = addSet.size() - previous.size() - ch;
        int del = addSet.size() - current.size() - ch;
        return new Info(add, ch, del);
    }
}
