package com.leetcode.medium.array;

public class FirstMissingPositive {
    public static void main(String[] args) {
        System.out.println(firstMissingPositive(new int[]{3,1,4,2}));
        System.out.println(firstMissingPositive(new int[]{-1,4,2,1,9,10}));
        System.out.println(firstMissingPositive(new int[]{0,1,2}));
        System.out.println(firstMissingPositive(new int[]{2147483647,2147483646,2147483645,3,2,1,-1,0,-2147483648}));

    }

    public static int firstMissingPositive(int[] nums) {
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0) {
                nums[i] = n + 1;
            }
        }
        int index;
        for (int v : nums) {
            index = Math.abs(v) - 1;
            if (index < n && nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) return i + 1;
        }
        return n + 1;
    }
}
