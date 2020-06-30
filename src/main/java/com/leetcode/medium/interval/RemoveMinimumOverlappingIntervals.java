package com.leetcode.medium.interval;

import java.util.Arrays;
import java.util.Comparator;

public class RemoveMinimumOverlappingIntervals {

    public static void main(String[] args) {
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{1,3},{3,4},{1,3}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{2,3},{1,2}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{2,3}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1,100},{11,22},{2,11},{2,12}}));
        System.out.println(eraseOverlapIntervals(new int[][]{{1,2},{2,3},{3,4},{-100,-2},{5,7}}));
    }

    public static int eraseOverlapIntervals(int[][] intervals) {
        if(intervals == null || intervals.length == 0) return 0;
        Arrays.sort(intervals, Comparator.comparingInt(val -> val[0]));
        int count = 0;
        int[] prev = intervals[0];
        for(int i = 1; i < intervals.length; i ++) {
            int[] current = intervals[i];
//            while(current[0] >= prev[0] && current[0] < prev[1]) {
//                count++;
//                if(current[1] > prev[1]) {
//                    i++;
//                    if(i < intervals.length) current = intervals[i];
//                    else break;
//                } else {
//                    break;
//                }
//            }
            if(current[0] < prev[1]) {
                count++;
                prev[1] = Math.min(current[1], prev[1]);
                continue;
            }
            prev = current;
        }
        return count;
    }
}
