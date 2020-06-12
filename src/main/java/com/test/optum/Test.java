package com.test.optum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Test {

    public static void main(String[] args){
//        int[] a = new int[]{4, 2, 2, 4, 2};
        int[] a = new int[]{1,2 , 3, 2, 4};
        System.out.println(solution(a));
    }
    public static int solution(int[] A) {
        Map<Integer, Integer> mapping = new HashMap<>();
        for (int i = 0; i < A.length; i++) {
            mapping.putIfAbsent(A[i], 0);
            mapping.computeIfPresent(A[i], (k, v) -> v+1);
        }
        int[] cache = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};
        int fmax_count = -1, smax_count = -1;
        for (Map.Entry<Integer, Integer> entry : mapping.entrySet()) {
            int value = entry.getValue();
            if(cache[0] == Integer.MIN_VALUE){
                cache[0] = entry.getKey();
                fmax_count = entry.getValue();
                continue;
            }

            if(cache[1] == Integer.MIN_VALUE){
                cache[1] = entry.getKey();
                smax_count = entry.getValue();
            }

            if(fmax_count <= value){
                cache[1] = cache[0];
                cache[0] = entry.getKey();
                smax_count = fmax_count;
                fmax_count = entry.getValue();
            }
        }
        System.out.println(mapping);
        System.out.println(Arrays.toString(cache));
        System.out.println(fmax_count);
        System.out.println(smax_count);
        return fmax_count + (smax_count == -1 ? 0 : smax_count);

    }
}
