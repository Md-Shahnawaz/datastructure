package com.matrix;

import java.util.Arrays;

public class MinimumCostPath {

    public static void main(String[] args) {
        int[][] costMatrix = { { 3, 2, 8 }, { 1, 9, 7 }, { 0, 5, 2 }, {6, 4, 3} };
        System.out.println("Minimum cost: " + minimumCostPathDP(costMatrix, 3, 2));
    }

    private static int minimumCostPathDP(int[][] costMatrix, int m, int n) {

        int totalRows = costMatrix.length;
        int totalColumn = costMatrix[0].length;

        for (int i = 0; i < totalRows; i++) {
            for (int j = 0; j < totalColumn; j++) {
                if(i == 0 && j == 0) continue;
                int c1 = (j - 1) >= 0 ? costMatrix[i][j-1] : Integer.MAX_VALUE;
                int c2 = (i - 1) >= 0 ? costMatrix[i - 1][j] : Integer.MAX_VALUE;
                int c3 = (j - 1) >= 0 && (i - 1) >= 0 ? costMatrix[i-1][j-1] : Integer.MAX_VALUE;
                costMatrix[i][j] += Math.min(c1, Math.min(c2, c3));
            }
        }

        System.out.println(Arrays.toString(costMatrix[0]));
        System.out.println(Arrays.toString(costMatrix[1]));
        System.out.println(Arrays.toString(costMatrix[2]));
        System.out.println(Arrays.toString(costMatrix[3]));
        return costMatrix[m][n];
    }

}
