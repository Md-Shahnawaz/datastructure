package com.leetcode.medium.array;

import java.util.Arrays;

public class FindDuplicateNumber {
    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{1,3,4,2,1}));
//        System.out.println(findDuplicate(new int[]{1,3,4,2,2}));
//        System.out.println(findDuplicate(new int[]{4,3,1,4,2}));
//        System.out.println(findDuplicate(new int[]{35,14,13,56,24,35,67,34}));
    }
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        slow = nums[slow];
        fast = nums[nums[slow]];
        while(slow != fast){
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        int i = 0;
        int j = slow;
        while(i != j){
            i = nums[i];
            j = nums[j];
        }
        return i;
//        if(nums == null || nums.length == 0) return 0;
//        if(nums.length < 3) return nums[0];
//        int i = 0, j = 1, n = nums.length;
//        while(nums[i] != nums[j]) {
//            i++;
//            j += 2;
//            if(i == j) j += 1;
//            i %= n;
//            j %= n;
//        }
//        return nums[i];
    }
}
