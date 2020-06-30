package com.leetcode.medium.graph.bfs;

import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2,1,1},{1,1,0},{0,1,1}}));
        System.out.println(orangesRotting(new int[][]{{0,2}}));
        System.out.println(orangesRotting(new int[][]{{1},{2},{2}}));
        System.out.println(orangesRotting(new int[][]{{0}}));
        System.out.println(orangesRotting(new int[][]{{1}}));
        System.out.println(orangesRotting(new int[][]{{2}}));
    }

    public static int orangesRotting(int[][] grid) {

        int fresh_orange = 0;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new int[]{i, j});
                }
                if (grid[i][j] == 1) {
                    fresh_orange++;
                }
            }
        }

        int count = -1;
        while (!queue.isEmpty()) {

            count++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cord = queue.poll();

                if (isPossible(cord[0] + 1, cord[1], grid)) {
                    queue.add(new int[]{cord[0] + 1, cord[1]});
                    grid[cord[0] + 1][cord[1]] = 2;
                    fresh_orange--;
                }
                if (isPossible(cord[0] - 1, cord[1], grid)) {
                    queue.add(new int[]{cord[0] - 1, cord[1]});
                    grid[cord[0] - 1][cord[1]] = 2;
                    fresh_orange--;
                }
                if (isPossible(cord[0], cord[1] + 1, grid)) {
                    queue.add(new int[]{cord[0], cord[1] + 1});
                    grid[cord[0]][cord[1] + 1] = 2;
                    fresh_orange--;
                }
                if (isPossible(cord[0], cord[1] - 1, grid)) {
                    queue.add(new int[]{cord[0], cord[1] - 1});
                    grid[cord[0]][cord[1] - 1] = 2;
                    fresh_orange--;
                }
            }
        }

        if(fresh_orange > 0) return -1;

        return count == -1 ? 0 : count;
    }

    private static boolean isPossible(int i, int j, int[][] grid) {
        return i >= 0 && j >= 0 && i < grid.length && j < grid[0].length && grid[i][j] == 1;
    }
}
