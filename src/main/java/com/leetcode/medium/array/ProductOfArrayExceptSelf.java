package com.leetcode.medium.array;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1,2,3,4})));
    }

    public static int[] productExceptSelf(int[] nums) {

        int[] result = new int[nums.length];

        result[0] = 1;
        int nextSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result[i] = nextSum;
            nextSum *= nums[i];
        }

        int prevSum = nums[nums.length - 1];
        for (int i = nums.length - 2; i >= 0; i--) {
            result[i] = result[i] * prevSum;
            prevSum *= nums[i];
        }

        return result;
    }
}
