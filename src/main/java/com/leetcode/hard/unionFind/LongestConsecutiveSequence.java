package com.leetcode.hard.unionFind;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
    public static void main(String[] args) {

    }

    public int longestConsecutive(int[] nums) {
        Set<Integer> mapping = new HashSet<>();
        for (int num : nums) {
            mapping.add(num);
        }
        int tmpMax = 0, max = 0;
        for (int i : nums) {
            System.out.println(mapping);
            tmpMax = 0;
            if (mapping.contains(i)) {
                int prev = i, next = i;
                tmpMax++;
                while (mapping.contains(prev - 1)) {
                    mapping.remove(prev - 1);
                    prev = prev - 1;
                    tmpMax++;
                }

                while (mapping.contains(next + 1)) {
                    mapping.remove(next + 1);
                    next = next + 1;
                    tmpMax++;
                }
                mapping.remove(i);
            }

            max = Math.max(max, tmpMax);
        }

        return max;
    }
}
