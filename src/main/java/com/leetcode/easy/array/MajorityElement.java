package com.leetcode.easy.array;

public class MajorityElement {

    public static void main(String[] args) {
        System.out.println(majorityElement(new int[] {2, 2, 3, 3, 1, 1, 1, 3, 3, 2, 2, 3}));
    }

    public static int majorityElement(int[] nums) {
        int leader = nums[0], leader_count = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == leader) {
                leader_count++;
            } else {
                leader_count--;
                if (leader_count == 0) {
                    leader = nums[i + 1 < nums.length ? i + 1 : i];
                    leader_count = 1;
                    i++;
                }
            }
        }
        return leader;
    }
}
