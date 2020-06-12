package com.dp;

public class GoldMine {

    private int[][] mine;
    private int[][] dp;
    public GoldMine(int[][] mine) {
        this.mine = mine;
        this.dp = new int[mine.length][mine[0].length];
    }

    public static void main(String[] args) {

        int[][] mine = { { 1, 3, 1, 5 },
            { 2, 2, 4, 1 },
            { 5, 0, 2, 3 },
            { 0, 6, 1, 2 } };

        GoldMine goldMine = new GoldMine(mine);
        int maxGold = goldMine.getMaxGold();
        System.out.println(maxGold);
        System.out.println(recurse);
    }

    private int getMaxGold() {
        int maxSum = 0;
        for (int row = 0; row < mine.length; row++) {
            maxSum = Math.max(maxSum, findMaxElement(0, row));
        }
        return maxSum;
    }

    private static int recurse = 0;
    private int findMaxElement(int column, int row){

        recurse ++;
        if(row < 0 || row == mine[0].length || column == mine.length){
            return 0;
        }

        if(dp[row][column] > 0){
            System.out.println("dp");
            return dp[row][column];
        }

        int v1 = findMaxElement(column + 1, row), v2 = 0, v3 = 0;
        if(row > 0 || row < mine[0].length){
            v2 = findMaxElement(column + 1, row - 1);
            v3 = findMaxElement(column + 1, row + 1);
        }
        dp[row][column] = mine[row][column] + Math.max(Math.max(v1, v2), v3);
        return dp[row][column];
    }
}
