package com.leetcode.medium.graph.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CheapestFlightsWithinKStops {

    public static void main(String[] args) {

        System.out.println(findCheapestPrice(3, new int[][]{{0,1,100},{1,2,100},{0,2,500}}, 0, 2, 1));
        System.out.println(findCheapestPrice(10, new int[][] {{3, 4, 4}, {2, 5, 6}, {4, 7, 10}, {9, 6, 5}, {7, 4, 4}, {6, 2, 10}, {6, 8, 6}, {7, 9, 4}, {1, 5, 4},
                {1, 0, 4}, {9, 7, 3}, {7, 0, 5}, {6, 5, 8}, {1, 7, 6}, {4, 0, 9}, {5, 9, 1}, {8, 7, 3}, {1, 2, 6},
                {4, 1, 5}, {5, 2, 4}, {1, 9, 1}, {7, 8, 10}, {0, 4, 2}, {7, 2, 8}},6,0,7));
        System.out.println(findCheapestPrice(4, new int[][]{{0,1,1},{0,2,5},{1,2,1},{2,3,1}}, 0, 3, 1));
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int K) {
//        int[] cost= new int[n];
//        Arrays.fill(cost, Integer.MAX_VALUE);
//        cost[src] = 0;
//        for (int i=0; i<=K; i++){
//            int[] tmp = Arrays.copyOf(cost, n);
//            for (int[] a: flights){
//                int cur = a[0], next=a[1], price=a[2];
//                if (cost[cur]== Integer.MAX_VALUE)
//                    continue;
//                tmp[next] = Math.min(tmp[next], cost[cur]+price);
//            }
//            cost = tmp;
//        }
//        return cost[dst] == Integer.MAX_VALUE? -1: cost[dst];
        List<List<City>> adjList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }

        for (int i = 0; i < flights.length; i++) {
            int[] flight = flights[i];
            adjList.get(flight[0]).add(new City(flight[1], flight[2], 0));
        }
        int[] minCost = new int[n];
        Arrays.fill(minCost, Integer.MAX_VALUE);
        Queue<City> queue = new LinkedList<>();
        queue.offer(new City(src, 0, 0));
        while (!queue.isEmpty()) {
            City city = queue.poll();
            if(city.city == dst) {
                return Math.min(minCost[dst], city.costFromSrc);
            }
            if(city.destFromSrc > K) {
                continue;
            }
            for(City c: adjList.get(city.city)) {
                int totalCost = c.costFromSrc + city.costFromSrc;
                if(minCost[c.city] < totalCost) continue;
                minCost[c.city] = totalCost;
                queue.add(new City(c.city, totalCost, city.destFromSrc + 1));
            }
        }
        return minCost[dst] == Integer.MAX_VALUE ? -1: minCost[dst];
    }

    private static class City {
        int city;
        int costFromSrc;
        int destFromSrc;

        public City(int city, int costFromSrc, int destFromSrc) {
            this.city = city;
            this.costFromSrc = costFromSrc;
            this.destFromSrc = destFromSrc;
        }
    }
}
