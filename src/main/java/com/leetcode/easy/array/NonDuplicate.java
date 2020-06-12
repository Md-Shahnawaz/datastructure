package com.leetcode.easy.array;

public class NonDuplicate {

    public static void main(String[] args) {

        System.out.println(singleNonDuplicate(new int[]{1,1,2,2,4,4,4,8,8,9}));
        System.out.println(singleNonDuplicate(new int[]{1,1,2}));
        System.out.println(singleNonDuplicate(new int[]{1,1,2,3,3}));
    }

    public static int singleNonDuplicate(int[] nums) {
        int prev = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(prev == nums[i]){
                continue;
            } else {
                if(i == nums.length - 1) return nums[i];
                if(i - 2 >= 0 && prev != nums[i - 2]){
                    return prev;
                }
                prev = nums[i];
            }
        }
        return nums[0];
    }
}
