package com.leetcode.easy.binarysearch;

public class Sqrt {

    public static void main(String[] args) {
        System.out.println(new Sqrt().mySqrt(325));
        System.out.println(new Sqrt().mySqrt(8));
        System.out.println(new Sqrt().mySqrt(450));
    }
    public int mySqrt(int x) {
        double l = 0, r = x, prev = 0;
        while (l < r) {

            double mid = (r - l) / 2 + l;
            if (mid * mid == x) {
                return (int)mid;
            }
            if(prev == mid) {
                return (int)mid;
            }
            prev = mid;
            if (mid * mid < x) {
                l = mid;
            } else {
                r = mid;
            }
        }
        return (int)l;
    }
}
