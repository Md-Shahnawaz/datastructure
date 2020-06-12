package com.hackerrank.map;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class TwoString {

    public static void main(String[] args) {
        twoStrings("hello", "world");
    }

    static String twoStrings(String s1, String s2) {

        Set<String> s1Set = Arrays.stream(s1.split(""))
            .map(String::trim)
            .filter(s -> !s.isEmpty())
            .collect(Collectors.toSet());
        System.out.println(s1Set);
        Set<String> s2Set = Arrays.stream(s2.split(""))
            .map(String::trim)
            .filter(s -> !s.isEmpty())
            .collect(Collectors.toSet());
        for (String s2token: s2Set) {
            if(s1Set.contains(s2token)){
                return "YES";
            }
        }
        return "NO";
    }
}
