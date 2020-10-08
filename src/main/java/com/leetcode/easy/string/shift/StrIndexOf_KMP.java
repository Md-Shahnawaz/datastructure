package com.leetcode.easy.string.shift;

import java.util.Arrays;

public class StrIndexOf_KMP {

    public static void main(String[] args) {
//        System.out.println(new StrIndexOf().strStr("hello", "lo"));
        System.out.println(new StrIndexOf_KMP().strStr("aabaaabaaac", "aabaaac"));
        System.out.println(new StrIndexOf_KMP().strStr("ababcaababcaabc", "ababcaabc"));
    }

    public int strStr(String haystack, String needle) {

        int[] dp = new int[needle.length()];
        for (int i = 1, j = 0; i < needle.length(); i++) {
            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
                j = dp[j - 1];
            }
            if (needle.charAt(i) == needle.charAt(j)) {
                dp[i] = j + 1;
                j++;
            }
        }

        int j = 0, i = 0;
        for (; i < haystack.length(); i++) {

            if (j == needle.length()) return i - j;

            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = dp[j - 1];
            }

            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
        }
        return j == needle.length() ? i - j : -1;
    }
}
