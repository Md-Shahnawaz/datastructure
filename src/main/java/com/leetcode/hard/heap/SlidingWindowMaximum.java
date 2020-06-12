package com.leetcode.hard.heap;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class SlidingWindowMaximum {

    public static void main(String[] args) {

        System.out.println(Arrays.toString(maxSlidingWindow(new int[] {1, -1, 3, -3, 5, 3, 6, 7}, 3)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[] {1}, 1)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[] {9, 11}, 2)));
        System.out.println(Arrays.toString(maxSlidingWindow(new int[] {
            -95, 92, -85, 59, -59, -14, 88, -39, 2, 92, 94, 79, 78, -58, 37, 48, 63, -91, 91, 74, -28, 39, 90, -9, -72,
            -88, -72, 93, 38, 14, -83, -2, 21, 4, -75, -65, 3, 63, 100, 59, -48, 43, 35, -49, 48, -36, -64, -13, -7,
            -29, 87, 34, 56, -39, -5, -27, -28, 10, -57, 100, -43, -98, 19, -59, 78, -28, -91, 67, 41, -64, 76, 5, -58,
            -89, 83, 26, -7, -82, -32, -76, 86, 52, -6, 84, 20, 51, -86, 26, 46, 35, -23, 30, -51, 54, 19, 30, 27, 80,
            45, 22}, 10)));
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {

        int tmp = 0, j = 0, l = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        Map<Integer, Integer> set = new HashMap<>();
        int[] result = new int[nums.length > (k - 1) ? nums.length - (k - 1) : (k - 1)];
        for (int i = 0; i < nums.length; i++) {
            tmp++;
            pq.add(nums[i]);
            if (tmp == k) {
                while (set.containsKey(pq.peek())) {
                    Integer count = set.get(pq.peek());
                    if (count > 1) {
                        set.put(pq.peek(), count - 1);
                    } else {
                        set.remove(pq.peek());
                    }
                    pq.poll();
                }
                result[l++] = pq.peek();
                Integer count = set.get(nums[j]);
                if (count == null) {
                    set.put(nums[j], 1);
                } else {
                    set.put(nums[j], count + 1);
                }
                j++;
                tmp--;
            }
        }

        return result;
    }
}
