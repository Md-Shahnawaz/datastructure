package com.leetcode.medium.binarySearch;

import java.util.Arrays;

public class FirstAndLastPosition {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5,7,7,8,8,10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{0,0,1,2,2,2,5,5,5,6,6}, 5)));
    }

    public static int[] searchRange(int[] nums, int target) {

        int l = 0, r = nums.length - 1, mid  = 0, result[] = new int[]{-1, -1};
        while(l <= r) {

            mid = (l + r) / 2;
            if(nums[mid] == target) break;

            if(nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        if(l >= r) return result;
        int tmp = mid;
        l = 0; r = tmp;
        while(l < r) {

            mid = (l + r)/2;
            if(nums[mid] < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        result[0] = l;
        l = tmp; r = nums.length - 1;
        while(l < r) {

            mid = (l + r)/2;
            if(nums[mid] > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }

        result[1] = l;
        return result;
    }
}
