package com.leetcode.medium.slidingwindow;

public class MinimumSibArraySum {

    public static void main(String[] args) {

        System.out.println(minSubArrayLen(7, new int[]{2,3,1,2,4,3}));
        System.out.println(minSubArrayLen(11, new int[]{1,2,3,4,5}));
    }

    public static int minSubArrayLen(int s, int[] nums) {

        int sum = 0, j = 0, min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            while(sum >= s){
                min = Math.min(min, i - j);
                sum -= nums[j];
                j++;
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min + 1;
    }
}
