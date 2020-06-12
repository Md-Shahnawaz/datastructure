package com.leetcode.easy.string.shift;

public class UniqueChar {

    public static void main(String[] args) {
        System.out.println(firstUniqChar("loveleetcode"));
    }

    public static int firstUniqChar(String s) {

        int f = Integer.MAX_VALUE;
        for (int i = 'a'; i <= 'z'; i++) {
            int index  = s.indexOf(i);
            if(index != -1 && index == s.lastIndexOf(i)){
                f = Math.min(f, index);
            }
        }
        return f == Integer.MAX_VALUE ? -1 : f;
    }
}
