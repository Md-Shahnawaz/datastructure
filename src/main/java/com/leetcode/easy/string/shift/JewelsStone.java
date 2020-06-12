package com.leetcode.easy.string.shift;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class JewelsStone {

    public static void main(String[] args) {
//        System.out.println(numJewelsInStones("z", "ZZ"));
        System.out.println(canConstruct("dehifby", "hhjdgjbhahaagihhhhhajjibjffhijehda"));
    }
    public static int numJewelsInStones(String J, String S) {

        Set<Character> jwls = new HashSet<>();
        for (int i = 0; i < J.length(); i++) {
            jwls.add(J.charAt(i));
        }

        int result = 0;
        for (int i = 0; i < S.length(); i++) {
            if(jwls.contains(S.charAt(i))) result += 1;
        }
        return result;
    }

    public static boolean canConstruct(String ransomNote, String magazine) {

        int[] alphabets = new int[26];

        for (int i = 0; i < magazine.length(); i++) {
            char ch = magazine.charAt(i);
            alphabets[(int) ch - 97] = alphabets[(int) ch - 97] + 1;
        }

        for (int i = 0; i < ransomNote.length(); i++) {
            char ch = ransomNote.charAt(i);
            alphabets[(int) ch - 97] = alphabets[(int) ch - 97] - 1;
            if(alphabets[(int) ch - 97] < 0) {
                return false;
            }
        }
        return true;
    }
}
