package com.leetcode.medium.graph;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public class CourseSchedule2 {

    public static void main(String[] args) {
//        System.out.println(Arrays.toString(findOrder(3, new int[][]{{2, 0}, {1, 2}, {0, 1}})));
//        System.out.println(Arrays.toString(findOrder(4, new int[][]{{0, 1}, {3, 1}, {1, 3}, {3, 2}})));
        System.out.println(Arrays.toString(findOrder(8, new int[][]{{1,0},{2,6},{1,7},{6,4},{7,0},{0,5}})));
    }

    public static int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, Set<Integer>> adjMap = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            Set<Integer> set = adjMap.computeIfAbsent(prerequisites[i][0], k -> new HashSet<>());
            set.add(prerequisites[i][1]);
        }

        Set<Integer> visited = new LinkedHashSet<>();
        for (int i = numCourses - 1; i >= 0; i--) {
            if(isNotPossible(i, i, adjMap, visited)) {
                return new int[0];
            }
            visited.clear();
        }
        return new int[0];
    }

    private static boolean isNotPossible(int currentCourse, int startingCourse, Map<Integer, Set<Integer>> adjMap, Set<Integer> visited) {

        if(!adjMap.containsKey(currentCourse)) {
            return false;
        }

        visited.add(currentCourse);
        for (Integer c: adjMap.get(currentCourse)) {
            if(c == startingCourse || (!visited.contains(c) && isNotPossible(c, startingCourse, adjMap, visited))) {
                return true;
            }
        }
        return false;
    }
}
