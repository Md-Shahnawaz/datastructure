package com.leetcode.medium.array;

import java.util.Arrays;

public class JumpGame {

    public static void main(String[] args) {
//        System.out.println(canJump(new int[] {2,3,1,1,4}));
//        System.out.println(canJump(new int[] {3,2,1,0,4}));
//        System.out.println(canJump(new int[] {2,0}));
//        System.out.println(canJump(new int[] {0,1}));
//        System.out.println(canJump(new int[] {1,2,3}));
        System.out.println(canJump(new int[] {5,6,4,4,6,9,4,4,7,4,4,8,2,6,8,1,5,9,6,5,2,7,9,7,9,6,9,4,1,6,8,8,4,4,2,0,3,8,5}));
        System.out.println(canJump(new int[] {6,2,6,1,7,9,3,5,3,7,2,8,9,4,7,7,2,2,8,4,6,6,1,3}));
        System.out.println(canJump(new int[] {2,3,5,9,0,9,7,2,7,9,1,7,4,6,2,1,0,0,1,4,9,0,6,3}));
//        System.out.println(canJump(new int[] {2,5,0,0}));
//        System.out.println(canJump(new int[] {2,0,0}));
//        System.out.println(canJump(new int[] {1,2,0,1}));
//        System.out.println(canJump(new int[] {3,2,1,0,4}));
//        System.out.println(canJump(new int[] {1, 1, 2, 2, 0, 1}));
//        System.out.println(canJump(new int[] {5,9,3,2,1,0,2,3,3,1,0,0}));
    }

    public static int canJump(int[] nums) {

        int N = nums.length;
        int[] DP = new int[N];

        int i, j;

        Arrays.fill(DP, 2*N);
        DP[0] = 0;
        int span = 1;

        for(i = 0; i < N; i++){
            // compute the jump count for farthest possible positions
            // hence using span
            // observe that each DP value will be computed atmost 2 times (in bad case) in this loop !!
            for(j = span - i; j <= nums[i] && (i + j) < N; j++){
                DP[i + j] = Math.min(DP[i + j], 1 + DP[i]);
                span = Math.max(span, i + j + 1);
            }
        }

        return DP[N - 1];
    }

    public static boolean canJump2(int[] nums) {

        int maxjump = nums[0];
        for (int i = 0; i < nums.length - 1; i++) {
            //Check if current MaxJump can reach end of the array
            if (maxjump >= nums.length - i || nums[i] >= nums.length - 1) return true;

            //check if we encounter 0 and maxjump less than 1
            if (nums[i] == 0 && maxjump < 1) return false;

            // compare current maxjump with next element as mark higher number as maxjump
            if (maxjump - 1 >= nums[i + 1]) {
                maxjump = maxjump - 1;
            } else {
                maxjump = nums[i + 1];
            }
        }

        return true;
    }
}
