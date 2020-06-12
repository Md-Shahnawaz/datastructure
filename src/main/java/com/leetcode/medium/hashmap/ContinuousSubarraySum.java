package com.leetcode.medium.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ContinuousSubarraySum {

    public static void main(String[] args) {

//        System.out.println(checkSubarraySum(new int[]{23, 2, 4, 6, 8},6));
        System.out.println(checkSubarraySum(new int[]{23, 2, 6, 7, 4},6));
    }

    public static boolean checkSubarraySum(int[] nums, int k) {

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            Integer pre = map.get(sum);
            if (pre != null) {
                if (i - pre > 1) {
                    return true;
                }
            } else {
                map.put(sum, i);
            }
        }
        return false;
    }
}
