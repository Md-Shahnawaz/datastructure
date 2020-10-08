package com.leetcode.medium.graph.topological;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CourseSchedulle2 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        List<List<Integer>> courseMapping = new ArrayList<>(numCourses);
        for(int i = 0; i < numCourses; i++) {
            courseMapping.add(new ArrayList<>());
        }

        int[] outDegree = new int[numCourses];
        for(int[] rel : prerequisites) {
            courseMapping.get(rel[1]).add(rel[0]);
            outDegree[rel[0]]++;
        }

        int j = 0, result[] = new int[numCourses], courseTaken = 0;

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++) {
            if(outDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while(!queue.isEmpty()){

            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Integer course = queue.poll();
                result[j++] = course;
                courseTaken++;
                List<Integer> interim = courseMapping.get(course);
                for(Integer relatedCourse : interim){
                    if(--outDegree[relatedCourse] == 0) {
                        queue.offer(relatedCourse);
                    }
                }
            }
        }
        return courseTaken == numCourses ? result: new int[0];
    }
}
