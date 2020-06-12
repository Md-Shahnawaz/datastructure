package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class CountingElement {
    public static void main(String[] args) {
        System.out.println(countElements(new int[]{1,3,2,3,5,0}));
    }

    public static int countElements(int[] arr) {
        int count = 0;
        Set<Integer> mapping = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            mapping.add(arr[i]);
        }
        for (int i = 0; i < arr.length; i++) {
            if(mapping.contains(arr[i] + 1)){
                count ++;
            }
        }
        return count;
    }
}
