package com.leetcode.medium.array;

public class ContainerWithMostWater {
    public static void main(String[] args) {
        System.out.println(maxArea(new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[] {1, 2, 1}));
    }

    public static int maxArea(int[] height) {
        int maxArea = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int diff = r - l;
            if(height[l] < height[r]) {
                maxArea = Math.max(maxArea, height[l] * diff);
                l++;
            } else {
                maxArea = Math.max(maxArea, height[r] * diff);
                r--;
            }
        }
        return maxArea;
    }
}
