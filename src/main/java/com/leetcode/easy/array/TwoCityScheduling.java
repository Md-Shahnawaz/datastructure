package com.leetcode.easy.array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TwoCityScheduling {

    public static void main(String[] args) {
//        System.out.println(twoCitySchedCost(new int[][]{{10,20},{30,200},{400,50},{30,20}}));
        System.out.println(twoCitySchedCost(new int[][]{{259,770},{448,54},{926,667},{184,139},{840,118},{577,469}}));
    }

    public static int twoCitySchedCost(int[][] costs) {

        PriorityQueue<Pair> minHeapA = new PriorityQueue<>();
        PriorityQueue<Pair> minHeapB = new PriorityQueue<>();
        int costA = 0, costB = 0;
        for (int i = 0; i < costs.length; i++) {
            Pair p = new Pair(costs[i][0], costs[i][1], Math.abs(costs[i][0] - costs[i][1]));
            if(costs[i][0] < costs[i][1]) {
                minHeapA.add(p);
                costA += costs[i][0];
            } else {
                minHeapB.add(p);
                costB += costs[i][1];
            }
        }
        while (minHeapA.size() != minHeapB.size()) {
            if(minHeapA.size() > minHeapB.size()) {
                Pair p = minHeapA.poll();
                costA -= p.costA;
                costB += p.costB;
                minHeapB.add(p);

            } else {
                Pair p = minHeapB.poll();
                costB -= p.costB;
                costA += p.costA;
                minHeapA.add(p);
            }
        }
        return costA + costB;
    }

    private static class Pair implements Comparable<Pair> {

        int costA;
        int costB;
        int diff;

        Pair(int a, int b, int c) {
            this.costA = a;
            this.costB = b;
            this.diff = c;
        }

        @Override
        public int compareTo(Pair p) {
            return -Integer.compare(p.diff,this.diff);
        }
    }
}
