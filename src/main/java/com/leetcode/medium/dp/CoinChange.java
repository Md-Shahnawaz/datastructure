package com.leetcode.medium.dp;

import java.util.Arrays;

public class CoinChange {

    public static void main(String[] args) {

        System.out.println(coinChange(new int[] {186, 419, 83, 408}, 6249));
        System.out.println(coinChange(new int[] {1, 2, 5}, 11));
        System.out.println(coinChange(new int[] {2}, 3));
    }

    public static int coinChange(int[] coins, int amt) {

        int[] dp = new int[amt + 1];
        Arrays.fill(dp, amt + 1);
        dp[0] = 0;
        for (int j = 0; j < coins.length; j++) {
            for (int i = 0; i <= amt; i++) {
                if (i >= coins[j]) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - coins[j]]);
                }
            }
        }
        return dp[amt] == amt + 1? -1: dp[amt];
    }
}
