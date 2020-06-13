package com.leetcode.easy.binarysearch;

public class SearchInsertPosition {
    public static void main(String[] args) {

        System.out.println(searchInsert(new int[]{1,3,5,6}, 5));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 2));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 7));
        System.out.println(searchInsert(new int[]{1,3,5,6}, 0));
    }

    public static int searchInsert(int[] nums, int target) {
        if(nums.length == 0 || nums == null) return 0;
        int n = nums.length - 1;
        if(nums[n] < target) return n + 1;
        return search(nums, target, 0, n);
    }

    private static int search(int[] nums, int target, int left, int right) {
        if(right - left == 0){
           return left;
        }
        int mid = (right - left) / 2 + left;
        if(nums[mid] == target) {
            return mid;
        }
        if(nums[mid] < target) {
            return search(nums, target, mid + 1, right);
        } else {
            return search(nums, target, left, mid);
        }
    }
}
