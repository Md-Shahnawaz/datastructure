package com.leetcode.medium.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule {

    public static void main(String[] args) {
//        System.out.println(canFinish(3, new int[][]{{2, 0}, {1, 2}, {0, 1}}));
//        System.out.println(canFinish(4, new int[][]{{0, 1}, {3, 1}, {1, 3}, {3, 2}}));
//        System.out.println(canFinish(8, new int[][]{{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}}));
        System.out.println(canFinish(6, new int[][]{{5,0},{5,2},{4,0},{4,1},{2,3},{3,1}}));
    }

    public static boolean canFinish(int n, int[][] prerequisites) {
        ArrayList<Integer>[] G = new ArrayList[n];
        int[] degree = new int[n];
        ArrayList<Integer> bfs = new ArrayList();
        for (int i = 0; i < n; ++i) G[i] = new ArrayList<Integer>();
        for (int[] e : prerequisites) {
            G[e[1]].add(e[0]);
            degree[e[0]]++;
        }
        for (int i = 0; i < n; ++i) if (degree[i] == 0) bfs.add(i);
        for (int i = 0; i < bfs.size(); ++i)
            for (int j: G[bfs.get(i)])
                if (--degree[j] == 0) bfs.add(j);
        return bfs.size() == n;
    }

//    public static boolean canFinish(int numCourses, int[][] prerequisites) {
//
//        Map<Integer, Set<Integer>> adjMap = new HashMap<>();
//        for (int i = 0; i < prerequisites.length; i++) {
//
//            Set<Integer> set = adjMap.computeIfAbsent(prerequisites[i][0], k -> new HashSet<>());
//            set.add(prerequisites[i][1]);
//        }
//
//        Set<Integer> visited = new HashSet<>();
//        for (int i = 0; i < numCourses; i++) {
//            if(!visited.contains(i) && dfs(i, adjMap, i, visited)) {
//                return false;
//            }
//            visited.clear();
//        }
//        return true;
//    }

//    private static boolean dfs(
//        int course, Map<Integer, Set<Integer>> adjMap, int mainCourse, Set<Integer> visited) {
//
//        if(!adjMap.containsKey(course)) {
//            return false;
//        }
//
//        visited.add(course);
//        for (Integer c: adjMap.get(course)) {
//            if(mainCourse == c || (!visited.contains(c) && dfs(c, adjMap, mainCourse, visited))) {
//                return true;
//            }
//        }
//        return false;
//    }
}
