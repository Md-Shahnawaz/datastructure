package com.leetcode.medium.array;

import java.util.Arrays;
import java.util.Comparator;

public class FindRightInterval {

    public static void main(String[] args) {
        int[][] intervals = new int[][] { {1,4}, {2,3}, {3,4} };
        FindRightInterval interval = new FindRightInterval();
        System.out.println(Arrays.toString(interval.findRightInterval(intervals)));
    }

    public int[] findRightInterval(int[][] intervals) {

        int n = intervals.length;
        int[][] start = new int[n][2];

        for (int i = 0; i < n; i++) {
            start[i][0] = intervals[i][0];
            start[i][1] = i;
        }

        Arrays.sort(start, Comparator.comparingInt((int[] i) -> i[0]));
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            int end = intervals[i][1];
            result[i] = searchRightInterval(end, i, start);
        }
        return result;
    }

    private int searchRightInterval(int item, int index, int[][] start) {

        int n = start.length, l = 0, r = n;
        while (l < r) {

            int mid = (l + r) / 2;
            if (start[mid][0] >= item) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l == n ? -1: start[l][1];
    }
}
