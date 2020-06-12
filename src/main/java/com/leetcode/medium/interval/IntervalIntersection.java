package com.leetcode.medium.interval;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IntervalIntersection {

    public static void main(String[] args) {
//        int[][] result = intervalIntersection(new int[][] {{0, 2}, {5, 10}, {13, 23}, {24, 25}},
//            new int[][] {{3, 5}, {8, 12}, {15, 24}, {25, 26}});

//        int[][] result = intervalIntersection(new int[][] {{8, 15}}, new int[][] {{2, 6},{8,10},{12,20}});
//        Arrays.stream(result).forEach(r -> {
//            System.out.println(Arrays.toString(r));
//        });

        System.out.println(frequencySort("tree"));
    }

    public static int[][] intervalIntersection(int[][] A, int[][] B) {

        List<Pair> result = new ArrayList<>();
        if(A.length == 0 || B.length == 0) return A.length == 0 ? A : B;
        int i = 0, j = 0;
        while(true) {

            if ((A[i][0] <= B[j][0] && A[i][1] >= B[j][0]) || (A[i][0] >= B[j][0] && A[i][0] <= B[j][1])) {

                result.add(new Pair(Math.max(A[i][0], B[j][0]), Math.min(A[i][1], B[j][1])));
            }

            if (A[i][1] <= B[j][1]) {
                i++;
            } else {
                j++;
            }

            if (i == A.length || j == B.length) {
                break;
            }
        }

        int[][] resultArray = new int[result.size()][2];
        for (int k = 0; k < result.size(); k++) {
            resultArray[k][0] = result.get(k).x;
            resultArray[k][1] = result.get(k).y;
        }
        return resultArray;
    }

    private static class Pair implements Comparable {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public Pair() {
        }

        @Override
        public int compareTo(Object o) {
            Pair p1 = (Pair) o;
            return Integer.valueOf(p1.y).compareTo(this.y);
        }
    }

    public static String frequencySort(String s) {

        Pair[] buffer = new Pair[256];
        for (int i = 0; i < 256; i++) {
            buffer[i] = new Pair();
        }
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            buffer[(int)ch].x = s.charAt(i);
            buffer[(int)ch].y++;
        }
        Arrays.sort(buffer);
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (buffer[i].x > 0) {
            Pair p = buffer[i];
            int count = p.y;
            while(count > 0) {
                sb.append((char)p.x);
                count --;
            }
            i++;
        }
        return sb.toString();
    }
}
