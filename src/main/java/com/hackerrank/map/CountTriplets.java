package com.hackerrank.map;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class CountTriplets {
    public static void main(String[] args) {
        Long[] arr = new Long[] {1l, 3l, 9l, 9l, 27l, 81l,};
        List<Long> list = Arrays.asList(arr);
        System.out.println(countTriplets(list, 3));
    }

    static long countTriplets(List<Long> arr, long r) {
        Map<Long, List<Integer>> mapping = new HashMap<>();
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> list = mapping.get(arr.get(i));
            if (Objects.isNull(list)) {
                list = new ArrayList<>();
                mapping.put(arr.get(i), list);
            }
            list.add(i);
        }

        long counter = 0;
        for (int i = 0; i < arr.size(); i++) {
            List<Integer> list1 = mapping.get(arr.get(i) * r);
            List<Integer> list2 = mapping.get((arr.get(i) * r) * r);
            if (Objects.nonNull(list1) && Objects.nonNull(list2)) {
                counter += ((list1.size() - Collections.binarySearch(list1, i) - 1) * (list2.size()
                    - Collections.binarySearch(list2, i) - 1));
            }
        }
        return counter;
    }
}
