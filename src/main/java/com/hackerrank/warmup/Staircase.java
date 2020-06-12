package com.hackerrank.warmup;

import java.util.Arrays;

public class Staircase {
    public static void main(String[] args) {
        miniMaxSum(new int[]{1, 2, 3, 4, 5});
    }
    static void miniMaxSum(int[] arr) {

        long temp = 0;
        for (int i = 1; i < arr.length - 1; i++) {
            temp = temp + arr[i];
        }
        System.out.println(Math.min((arr[0] + temp) , (arr[arr.length - 1] + temp))+ " " + Math.max((arr[0] + temp) , (arr[arr.length - 1] + temp)));

    }
}
