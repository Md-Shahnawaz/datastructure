package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class ReconstructQueue {

    public static void main(String[] args) {
        int[][] result = reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}});
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public static int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, Comparator.comparingInt((int[] p) -> -p[0]).thenComparingInt(p -> p[1]));
        ArrayList<int[]> list = new ArrayList<>();
        for (int[] ele : people) {
            list.add(ele[1], ele);
        }
        return list.toArray(new int[people.length][2]);
    }
}
