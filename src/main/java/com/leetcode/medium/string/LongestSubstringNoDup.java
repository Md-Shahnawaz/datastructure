package com.leetcode.medium.string;

import java.util.HashSet;
import java.util.Set;

public class LongestSubstringNoDup {

    public static void main(String[] args) {
        System.out.println(new LongestSubstringNoDup().lengthOfLongestSubstring("dvdf"));
        System.out.println(new LongestSubstringNoDup().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new LongestSubstringNoDup().lengthOfLongestSubstring("abcabcbb"));
        System.out.println(new LongestSubstringNoDup().lengthOfLongestSubstring("pwwkew"));
        System.out.println(new LongestSubstringNoDup().lengthOfLongestSubstring(" "));
        System.out.println(new LongestSubstringNoDup().lengthOfLongestSubstring("cdd"));
    }

    public int lengthOfLongestSubstring(String s) {

        int max = 0, j = 0;

        Set<Character> uniq = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {

            char c = s.charAt(i);
            while(uniq.contains(c)) {
                uniq.remove(s.charAt(j));
                j++;
            }
            uniq.add(c);
            max = Math.max(uniq.size(), max);
        }
        return max;
    }
}
