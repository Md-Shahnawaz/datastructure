package com.leetcode.medium.array;

public class MaxSubarraySumCircular {


    public static void main(String[] args) {
//        System.out.println(maxSubarraySumCircular(new int[] {1, -2, 3, -2}));
//        System.out.println(maxSubarraySumCircular(new int[] {5, -3, 5}));
//        System.out.println(maxSubarraySumCircular(new int[] {3, -1, 2, -1}));
//        System.out.println(maxSubarraySumCircular(new int[] {3, -2, 2, -3}));
//        System.out.println(maxSubarraySumCircular(new int[] {-2, -3, -1}));
//        System.out.println(maxSubarraySumCircular(new int[] {-2}));
//        System.out.println(maxSubarraySumCircular(new int[]{3,1,3,2,6}));
//        System.out.println(maxSubarraySumCircular(new int[]{-2,4,-5,4,-5,9,4}));

    }

    public static int maxSubarraySumCircular(int[] A) {
        int result = Integer.MIN_VALUE, temp = 0, prefixSum = 0;
        for (int i = 0; i < A.length; i++) {
            temp += A[i];
            prefixSum += A[i];
            result = Math.max(result , temp);
            if(temp < 0) temp = 0;
        }
        temp = 0;
        for (int i = 1; i < A.length - 1; i++) {
            temp += A[i];
            if(temp > 0) {
                temp = 0;
                continue;
            }
            result = Math.max(result, (prefixSum - temp));
        }
        return result;
    }

    public static int maxSubarraySumCircular2(int[] A) {
        int result = Integer.MIN_VALUE;
        for (int i = 0; i < A.length; i++) {
            int max = Integer.MIN_VALUE, temp = 0;
            for (int j = i + 1; j < A.length * 2; j++) {
                int mod = j % A.length;
                temp += A[mod];
                max = Math.max(max, temp);
                if(temp < 0){
                    temp = 0;
                }
                if(mod == i) {
                    break;
                }
            }
            result = Math.max(max, Math.max(A[i], result));
        }
        return result;
    }
}
