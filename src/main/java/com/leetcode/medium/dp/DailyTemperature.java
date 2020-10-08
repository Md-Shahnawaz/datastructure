package com.leetcode.medium.dp;

import java.util.Arrays;

public class DailyTemperature {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));


        //[89,62,70,58,47,47,46,76,100,70]
    }
    public static int[] dailyTemperatures(int[] T) {

        int[] dp = new int[T.length];
        for (int i = T.length - 2; i >= 0; i--) {

            int j = i + 1;
            if (T[i] >= T[j]) {
                dp[i] = 0;
                int tmp = 1;
                while (dp[j] > 0 && T[i] >= T[j]) {
                    tmp += dp[j];
                    j += dp[j];
                }

                if (T[j] > T[i]) {
                    dp[i] = tmp;
                }
            } else {
                dp[i] = 1;
            }
        }
        return dp;
    }
}
