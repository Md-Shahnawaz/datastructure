package com.graph;

public class IceLand {

    public static void main(String[] args)
    {
        int[][] matrix = {
            {1, 0, 1, 0, 1},
            {1, 1, 0, 0, 0},
            {0, 1, 0, 1, 1},
        };

        IceLand solution = new IceLand();

        System.out.println(solution.findNumberOfClusters(matrix));
    }

    private int findNumberOfClusters(int[][] matrix) {

        boolean[][] visited = new boolean[matrix.length][matrix[0].length];

        int[] possibleMoves = new int[]{-1, 0, 1};

        int count = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 1 && !visited[i][j]) {
                    doDfs(matrix, visited, possibleMoves, i, j);
                    count += 1;
                }
            }
        }
        return count;
    }

    private void doDfs(int[][] matrix, boolean[][] visited, int[] possibleMoves, int i, int j) {

        if(visited[i][j]){
            return;
        }

        visited[i][j] = true;

        for (int k = 0; k < possibleMoves.length; k++) {
            for (int l = 0; l < possibleMoves.length; l++) {
                int tempi = i + possibleMoves[k];
                int tempj = j + possibleMoves[l];
                if(tempi < 0 || tempj < 0 || tempi>= matrix.length || tempj >= matrix[0].length){
                    continue;
                }
                if(matrix[tempi][tempj] == 1 && !visited[tempi][tempj]){
                    doDfs(matrix, visited, possibleMoves,  tempi, tempj);
                }
            }
        }
    }
}
