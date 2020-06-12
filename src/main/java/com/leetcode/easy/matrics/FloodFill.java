package com.leetcode.easy.matrics;

import java.util.Arrays;

public class FloodFill {

    public static void main(String[] args) {

        int[][] image  = new int[][]{{1,1,1},{1,1,0},{1,0,1}};
//        int[][] image  = new int[][]{{0,0,0},{0,1,1}};
        int[][] result = floodFill(image, 1,1,2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(Arrays.toString(result[i]));
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {

        int[][] result = dfs(image, sr, sc, newColor, image[sr][sc]);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = result[i][j] < 0 ? -result[i][j]: result[i][j];
            }
        }
        return result;
    }

    private static int[][] dfs(int[][] image, int sr, int sc, int newColor, int startingColor) {

        if(isPossible(image, sr, sc, startingColor)) {
            image[sr][sc] = -newColor;
        } else {
            return image;
        }

        dfs(image, sr, sc + 1, newColor, startingColor);
        dfs(image, sr, sc - 1, newColor, startingColor);
        dfs(image, sr + 1, sc, newColor, startingColor);
        dfs(image, sr - 1, sc, newColor, startingColor);

        return image;
    }

    private static boolean isPossible(int[][] image, int sr, int sc, int color) {
        return sr >= 0 && sr < image.length && sc >= 0 && sc < image[0].length && image[sr][sc] == color;
    }
}
