package com.leetcode.medium;

public class SearchRotatedArray {

    public static void main(String[] args) {
        System.out.println(new SearchRotatedArray().search(new int[] {2,3,4,5,6,7,8,9,1}, 9));
    }

    public int search(int[] nums, int target) {
        return search(nums, target, 0, nums.length - 1);
    }

    private int search(int[] nums, int target, int i , int j){

        if(i > j) {
            return -1;
        }
        int mid = (j - i)/2 + i;

        if(nums[mid] == target) {
            return mid;
        }
        if(mid + 1 < nums.length && nums[mid + 1] == target){
            return mid + 1;
        }
        if(mid - 1 >= 0 && nums[mid - 1] == target){
            return mid - 1;
        }

        int index;
        if(nums[mid] > target) {
            if(nums[i] <= target) {

                index = search(nums, target, i, mid - 1);
            }  else if(nums[mid] < nums[i]){
                index = search(nums, target, i, mid - 1);
            } else {
                index = search(nums, target, mid + 1, j);
            }
        } else {
            if(target <= nums[j]) {
                index = search(nums, target, mid + 1, j);
            } else if(nums[mid] > nums[j]) {
                index = search(nums, target, mid + 1, j);
            } else {
                index = search(nums, target, i, mid - 1);
            }
        }
        return index;
    }
}
