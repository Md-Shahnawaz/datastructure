package com.leetcode.easy.binarysearch;

public class PerfectSquare {

    public static void main(String[] args) {
        System.out.println(isPerfectSquare(808201));
    }

    public static boolean isPerfectSquare(int num) {

        int l = 0, r = num, mid = 0, max = 46340;
        while(l <= r) {
            mid = (r - l)/2 + l;
            if(mid > max) {
                r = mid - 1;
                continue;
            }
            long sq = mid * mid;

            if(sq == num) return true;

            if(sq > num) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return false;
    }
}
