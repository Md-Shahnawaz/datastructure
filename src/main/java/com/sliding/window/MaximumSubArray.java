package com.sliding.window;

public class MaximumSubArray {

    public static void main(String[] args) {
        int[] input = {11, -8, 16, -7, 24, -2, 3};
        int k = 3;
        printMaxAvgSubarray(input, k);
    }

    private static void printMaxAvgSubarray(int[] input, int k) {

        int maxSubArr = Integer.MIN_VALUE;
        int tempSum = 0, end = 0;
        for (int i = 0; i < input.length; i++) {
            tempSum += input[i];
            if(i > k - 1){
                tempSum -= input[end];
                end++;
            }
            maxSubArr = Math.max(maxSubArr, tempSum);
        }

        System.out.println(maxSubArr);
    }
}
