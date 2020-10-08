package com.leetcode.medium.graph.topological;

import java.util.ArrayList;
import java.util.List;

public class CourseSchedule3 {
    public static void main(String[] args) {
//        int[][] prerequisites = new int[][]{{0,1},{1,2},{2,3},{3,4}};
//        int[][] queries = new int[][]{{0,4},{4,0},{1,3},{3,0}};
        int[][] prerequisites = new int[][]{{2,3},{2,1},{2,0},{3,4},{3,6},{5,1},{5,0},{1,4},{1,0},{4,0},{0,6}};
        int[][] queries = new int[][]{{3,0},{6,4},{5,6},{2,6},{2,3},{5,6},{4,0},{2,6},{3,5},{5,3},{1,6},{1,0},{3,5},{6,5},{2,3},{3,0},{3,4},{3,4},{2,5},{0,3},{4,0},{6,4},{5,0},{6,5},{5,6},{6,5},{1,0},{3,4},{1,5},{1,4},{3,6},{0,1},{1,2},{5,1},{5,3},{5,3},{3,4},{5,4},{5,4},{5,3}};
        System.out.println(checkIfPrerequisite(7, prerequisites, queries));


    }
    public static List<Boolean> checkIfPrerequisite(int n, int[][] prerequisites, int[][] queries) {

        List<List<Integer>> courseMapping = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            courseMapping.add(new ArrayList<>());
        }

        for(int[] rel : prerequisites) {
            courseMapping.get(rel[0]).add(rel[1]);
        }

        Boolean[][] reachable = new Boolean[n][n];
        List<Boolean> result = new ArrayList<>(queries.length);
        for(int[] query : queries) {
            if(isReachable(reachable, query[0], query[1], courseMapping)) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        return result;
    }

    private static boolean isReachable(Boolean[][] reachable, int src, int dest, List<List<Integer>> courseMapping) {

        if(dest == src) {
            return reachable[src][dest] = true;
        }

        if(reachable[src][dest] != null){
            return reachable[src][dest];
        }

        List<Integer> dependents = courseMapping.get(src);
        for(Integer dependent : dependents){
            if(isReachable(reachable, dependent, dest, courseMapping)) {
                return reachable[src][dest] = true;
            }
        }

        return reachable[src][dest] = false;
    }

}
