package com.hackerearth;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class MarkIt {

    public static void main(String[] args) {
//        System.out.println(solveBFS(6, 100));
        System.out.println(solve(6, 10000));
    }

    static int solve(int N, int M){
        // Write your code here
        Map<Integer, Integer> found = new HashMap<>();
        dfs(found, N, M, 0);
        return min;
    }

    static int min = Integer.MAX_VALUE;

    static void dfs(Map<Integer, Integer> found, int N, int M, int sum) {

        if(N == M){
            min = Math.min(min, sum);
            return;
        }
        if(N > M) {
            return;
        }
        for(int i = N/2; i > 1; i--) {
            if(i%2 == 0 && N%i == 0) {
                int next = N + i, div = N/i;
                if(next <= M && found.getOrDefault(next, Integer.MAX_VALUE) > sum + div) {
                    found.put(next, sum + div);
                    dfs(found, next, M, sum + div);
                }
            }
        }
    }

    static int solveBFS(int N, int M){
        // Write your code here
        Map<Integer, Integer> found = new HashMap<>();
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{N, 0});
        int sum = Integer.MAX_VALUE;
        while(!queue.isEmpty()) {
//            System.out.println();
            int size = queue.size();
            for(int k = 0; k < size; k++) {
                int[] n = queue.poll();
                int i = n[0]/2;
                if(i % 2 == 1) i--;
                for(; i > 1; i-=2) {
                    if(i%2 == 0 && n[0]%i == 0) {
                        int next = n[0] + i, div = n[0]/i + n[1];
                        if(next == M) {
                            sum = Math.min(sum, div);
                        }
//                        System.out.println(next + " " + div);
                        if(next < M && found.getOrDefault(next, Integer.MAX_VALUE) > div) {

                            queue.add(new int[]{next, div});
                            found.put(next, div);
                        }
                    }
                }
            }
        }
        return sum == Integer.MAX_VALUE ? -1: sum;
    }
}


