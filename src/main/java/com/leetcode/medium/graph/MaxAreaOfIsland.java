package com.leetcode.medium.graph;

public class MaxAreaOfIsland {

    public static void main(String[] args) {

        int[][] grid = new int[][]
            {{0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}};
//        int[][] grid = new int[][]{{0,0,0,0,0,0,0,0}};
        System.out.println(maxAreaOfIsland(grid));
    }

    public static int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(grid[i][j] == 1){
                    maxArea = Math.max(dfs(grid, i, j, 1), maxArea);
                }
            }
        }
        return maxArea;
    }

    private static int dfs(int[][] grid, int i, int j, int area){

        if(!isPossible(grid, i, j)){
            return area - 1;
        }

        grid[i][j] = 0;
        area = dfs(grid, i, j + 1, area + 1);
        area = dfs(grid, i, j - 1, area + 1);
        area = dfs(grid, i + 1, j, area + 1);
        area = dfs(grid, i - 1, j, area + 1);

        return area;
    }

    private static boolean isPossible(int[][] grid, int i, int j){
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1;
    }
}
