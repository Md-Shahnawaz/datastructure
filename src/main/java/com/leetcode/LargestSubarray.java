package com.leetcode;

public class LargestSubarray {
    public static void main(String[] args) {
        System.out.println(maxSubArray(new int[]{-2}));
    }

    public static int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE, tempMax = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if(tempMax < 0){
                tempMax = 0;
            }
            tempMax += nums[i];
            max = Math.max(max, tempMax);
        }
        return max;
    }
}
