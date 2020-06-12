package com.leetcode.hard.array;

public class Stickers {

    public static void main(String[] args) {
        System.out.println(minStickers(new String[]{"these","guess","about","garden","him"}, "atomher"));
    }

    public static int minStickers(String[] stickers, String target) {

        int[] dp = new int[26];
        int count = target.length();
        for (int i = 0; i < target.length(); i++) {
            int ch = target.charAt(i);
            dp[ch - 97] += 1;
        }
        int result = 0;
        for (int i = 0; i < stickers.length; i++) {
            int tempMax = 0;
            for (int j = 0; j < stickers[i].length(); j++) {
                int ch = stickers[i].charAt(j);
                tempMax = Math.max(tempMax, dp[ch - 97]);
                if(dp[ch - 97] > 0){
                    count -= dp[ch - 97];
                    dp[ch - 97] = 0;
                }
            }
            result += tempMax;
            if(count == 0){
                return result;
            }
        }
        return count == 0 ? result : -1;
    }
}
