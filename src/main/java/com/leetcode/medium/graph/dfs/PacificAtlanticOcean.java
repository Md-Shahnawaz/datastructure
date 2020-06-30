package com.leetcode.medium.graph.dfs;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class PacificAtlanticOcean {

    public static void main(String[] args) {
        System.out.println(pacificAtlantic(new int[][] {{1,2,2,3,5},
                                                        {3,2,3,4,4},
                                                        {2,4,5,3,1},
                                                        {6,7,1,4,5},
                                                        {5,1,1,2,4}}));
        System.out.println(pacificAtlantic(new int[][] {{1, 2, 3},
                                                        {8, 9, 4},
                                                        {7, 6, 5}}));
    }

    public static List<List<Integer>> pacificAtlantic(int[][] matrix) {
        if (matrix == null || matrix.length == 0) {
            return new LinkedList();
        }

        List<List<Integer>> res = new LinkedList();

        int m = matrix.length;
        int n = matrix[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        boolean[][] pVisited = new boolean[m][n];
        boolean[][] aVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            helper(matrix, pacific, pVisited, i, 0);
            helper(matrix, atlantic, aVisited, i, n - 1);
        }

        for (int j = 0; j < n; j++) {
            helper(matrix, pacific, pVisited, 0, j);
            helper(matrix, atlantic, aVisited, m - 1, j);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    List<Integer> list = new LinkedList();
                    list.add(i);
                    list.add(j);
                    res.add(list);
                }
            }
        }

        return res;

    }

    private static void helper(int[][] matrix, boolean[][] water, boolean[][] visited, int x, int y) {
        if (x < 0 || y < 0 || x >= matrix.length || y >= matrix[0].length) {
            // out of bounds
            return;
        } else {
            if (visited[x][y]) {
                // visited
                return;
            }

            visited[x][y] = true;
            water[x][y] = true;

            int src = matrix[x][y];

            if (water[x][y]) {
                if (x > 0 && src <= matrix[x - 1][y]) {
                    // up
                    helper(matrix, water, visited, x - 1, y);
                }

                if (x < matrix.length - 1 && src <= matrix[x + 1][y]) {
                    // down
                    helper(matrix, water, visited, x + 1, y);
                }

                if (y > 0 && src <= matrix[x][y - 1]) {
                    // left
                    helper(matrix, water, visited, x, y - 1);
                }

                if (y < matrix[0].length - 1 && src <= matrix[x][y + 1]) {
                    helper(matrix, water, visited, x, y + 1);
                }
            }
        }
    }
}
