package com.leetcode.medium.metrics;

import java.util.Arrays;

public class MaximalSquare {

    public static void main(String[] args) {

//        char[][] map = new char[][]{{'1', '0', '1', '0', '0'},
//                                    {'1', '0', '1', '1', '1'},
//                                    {'1', '1', '1', '1', '1'},
//                                    {'1', '0', '0', '1', '0'}};
//        char[][] map = new char[][]{{'0', '0', '0', '1'},
//            {'1', '1', '0', '1'},
//            {'1', '1', '1', '1'},
//            {'0', '1', '1', '1'},
//            {'0', '1', '1', '1'}};
        char[][] map = new char[][]{{'1'}};
        System.out.println(maximalSquare(map));
    }

    public static int maximalSquare(char[][] matrix) {

        if(matrix.length == 0) return 0;
        int max = 0;
        int[][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < result.length; i++) {
            Arrays.fill(result[i], 1);
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] > '0'){
                    max = 1;
                }
            }
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][j] > '0'){
                    result[i][j] += Math.min(result[i - 1][j - 1], Math.min(result[i][j - 1], result[i - 1][j])) + 1;
                    max = Math.max(max, result[i][j]);
                }
            }
        }
        return max * max;
    }
}
