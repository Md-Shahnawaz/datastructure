package com.leetcode.medium.hashmap;

import java.util.HashMap;
import java.util.Map;

public class ContiguousArray {

    public static void main(String[] args) {
        System.out.println(findMaxLength(new int[]{0, 0, 1, 0, 1, 1, 1}));
        System.out.println(findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 1, 1}));
        System.out.println(findMaxLength(new int[]{0, 0, 1, 0, 0, 0, 0, 1, 1}));
        System.out.println(findMaxLength(new int[]{0, 1, 1, 0, 1, 1, 1, 0}));
        System.out.println(findMaxLength(new int[]{1, 0, 0, 1, 1, 1, 1, 0}));
    }

    public static int findMaxLength(int[] nums) {

        Map<Integer, Integer> counter = new HashMap<>();

        int maxSum = 0, sum = 0;

        counter.put(0, -1);

        for (int i = 0; i < nums.length; i++) {

            sum += nums[i] == 0 ? -1 : 1;

            if(counter.containsKey(sum)) {

                maxSum = Math.max(maxSum, (i - counter.get(sum)));

            } else {

                counter.put(sum, i);
            }
        }
        return maxSum;
    }
}
