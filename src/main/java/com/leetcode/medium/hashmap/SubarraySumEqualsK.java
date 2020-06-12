package com.leetcode.medium.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SubarraySumEqualsK {

    public static void main(String[] args) {
        System.out.println(subarraySum(new int[] {1,  5, -1, -2, -6,  1,  2,  1}, 4));
        System.out.println(subarraySum(new int[] {1, 1, 1}, 2));
        System.out.println(subarraySum(new int[] {-624,-624,-624,-624,-624,-624,-624,-624,-624,-624}, -624));
        System.out.println(subarraySum(new int[] {-815,388,230,365,-106,284,-222,-884,240,422,599,-315,-281,-14,29,-812,-55,106,-858,-581,-725,382,730,780,785,576,440,-378,529,-467,816,-754,983,-921,-616,-668,-6,-140,-795,-448,-96,-146,-435,141,951,933,566,821,-996,-380,542,810,-384,912,-442},
            62));
        System.out.println(subarraySum(new int[] {-19,-82,-70,-46,-29,7,15,-72,-7,100,303},100));
    }

    public static int subarraySum(int[] nums, int k) {

        int[] prefixSum = new int[nums.length + 1];
        prefixSum[0] = 0;

        Map<Integer, List<Integer>> compute = new HashMap<>();
        int result = 0, diff = 0;
        for (int i = 0; i < nums.length; i++) {

            prefixSum[i + 1] = prefixSum[i] + nums[i];

            if(k == 0)
                diff = (diff + nums[i]);
            else
                diff = Math.floorMod((diff + nums[i]), k);

            final int curIndexInPrefixSum = i + 1;

            if(compute.get(diff) == null){
                List<Integer> list = new ArrayList<>();
                list.add(0);
                compute.put(diff, list);
            }

            if(compute.containsKey(diff)){

                List<Integer> prevIndexes = compute.get(diff);

                for (int j = 0; j < prevIndexes.size(); j++) {

                    if(prefixSum[curIndexInPrefixSum] - prefixSum[prevIndexes.get(j)] == k){
                        result += 1;
                    }
                }
            }

            compute.get(diff).add(curIndexInPrefixSum);
        }
       return result;
    }
}
