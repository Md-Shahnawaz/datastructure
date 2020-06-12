package com.leetcode.medium.dp;

public class MaxProduct {

    public static void main(String[] args) {

//        System.out.println(maxProduct(new int[]{0, 2}));
//        System.out.println(maxProduct(new int[]{-2, 0, -1}));
//        System.out.println(maxProduct(new int[]{3, -1, 4}));
        System.out.println(maxProduct(new int[]{2,-5,-2,-4,3})); //24
        System.out.println(maxProduct(new int[]{-2,3,-4})); //24
        System.out.println(maxProduct(new int[]{1,2,-1,-2,2,1,-2,1,4,-5,4})); //24
    }

    public static int maxProduct(int[] nums) {

        if(nums.length == 1) return nums[0];
        if(nums.length == 0) return 0;

        int prodLeft = 1;
        int prodRight = 1;
        int max = 0;

        for (int i = 0; i < nums.length; i++) {

            prodLeft *= nums[i];
            prodRight *= nums[nums.length - 1 - i];
            max = Math.max(Math.max(max, prodLeft), prodRight);
            prodLeft = prodLeft == 0 ? 1 : prodLeft;
            prodRight = prodRight == 0 ? 1 : prodRight;

        }
        return max;
    }
}
