package com.leetcode.medium;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class PermutationSequence {

    public static void main(String[] args) {
        System.out.println(getPermutation(4, 6));
    }

    public static String getPermutation(int n, int k) {

        int[] result = new int[n];
        List<Integer> factorial = new ArrayList<>();
        factorial.add(1);

        for(int i = 1; i <= n; i++) {
            factorial.add(factorial.get(i - 1) * i);
            result[i - 1] = i;
        }

        permutation(result, k, 0, factorial);

        StringBuilder sb = new StringBuilder();
        IntStream.of(result).forEach(sb::append);

        return sb.toString();
    }

    private static void permutation(int[] str, int k, int start, List<Integer> factorial) {

        for(int i = start; i < str.length && k > 0; i++) {

            int factor = factorial.get(str.length - (start + 1));

            if(factor < k) {
                k -= factor;
                swap(str, start, i + 1);
            } else {
                permutation(str, k, start + 1, factorial);
                break;
            }
        }
    }

    private static void swap(int[] str, int i, int j) {

        int temp = str[i];
        str[i] = str[j];
        str[j] = temp;
    }
}
