package com.leetcode.medium.dp;

public class UncrossedLines {

    public static void main(String[] args) {
        System.out.println(maxUncrossedLines(new int[]{2,5,1,2,5}, new int[]{10,5,2,1,5,2}));
        System.out.println(maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{10,5,2,1,5,2}));
        System.out.println(maxUncrossedLines(new int[]{1,3,7,1,7,5}, new int[]{1,9,2,5,1}));
    }
    public static int maxUncrossedLines(int[] A, int[] B) {
        int[][] dp = new int[2][B.length + 1];
        for (int i = 0; i < A.length; i++) {
            int k = i % 2;
            int l = (i + 1) % 2;
            for (int j = 1; j <= B.length; j++) {
                if(A[i] == B[j - 1]){
                    dp[k][j] = dp[l][j - 1] + 1;
                } else {
                    dp[k][j] = Math.max(dp[l][j], dp[k][j - 1]);
                }
            }
        }
        return Math.max(dp[0][B.length], dp[1][B.length]);
    }
}
