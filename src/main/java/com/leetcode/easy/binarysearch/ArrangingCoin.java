package com.leetcode.easy.binarysearch;

import java.util.Arrays;

public class ArrangingCoin {

    public static void main(String[] args) {
//        System.out.println(arrangeCoins(6));
//        System.out.println(arrangeCoins(8));
//        System.out.println(arrangeCoins(0));
//        System.out.println(arrangeCoins(1));
//        System.out.println(arrangeCoins(10));
        System.out.println(arrangeCoins(1804289383));
    }

    public static int arrangeCoins(int n) {
        int l = 0, r = n;
        double temp = 0;
        while(l < r) {

            int mid = (r - l)/2 + l;
            temp = (mid * (mid + 1))/2;
            if(n > temp) {
                l = mid + 1;
            } else {
                r = mid;
            }

        }
        return (l * (l + 1))/2  > n ? l - 1: l;
    }
}
