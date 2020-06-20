package com.leetcode.medium.dp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum {

    public static void main(String[] args) {
        System.out.println(combinationSum(new int[]{2,3,6,7}, 7));
        System.out.println(combinationSum(new int[]{2,3,5}, 8));
        System.out.println(combinationSum(new int[]{1,2}, 4));
    }
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {

        List<List<Integer>> result = new LinkedList<>();
        if(target == 0 || candidates == null || candidates.length == 0) {
            result.add(Collections.emptyList());
            return result;
        }
        backTrack(result, candidates, 0, target, new ArrayList<>());
        return result;
    }

    private static void backTrack(List<List<Integer>> result, int[] candidates, int i, int target, List<Integer> interim) {

        if(target == 0) {
            result.add(new ArrayList<>(interim));
            return;
        }

        if(i >= candidates.length) return;

        if(target >= candidates[i]) {
            interim.add(candidates[i]);
            backTrack(result, candidates, i, target - candidates[i],  interim);
            interim.remove(interim.size() - 1);
        }
        backTrack(result, candidates, i + 1, target,  interim);
    }

}
