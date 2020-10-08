package com.leetcode.medium.dp;

public class MinCostTicket {

    public static void main(String[] args) {

        System.out.println(minCostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{2, 7, 15}));
        System.out.println(minCostTickets(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31, 365}, new int[]{2, 7, 15}));
        System.out.println(minCostTickets(new int[]{1, 4, 6, 7, 8, 20}, new int[]{7, 2, 15}));
    }

    public static int minCostTickets(int[] days, int[] costs) {
        int[] dp = new int[396];
        for(int i = 31, j = 0; i < 396; i++){
            if(j < days.length && (i - 30) == days[j]) {
                dp[i] = Math.min((dp[i - 1] + costs[0]), Math.min((dp[i - 7] + costs[1]), (dp[i - 30] + costs[2])));
                j++;
            } else {
                dp[i] = dp[i - 1];
            }
        }
        return dp[395];
    }
}
