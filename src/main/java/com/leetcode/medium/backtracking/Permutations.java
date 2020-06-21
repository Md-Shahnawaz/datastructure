package com.leetcode.medium.backtracking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {

    public static void main(String[] args) {
        System.out.println(permute(new int[]{1,2,1}));
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList();
        if(nums == null || nums.length == 0) {
            result.add(Collections.emptyList());
            return result;
        }
        permutation(result, nums, nums.length, new ArrayList<>(), new boolean[nums.length]);
        return result;
    }

    private static void permutation(List<List<Integer>> result,int[] nums, int size, List<Integer> interim, boolean[] taken) {

        if(interim.size() == size) {
            result.add(new ArrayList<>(interim));
            return;
        }
        Set<Integer> set  = new HashSet<>();
        for (int i = 0; i < size; i++) {
            if(!taken[i] && set.add(nums[i])) {
                taken[i] = true;
                interim.add(nums[i]);
                permutation(result, nums, size, interim, taken);
                interim.remove(interim.size() - 1);
                taken[i] = false;
            }
        }
    }

}
