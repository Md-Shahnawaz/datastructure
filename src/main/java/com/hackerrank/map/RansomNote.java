package com.hackerrank.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RansomNote {
    public static void main(String[] args) {

        String[] magazine = new String[]{"two", "times", "three", "is", "not", "four"};
        String[] note = new String[]{"two", "times", "two", "is", "four"};
        checkMagazine(magazine, note);
    }

    static void checkMagazine(String[] magazine, String[] note) {

        Map<String, Integer> mapping = new HashMap<>();
        for (String word: magazine) {
            mapping.putIfAbsent(word, 0);
            mapping.computeIfPresent(word, (k, v) -> v + 1);
        }

        for (String noteWord: note) {
            mapping.computeIfPresent(noteWord, (k, v) -> v - 1);
            Integer count = mapping.get(noteWord);
            if(Objects.isNull(count) || count < 0){
                System.out.println("No");
                return;
            }
        }
        System.out.println("Yes");
    }
}
