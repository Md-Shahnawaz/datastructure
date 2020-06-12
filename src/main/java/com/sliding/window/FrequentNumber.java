package com.sliding.window;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class FrequentNumber {

    public static void main(String[] args) {
        int[] n = new int[] {1, 2, 2, 2, 4, 4, 4, 4, 5, 5, 5, 5, 5, 7, 7, 8, 8, 8, 8};
        int k = 4;
        System.out.println(frequentNumber(n, k));
    }

    private static int frequentNumber(int[] n, int k) {

        Map<Integer, Integer> collector = new HashMap<>();
        for (int i = 0; i < n.length; i++) {
            collector.computeIfPresent(n[i], (ke, v) -> ++v);
            collector.putIfAbsent(n[i], 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> maxHeap = new PriorityQueue<>(Comparator.comparingInt(e -> -(e.getValue())));
        collector.entrySet().forEach(e -> maxHeap.add(e));

        int element = 0;
        for (int i = 0; i < k; i++) {
            element = maxHeap.poll().getValue();
        }
        return element;
    }
}
