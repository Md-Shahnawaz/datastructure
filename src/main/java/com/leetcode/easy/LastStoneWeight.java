package com.leetcode.easy;


import java.util.Arrays;

public class LastStoneWeight {

    public static void main(String[] args) {
        System.out.println(lastStoneWeight(new int[]{7,6,7,6,9}));
        System.out.println(lastStoneWeight(new int[]{2,7,4,1,8,1}));
    }

    public static int lastStoneWeight(int[] stones) {

        Arrays.sort(stones);

        int prev = stones[stones.length - 1];
        int i = stones.length - 1;

        while (i > 0) {

            i--;
            int cur = stones[i];
            int diff = Math.abs(prev - cur);

            if (diff != 0) {

                int j = i;
                while (j - 1 >= 0 && diff < stones[j - 1]) {

                    stones[j] = stones[j - 1];
                    j--;
                }
                stones[j] = diff;
            } else {

                stones[i] = 0;
                i--;
            }

            if (i < 0) {
                break;
            }

            prev = stones[i];
        }
        return stones[0] == 0 ? 0 : stones[0];
    }
}
