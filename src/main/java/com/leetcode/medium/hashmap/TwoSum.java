package com.leetcode.medium.hashmap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class TwoSum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Queue<Integer>> mapping = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Queue<Integer> count = mapping.get(nums[i]);
            if(count == null) {
                count = new LinkedList<>();
                mapping.put(nums[i], count);
            }
            count.offer(i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            Queue<Integer> que = mapping.get(num);
            Integer index = que.poll();
            int diff = target - num;
            if(que.isEmpty()) {
                mapping.remove(num);
            }
            if(mapping.containsKey(diff)) {
                return new int[] {index, mapping.get(diff).poll()};
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{3,2,4}, 6)));
    }
}
