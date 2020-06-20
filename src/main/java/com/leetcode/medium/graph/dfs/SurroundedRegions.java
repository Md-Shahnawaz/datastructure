package com.leetcode.medium.graph.dfs;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class SurroundedRegions {

    public static void main(String[] args) {
//        char[][] chars1 = new char[][]{{'X', 'X', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
//        char[][] chars2 = new char[][]{{'X', 'O', 'X', 'X'}, {'X', 'O', 'O', 'X'}, {'X', 'X', 'O', 'X'}, {'X', 'O', 'X', 'X'}};
        char[][] chars3 = new char[][]{
                {'O','X','X','X','X','X','O','O'},
                {'O','O','O','X','X','X','X','O'},
                {'X','X','X','X','O','O','O','O'},
                {'X','O','X','O','O','X','X','X'},
                {'O','X','O','X','X','X','O','O'},
                {'O','X','X','O','O','X','X','O'},
                {'O','X','O','X','X','X','O','O'},
                {'O','X','X','X','X','O','X','X'}};
//       [["O","X","X","X","X","X","O","O"],
//        ["O","O","O","X","X","X","X","O"],
//        ["X","X","X","X","O","O","O","O"],
//        ["X","X","X","O","O","X","X","X"],
//        ["O","X","X","X","X","X","O","O"],
//        ["O","X","X","X","X","X","X","O"],
//        ["O","X","X","X","X","X","O","O"],
//        ["O","X","X","X","X","O","X","X"]]
//        solve(chars1);
//        solve(chars2);
        solve(chars3);
        Arrays.stream(chars3).forEach((ch -> System.out.println(Arrays.toString(ch))));
        System.out.println();
//        Arrays.stream(chars2).forEach((ch -> System.out.println(Arrays.toString(ch))));

    }

    public static void solve(char[][] board) {
        if(board == null || board.length < 3 || board[0].length < 3) return;
        List<int[]> visitedList = new LinkedList<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 1; i < board.length - 1; i++) {
            for (int j = 1; j < board[0].length - 1; j++) {
                if (board[i][j] == 'O') {
                    if(!dfs(board, i, j, visited, visitedList)){
                        board[i][j] = 'X';
                    }
                }
            }
        }
    }

    private static boolean dfs(char[][] board, int i, int j, boolean[][] visited, List<int[]> visitedList) {

        if (i == 0 || j == 0 || i == board.length - 1 || j == board[0].length - 1) {
            return true;
        }

        visited[i][j] = true;
        visitedList.add(new int[]{i, j});
        if ((isPossible(board, i + 1, j, visited) && dfs(board, i + 1, j, visited, visitedList)) ||
                (isPossible(board, i - 1, j, visited) && dfs(board, i - 1, j, visited, visitedList)) ||
                (isPossible(board, i, j + 1, visited) && dfs(board, i, j + 1, visited, visitedList)) ||
                (isPossible(board, i, j - 1, visited) && dfs(board, i, j - 1, visited, visitedList))) {
            visitedList.stream().forEach((int[] c) -> visited[c[0]][c[1]] = false);
            visitedList.clear();
            return true;
        }
        return false;
    }

    private static boolean isPossible(char[][] board, int i, int j, boolean[][] visited) {
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length && board[i][j] == 'O' && !visited[i][j];
    }
}
