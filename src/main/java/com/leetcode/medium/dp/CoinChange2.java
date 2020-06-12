package com.leetcode.medium.dp;

import java.util.Arrays;

public class CoinChange2 {

    public static void main(String[] args) {
//        System.out.println(change(3, new int[]{1, 4}));
//        System.out.println(isPowerOfTwo(16));
//        System.out.println(isSubsequence("abc", "ahbgdc"));
        int[] colour = new int[]{2,0,2,1,1,0};
        sortColors(colour);
        System.out.println(Arrays.toString(colour));
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j <= amount; j++) {
                dp[j] = dp[j] + dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static boolean isPowerOfTwo(int n) {
        if (n == 1 || n == 2) return true;
        if (n == 0 || n % 2 != 0) return false;
        long cur = 2, prev = cur;
        while (cur < n) {
            prev = cur;
            cur = cur * cur;
        }
        if (cur == n) return true;
        cur = 2;
        while (cur * prev < n) {
            cur = cur * 2;
        }
        return prev * cur == n;
    }

    public static boolean isSubsequence(String s, String t) {

        int i = 0;
        int j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j)) {
                i++;
            }
            j++;
        }
        return i == s.length();
    }

    public static void sortColors(int[] nums) {

        int n = nums.length;
        int[] count = new int[3];
        for(int i = 0; i < nums.length; i ++){
            count[nums[i]]++;
        }
        int i = 0, j = 0;
        while (n > 0) {
            int c = count[i];
            while(c > 0) {
                nums[j++] = i;
                c--;
                n--;
            }
            i++;
        }
    }
}
