package com.gfg;

import java.util.Arrays;

    public class PythagoreanTriplet {

    public static void main(String[] args) {

        System.out.println(containsTriplet(new int[]{3, 5, 12, 5, 13}));
        System.out.println(containsTriplet(new int[]{3, 1, 4, 6, 5}));
        System.out.println(containsTriplet(new int[]{10, 4, 6, 12, 5}));
    }

    private static boolean containsTriplet(int[] arr) {
        Arrays.sort(arr);
        for(int i = 0; i < arr.length; i++) {
            arr[i] *= arr[i];
        }
        for(int i = arr.length - 1; i >= 0; i--) {
            int itm = arr[i], l = 0, r = i - 1;
            while(l < r) {
                int sum = arr[l] + arr[r];
                if(sum == itm) {
                    return true;
                } else if(sum < itm) {
                    l++;
                } else {
                    r--;
                }
            }
        }
        return false;
    }
}
