package com.leetcode.hard;

public class UniquePath {

    public static void main(String[] args) {
        System.out.println(new UniquePath().uniquePathsIII(new int[][] {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}}));
        System.out.println(new UniquePath().uniquePathsIII(new int[][] {{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 0, 2}}));
        System.out.println(new UniquePath().uniquePathsIII(new int[][] {{0, 1}, {2, 0}}));
    }

    private int[][] grid;
    private int totalRow;
    private int totalColumn;

    public int uniquePathsIII(int[][] grid) {

        this.totalRow = grid.length;
        this.totalColumn = grid[0].length;

        this.grid = grid;

        int totalNodeToBeVisited = 0;
        int startRow = 0, startCol = 0;

        for (int i = 0; i < totalRow; i++) {
            for (int j = 0; j < totalColumn; j++) {

                if (grid[i][j] == 1) {
                    startRow = i;
                    startCol = j;
                }

                if (grid[i][j] == 0) {
                    totalNodeToBeVisited += 1;
                }

            }
        }


        return solve(startRow, startCol, totalNodeToBeVisited);
    }

    private int solve(int row, int col, int totalNodeToBeVisited) {

        if (!isPossible(row, col)) {
            return 0;
        }

        if (grid[row][col] == 2) {
            if (totalNodeToBeVisited == -1) {
                return 1;
            }
            return 0;
        }
        int result = 0;

        result = getTotalPaths(row, col, row, col + 1, totalNodeToBeVisited, result);
        result = getTotalPaths(row, col, row + 1, col, totalNodeToBeVisited, result);
        result = getTotalPaths(row, col, row, col - 1, totalNodeToBeVisited, result);
        result = getTotalPaths(row, col, row - 1, col, totalNodeToBeVisited, result);

        return result;
    }

    private int getTotalPaths(int prevRow, int prevCol, int curRow, int curCol, int totalNodeToBeVisited, int result) {

        grid[prevRow][prevCol] = -1;
        result += solve(curRow, curCol, totalNodeToBeVisited - 1);
        grid[prevRow][prevCol] = 0;
        return result;
    }

    private boolean isPossible(int row, int column) {

        return row >= 0 && row < totalRow && column >= 0 && column < totalColumn && grid[row][column] != -1;
    }
}
