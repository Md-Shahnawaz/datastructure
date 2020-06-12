package com.leetcode.medium.dp;

public class KConcatenationMaximumSum {

    public static void main(String[] args) {

        System.out.println(kConcatenationMaxSum(new int[]{1, 2}, 5));
        System.out.println(kConcatenationMaxSum(new int[]{1,-2,1}, 5));
        System.out.println(kConcatenationMaxSum(new int[]{-1,-2}, 7));
        System.out.println(kConcatenationMaxSum(new int[]{-5,-2,0,0,3,9,-2,-5,4}, 5));

    }

    public static int kConcatenationMaxSum(int[] arr, int k) {

        int maxSum = 0;
        int temp = 0;
        int[] dp = new int[4];
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < arr.length; j++) {
                temp += arr[j];
                if(temp < 0){
                    temp = 0;
                }
                maxSum = Math.max(maxSum, temp);
            }
            dp[i] = maxSum;
        }
        return maxSum + ((dp[3] - dp[2]) * (k - 4));
    }
}
