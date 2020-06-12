package com.leetcode.medium.string;

public class PermutationString {

    public static void main(String[] args) {

    }

    public boolean checkInclusion(String s1, String s2) {

        int[] chars = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            chars[((int)s1.charAt(i) - 97)] += 1;
        }
        return false;
    }

    private void recurse(int index, int[] freq, String s2) {
        int ch = s2.charAt(index) - 97;
        if(freq[ch] < 1){

        }

    }
}
