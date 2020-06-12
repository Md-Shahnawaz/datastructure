package com.leetcode.medium.path;

import java.util.Arrays;

public class MinimumPathSum {

    public static void main(String[] args) {
        int[][] input = new int[][]{ {1,3,9},
                                     {1,5,1},
                                     {4,2,1}};

        long tic2 = System.currentTimeMillis();
        System.out.println(new MinimumPathSum().minPathSumRec(input, 0, 0));
        long tac2 = System.currentTimeMillis();
        System.out.println("recursive :" + (tac2 - tic2));

        long tic = System.currentTimeMillis();
        System.out.println(new MinimumPathSum().minPathSum(input));
        long tac = System.currentTimeMillis();
        System.out.println("iterative :" + (tac - tic));
    }


    public int minPathSumRec(int[][] grid, int i, int j) {

        if(i == grid.length - 1 && j == grid[0].length - 1){
            return grid[i][j];
        }

        int sum = grid[i][j];
        int k = Integer.MAX_VALUE, l = Integer.MAX_VALUE;

        if(i >= 0 && i < grid.length && j + 1 >= 0 && j + 1 < grid[0].length){
            k = minPathSumRec(grid, i, j + 1);
        }

        if(i + 1 >= 0 && i + 1 < grid.length && j >= 0 && j < grid[0].length){
            l = minPathSumRec(grid, i + 1, j);
        }

        sum += Math.min(k, l);

        return sum;
    }


    public int minPathSum(int[][] grid) {

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {

                if(i == 0 && j == 0) continue;
                grid[i][j] += Math.min(possibleNum(grid, i, j - 1), possibleNum(grid, i - 1, j));

            }
        }
        return grid[grid.length - 1][grid[0].length - 1];
    }

    private int possibleNum(int[][] grid, int i, int j){

        if(i >= 0 && i < grid.length && j >= 0 && j < grid[0].length){
            return grid[i][j];
        }
        return Integer.MAX_VALUE;
    }
}
