package com.leetcode.medium.backtracking;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.IntStream;

public class PermutationSequence {

    public static void main(String[] args) {
        System.out.println(getPermutation(6, 314));
    }

    public static String getPermutation(int n, int k) {

        List<Integer> result = new ArrayList<>();
        List<Integer> factorial = new ArrayList<>();
        factorial.add(1);

        for(int i = 1; i <= n; i++) {
            factorial.add(factorial.get(i - 1) * i);
            result.add(i);
        }

//        permutation(result, k, 0, factorial);

        StringBuilder sb = new StringBuilder();
//        result.forEach(sb::append);

        int i = n - 1, factor = factorial.get(i);
        k--;
        while(result.size() > 1) {
            sb.append(result.remove(Math.floorDiv(k, factor)));
            if(k >= factor) {
                k -= Math.floorDiv(k, factor) * factor;
            } else {
                sb.append(result.remove(0));
            }
            factor = factorial.get(--i);
        }
        if(!result.isEmpty()) sb.append(result.get(0));
        IntStream.of(new int[]{}).collect(ArrayList::new, List::add, List::addAll);
        return sb.toString();
    }

//    private static void permutation(List<Integer> str, int k, int start, List<Integer> factorial) {
//
//        for(int i = start; i < str.size() && k > 0; i++) {
//
//            int factor = factorial.get(str.size() - (start + 1));
//
//            if(factor < k) {
//                k -= factor;
//                swap(str, start, i + 1);
//            } else {
//                permutation(str, k, start + 1, factorial);
//                break;
//            }
//        }
//    }
//
//    private static void swap(List<Integer> str, int i, int j) {
//
//        int temp = str.get(i);
//        str.set(i, str.get(j));
//        str.set(j, temp);
//    }
}
