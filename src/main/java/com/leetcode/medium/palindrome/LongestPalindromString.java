package com.leetcode.medium.palindrome;

public class LongestPalindromString {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("aa"));
    }
    public static String longestPalindrome(String s) {

        String result = s;
        int max = 0;
        int[][] dp = new int[s.length()][s.length()];
        for(int i = 0; i <  s.length(); i++){
            dp[i][i] = 1;
            result = s.substring(i, i + 1);
        }

        for(int i = s.length() - 2; i >= 0; i--){
            for(int j = s.length() - 1; j > i; j--){

                if(s.charAt(i) == s.charAt(j) && (dp[i + 1][j - 1] == 1 || (j - i) ==1)) {
                    if((j - i) > max){
                        max = j - i;
                        result = s.substring(i, j+1);
                    }
                    dp[i][j] = 1;
                }
            }
        }

        return result;

    }
}
