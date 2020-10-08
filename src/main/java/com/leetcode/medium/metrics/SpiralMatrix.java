package com.leetcode.medium.metrics;

import java.util.ArrayList;
import java.util.List;

public class SpiralMatrix {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        System.out.println(spiralOrder(matrix));
    }

    public static List<Integer> spiralOrder(int[][] matrix) {

        int n = matrix.length, m = matrix[0].length;
        List<Integer> list = new ArrayList<>(n*m);
        int h_start = 0, h_end = m - 1, v_start = 0, v_end = n - 1;
        boolean[][] v = new boolean[n][m];
        while(h_start <= h_end && !v[h_start][h_end]) {

            for(int i = h_start; i <= h_end; i++) {
                list.add(matrix[h_start][i]);
                v[h_start][i] = true;
            }

            for(int i = v_start + 1; i <= v_end; i++) {
                list.add(matrix[i][h_end]);
                v[i][h_end] = true;
            }

            for(int i = h_end - 1; i >= h_start && v_start < v_end; i--) {
                list.add(matrix[v_end][i]);
                v[v_end][i] = true;
            }

            for(int i = v_end - 1; i >= v_start + 1 && h_start < h_end; i--) {
                list.add(matrix[i][v_start]);
                v[i][v_start] = true;
            }

            h_start++;
            h_end--;
            v_start++;
            v_end--;
        }

        return list;
    }
}
