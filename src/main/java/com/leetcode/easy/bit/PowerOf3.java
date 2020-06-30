package com.leetcode.easy.bit;

public class PowerOf3 {

    public static void main(String[] args) {
        System.out.println(isPowerOfThree(2147483647));
        System.out.println(isPowerOfThree(0));
        System.out.println(isPowerOfThree(243));
        System.out.println(isPowerOfThree(1));
        System.out.println(isPowerOfThree(9));
    }

    public static boolean isPowerOfThree(int n) {
        if((n & 1) == 1) {
            double j = 1;
            while(j < n) j *= 3;
            return j == n;
        }
        return false;
    }
}
