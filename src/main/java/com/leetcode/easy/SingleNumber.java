package com.leetcode.easy;


public class SingleNumber {
    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{1,3,1,2,3}));
    }

    public static int singleNumber(int[] nums) {
        int num = 0, n = nums.length;
        for (int i = 0; i < n; i++) {
            int temp = Math.abs(nums[i]);
            if(nums[temp % n] > 0) {
                num += temp;
                nums[temp % n] = -nums[temp % n];
            } else {
                num -= temp;
            }
        }
        return num;
    }
}
