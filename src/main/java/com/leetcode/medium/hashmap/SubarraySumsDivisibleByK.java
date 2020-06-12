package com.leetcode.medium.hashmap;

public class SubarraySumsDivisibleByK {

    public static void main(String[] args) {
        System.out.println(subarraysDivByK(new int[]{-19, -82, -70, -46, -29, 7, 15, -72, -7, 100, 303},
            100));
    }

    public static int subarraysDivByK(int[] A, int K) {


        int result = 0;
        for (int i = 0; i < A.length; i++) {
            int sum = 0;
            for (int j = i; j < A.length; j++) {
                sum += A[j];
                if(sum == K){
                    result += 1;
                    System.out.println("i =" + i + " j =" + j);
                }
            }
        }
        return result;
    }
}
