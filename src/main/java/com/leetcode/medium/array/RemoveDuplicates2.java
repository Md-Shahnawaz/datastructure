package com.leetcode.medium.array;

import java.util.Arrays;

public class RemoveDuplicates2 {

    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,1,1,1,2,2,2,2,2,2,2,3,3,3,3};
        removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] nums) {

        int count = 1, j = 0;
        for(int i = 1 ; i < nums.length; i++) {

            if(nums[j] != nums[i] || count < 2) {
                System.out.println(count);
                if(nums[j] != nums[i]) count = 0;
                nums[++j] = nums[i];
            }

            count++;
        }
        return j;
    }
}
