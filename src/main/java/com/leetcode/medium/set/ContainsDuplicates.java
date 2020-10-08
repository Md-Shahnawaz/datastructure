package com.leetcode.medium.set;

import java.util.TreeMap;

public class ContainsDuplicates {

    public static void main(String[] args) {
//        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,2,3,1}, 3, 0));
//        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,0,1,1}, 1, 2));
        System.out.println(containsNearbyAlmostDuplicate(new int[]{1,5,9,1,5,9}, 2, 3));
//        System.out.println(containsNearbyAlmostDuplicate(new int[]{2147483647,-2147483647}, 1, 2147483647));

    }

    public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {

        TreeMap<Long, Integer> map = new TreeMap<>();
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(i - j > k) {
                if(contains(map, nums, j, t)) return true;
                j++;
            }
            long val = nums[i];
            map.put(val, map.getOrDefault(val, 0) + 1);
        }

        while(j < nums.length) {

            if(contains(map, nums, j, t)) return true;
            j++;
        }

        return false;
    }

    private static boolean contains(TreeMap<Long, Integer> map, int[] nums, int j, int t) {
        long val = nums[j];
        Integer count = map.get(val);
        Long diff;
        if(count != null && count > 1) {
            map.put(val, count - 1);
        } else {
            map.remove(val);
        }
        if((diff = map.floorKey(t + val)) != null && Math.abs(diff - nums[j]) <= t) return true;
        return false;
    }
}
