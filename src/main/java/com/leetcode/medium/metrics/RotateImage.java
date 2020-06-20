package com.leetcode.medium.metrics;

import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) {
        int[][] image = new int[][]{{1,2,3,4},
                                    {5,6,7,8},
                                    {9,10,11,12},
                                    {13,14,15,16}};
        rotate(image);
        Arrays.stream(image).forEach(row -> System.out.println(Arrays.toString(row)));
    }
    public static void rotate(int[][] matrix) {
        for(int i= 0; i < matrix.length; i ++) {
            int l = 0, r = matrix.length - 1;
            while(l < r) {
                int temp = matrix[i][l];
                matrix[i][l] = matrix[i][r];
                matrix[i][r] = temp;
                l++;
                r--;
            }
        }
        int n = matrix.length - 1;
        for(int i = 0; i < matrix.length; i ++) {
            for(int j = 0; j < matrix.length - i; j ++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[n - j][n - i];
                matrix[n - j][n - i] = temp;
            }
        }
    }
}
