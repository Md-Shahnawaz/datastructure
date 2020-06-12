package com.leetcode.easy.graph;

public class FindJudge {


    public static void main(String[] args) {
        System.out.println(findJudge(4, new int[][] {{1, 3}, {1, 4}, {2, 3}, {2, 4}, {4, 3}}));
        System.out.println(findJudge(3, new int[][] {{1, 3}, {3, 1}, {2, 3}}));
    }

    public static int findJudge(int N, int[][] trust) {

        int[] outDegree = new int[N];
        int[] inDegree = new int[N];
        for (int i = 0; i < trust.length; i++) {
            int[] temp = trust[i];
            outDegree[temp[0] - 1] += 1;
            inDegree[temp[1] - 1] += 1;
        }

        for (int i = 0; i < outDegree.length; i++) {
            if(outDegree[i] == 0 && inDegree[i] == N - 1) {
                return i + 1;
            }
        }
        return -1;
    }
}
