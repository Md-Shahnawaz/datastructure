package com.leetcode.medium.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
        System.out.println(threeSum(new int[]{0, 0, 0, 0}));
        System.out.println(threeSum(new int[]{-1, 0, 1, 0}));
        System.out.println(threeSum(new int[]{-2, 0, 0, 2, 2}));
        System.out.println(threeSum(new int[]{3, 0, -2, -1, 1, 2}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {

        Map<Integer, Integer> countGroup = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            countGroup.putIfAbsent(nums[i], 0);
            countGroup.computeIfPresent(nums[i], (k, v) -> v + 1);
        }

        Set<List<Integer>> resultantList = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {

            int v1 = nums[i];
            if(countGroup.get(v1) <= 0) continue;
            countGroup.computeIfPresent(v1, (k, v) -> v - 1);

            for (int j = i + 1; j < nums.length; j++) {

                int v2 = nums[j];
                if(countGroup.get(v2) <= 0) continue;
                countGroup.computeIfPresent(v2, (k, v) -> v - 1);

                int key = -(v1 + v2);
                if(countGroup.containsKey(key) && countGroup.get(key) > 0){

                    countGroup.computeIfPresent(key, (k, v) -> v - 1);

                    List<Integer> intermediateList = new ArrayList<>();
                    intermediateList.add(v1);
                    intermediateList.add(v2);
                    intermediateList.add(key);
                    resultantList.add(intermediateList);

                } else {
                    countGroup.computeIfPresent(v2, (k, v) -> v + 1);
                }
            }

        }
        return new ArrayList<>(resultantList);
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
