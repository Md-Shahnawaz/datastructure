package com.leetcode.medium.set;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;

public class FirstUnique {

    private Set<Integer> map;
    private Set<Integer> set;

    public FirstUnique(int[] nums) {
        map = new HashSet<>();
        set = new LinkedHashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.contains(nums[i])) {
                set.remove(nums[i]);
            } else {
                map.add(nums[i]);
                set.add(nums[i]);
            }
        }
    }

    public int showFirstUnique() {
        if (set.size() > 0) {
            return set.stream().limit(1).reduce(0, (a, b) -> a + b);
        } else {
            return -1;
        }
    }

    public void add(int value) {
        if (map.contains(value)) {
            set.remove(value);
        } else {
            map.add(value);
            set.add(value);
        }
    }
}
