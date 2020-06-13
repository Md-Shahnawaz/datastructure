package com.leetcode.medium.hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class RandomizedSet {

    private HashMap<Integer, Integer> map;
    private List<Integer> list;
    private Random random;

    public RandomizedSet() {
        map = new HashMap();
        list = new ArrayList<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if(!map.containsKey(val)){
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        Integer index = map.remove(val);
        if(index != null) {
            list.set(index, list.get(list.size() - 1));
            list.remove(list.size() - 1);
            return true;
        }
        return false;
    }

    public int getRandom() {
        Integer result = list.get(random.nextInt(list.size()));
        while (result == null) {
            result = list.get(random.nextInt(list.size()));
        }
        return result;
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(2));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.remove(1));
        System.out.println(randomizedSet.insert(2));
        System.out.println(randomizedSet.getRandom());

    }
}
