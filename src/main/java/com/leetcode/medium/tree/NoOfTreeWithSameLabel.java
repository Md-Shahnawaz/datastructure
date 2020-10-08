package com.leetcode.medium.tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NoOfTreeWithSameLabel {

    public static void main(String[] args) {

//        System.out.println(Arrays.toString(countSubTrees(5, new int[][]{{0,1},{0,2},{1,3},{0,4}}, "aabab")));
        System.out.println(Arrays.toString(countSubTrees(7, new int[][]{{0,1},{1,2},{2,3},{3,4},{4,5},{5,6}}, "aaabaaa")));
    }

    public static int[] countSubTrees(int n, int[][] edges, String labels) {

        int[] result = new int[n];
        List<List<Integer>> relation = new ArrayList<>(n);
        for(int i = 0; i < n; i++) {
            relation.add(new ArrayList<>());
        }

        for(int[] ed: edges) {
            relation.get(ed[0]).add(ed[1]);
        }
        Arrays.fill(result, 1);
        traverse(relation, labels, 0, result, labels.charAt(0));
        return result;
    }

    private static int traverse(List<List<Integer>> relation, String labels, int node, int[] result, char parent){

        if(relation.get(node).size() == 0) {
            if(labels.charAt(node) != parent) {
                return 0;
            }
            return result[node];
        }

        for(Integer r : relation.get(node)) {

            if(labels.charAt(r) == labels.charAt(node)) {
                result[node] += traverse(relation, labels, r, result, parent);
            } else {
                traverse(relation, labels, r, result, labels.charAt(r));
            }
        }

        return result[node];
    }
}
