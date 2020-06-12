package com.dp;

import java.util.Arrays;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence lis = new LongestCommonSubsequence();
//        int[] nums = {4, 2, 3, 6, 10, 1, 12};
//        System.out.println(lis.findLISLength(nums));
        int[] nums = new int[] {12, 18, 7, 34, 30, 28, 90, 88};
        System.out.println(lis.findLISLength(nums));
    }

    private int findLISLength(int[] nums) {

        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxNum = 1;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(dp));
        return maxNum;
    }

    private int findLDSLength(int[] nums) {

        int[] dp = new int[nums.length];
        dp[nums.length - 1] = 1;
        int maxNum = 1;
        for (int i = nums.length - 2; i >= 0 ; i--) {
            dp[i] = 1;
            for (int j = nums.length - 1; j >= i; j--) {
                if (nums[i] > nums[j] && dp[i] <= dp[j]) {
                    dp[i] = dp[j] + 1;
                }
            }
        }
        System.out.println(Arrays.toString(nums));
        System.out.println(Arrays.toString(dp));
        return maxNum;
    }
}
