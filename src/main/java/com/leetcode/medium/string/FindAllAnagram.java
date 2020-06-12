package com.leetcode.medium.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class FindAllAnagram {

    public static void main(String[] args) {
        System.out.println(findAnagrams("cbaebabacd", "abc"));
        System.out.println(findAnagrams("abab", "ab"));
        System.out.println(findAnagrams("ababababab", "aab"));
        System.out.println(findAnagrams("af", "be"));
    }

    public static List<Integer> findAnagrams(String s, String p) {

        List<Integer> result = new ArrayList<>();
        if(s.length() == 0 || s.length() < p.length()) {
            return result;
        }
        int[] chars = new int[26];
        HashSet<Integer> prefixLookUp = new HashSet<>();
        int pPrefixSum = 0, sPrefixSum = 0;
        for (int i = 0; i < p.length(); i++) {
            char ch = p.charAt(i);
            pPrefixSum += ch;
            chars[((int)ch - 97)] += 1;
        }
        int pLen = p.length() - 1;
        for (int i = 0; i < s.length(); i++) {
            sPrefixSum += s.charAt(i);
            if(sPrefixSum == pPrefixSum || prefixLookUp.contains(sPrefixSum - pPrefixSum)) {
                if(containsAllLetters(s,i - pLen, i, chars)) {
                    result.add((i - pLen));
                }
            }
            prefixLookUp.add(sPrefixSum);
        }
        return result;
    }

    private static boolean containsAllLetters(String s, int first, int second, int [] two){
        int[] arr = new int[26];
        for(int b = first; b <= second; b++){
            arr[s.charAt(b) - 97] += 1;
        }
        for (int i = 0; i < 26; i++) {
            if(arr[i] != two[i]) {
                return false;
            }
        }
        return true;
    }
}
