package com.leetcode.medium.metrics;

public class CountSquares {

    public static void main(String[] args) {

        System.out.println(countSquares(new int[][]{
            {0,1,1,1},
            {1,1,1,1},
            {0,1,1,1}
        }));

        System.out.println(countSquares(new int[][]{
            {1,0,1},
            {1,1,0},
            {1,1,0}
        }));
    }

    public static int countSquares(int[][] matrix) {

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if(i > 0 && j > 0 && matrix[i][j] > 0 && matrix[i - 1][j - 1] > 0){
                    matrix[i][j] += Math.min(matrix[i - 1][j - 1], Math.min(matrix[i][j - 1], matrix[i - 1][j]));
                }
                count += matrix[i][j];
            }
        }
        return count;
    }
}
