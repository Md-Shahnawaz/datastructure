package com.leetcode.medium.dp;

public class LongestCommonSubsequence {

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abc", "def"));
    }
    public static int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        for (int i = 1; i <= text1.length(); i++) {
            char ci = text1.charAt(i - 1);
            for (int j = 1; j <= text2.length(); j++) {
                char cj = text2.charAt(j - 1);
                if(ci == cj){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else{
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
            }
        }
        return dp[dp.length - 1][dp[0].length - 1];
    }
}
