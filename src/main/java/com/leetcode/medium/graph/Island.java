package com.leetcode.medium.graph;

public class Island {

    public static void main(String[] args) {
        System.out.println(new Island().numIslands(new char[][]{{'1','1','1','1','0'},
                                                                {'1','1','0','1','0'},
                                                                {'1','1','0','0','0'},
                                                                {'0','0','0','0','0'}}));

        System.out.println(new Island().numIslands(new char[][]{{'1','1','0','0','0'},
                                                                {'1','1','0','0','0'},
                                                                {'0','0','1','0','0'},
                                                                {'0','0','0','1','1'}}));
    }

    public int numIslands(char[][] grid) {

        int island = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if(dfs(grid, i, j)){
                    island += 1;
                }
            }
        }
        return island;
    }

    private boolean dfs(char[][] island, int i, int j){

        if(!isPossible(island, i, j)){
            return false;
        }

        island[i][j] = '0';
        dfs(island, i, j + 1);
        dfs(island, i, j - 1);
        dfs(island, i + 1, j);
        dfs(island, i - 1, j);

        return true;

    }

    private boolean isPossible(char[][] island, int i, int j) {
        return i >= 0 && i < island.length && j >= 0 && j < island[0].length && island[i][j] == '1';
    }
}
