package com.leetcode.medium.hashmap;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(threeSum(new int[]{-1, 0, 1, 0}));
        System.out.println(threeSum(new int[]{-2, 0, 0, 2, 2}));
        System.out.println(threeSum(new int[]{3, 0, -2, -1, 1, 2}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        if(nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            if(i > 0 && nums[i] == nums[i - 1]) continue;
            int n1 = nums[i];
            int left = i + 1, right = nums.length - 1;
            while (left < right) {
                int n2 = nums[left];
                int n3 = nums[right];
                int sum = n2 + n3 + n1;
                if(sum == 0) {
                    List<Integer> intermediate = new ArrayList<>(3);
                    while(left < right && nums[left] == nums[left + 1]) ++left;
                    while(right > left && nums[right] == nums[right - 1]) --right;
                    intermediate.add(n1);
                    intermediate.add(n2);
                    intermediate.add(n3);
                    result.add(intermediate);
                    ++left;
                    --right;
                } else if (sum > 0) {
                    --right;
                } else {
                    ++left;
                }
            }
        }
        return result;
    }

    //Set<List<Integer>> result = new HashSet<>();
    //        Arrays.sort(nums);
    //        for (int i = 0; i < nums.length; i++) {
    //            int left = i + 1, right = nums.length - 1;
    //            int current = nums[i];
    //            while(left < right){
    //                int sum = current + nums[left] + nums[right];
    //                if(sum == 0){
    //                    List<Integer> intermediateList = new ArrayList<>();
    //                    intermediateList.add(current);
    //                    intermediateList.add(nums[left]);
    //                    intermediateList.add(nums[right]);
    //                    result.add(intermediateList);
    //                }
    //                if(sum < 0){
    //                    left ++;
    //                } else {
    //                    right --;
    //                }
    //            }
    //        }
    //
    //        return new ArrayList(result);
}
