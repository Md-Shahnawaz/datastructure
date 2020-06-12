package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class TotalFruit {

    public static void main(String[] args) {
        System.out.println(totalFruit(new int[] {0,1,2,2}));
    }
    public static int totalFruit(int[] tree) {

        Map<Integer, Integer> uniqFruitCount = new HashMap<>();
        int j = 0, maxCount = 0, maxTemp = 0;
        for (int i = 0; i < tree.length; i++) {

            Integer fruitCount = uniqFruitCount.get(tree[i]);
            if(Objects.isNull(fruitCount)){
                fruitCount = 0;
            }
            fruitCount += 1;
            maxTemp += 1;
            uniqFruitCount.put(tree[i], fruitCount);

            while(uniqFruitCount.size() > 2){
                Integer count = uniqFruitCount.get(tree[j]);
                if(count == 1){
                    uniqFruitCount.remove(tree[j]);
                } else{
                    count -= 1;
                    uniqFruitCount.put(tree[j], count);
                }
                maxTemp -= 1;
                j++;
            }
            maxCount = Math.max(maxCount, maxTemp);
        }
        return maxCount;
    }
}
