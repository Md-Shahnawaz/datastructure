package com.test.optum;

import java.util.HashMap;
import java.util.Map;

public class HackerRank {

    public static void main(String[] args) {

    }

    static int[] matchingStrings(String[] strings, String[] queries) {

        Map<String, Integer> mapping = new HashMap<>();
        for (int i = 0; i < strings.length; i++) {
            mapping.putIfAbsent(strings[i], 0);
            mapping.computeIfPresent(strings[i], (k,v) -> v += 1);
        }

        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            result[i] = mapping.getOrDefault(queries[i],0);
        }
        return result;
    }
}
