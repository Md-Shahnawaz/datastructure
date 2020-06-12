package com.leetcode.easy;

import java.util.Arrays;

public class MoveZeros {
    public static void main(String[] args) {
        moveZeroes(new int[]{0,1,0,3,12});
    }

    public static void moveZeroes(int[] nums) {

        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] != 0){
                nums[j] = nums[i];
                j ++;
            }
        }
        while(j < nums.length){
            nums[j] = 0;
            j ++;
        }
        System.out.println(Arrays.toString(nums));
    }
}
