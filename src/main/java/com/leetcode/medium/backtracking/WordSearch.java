package com.leetcode.medium.backtracking;

public class WordSearch {
    public static void main(String[] args) {
        char[][] board = new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
        System.out.println(exist(board, "SEE"));
    }

    public static boolean exist(char[][] board, String word) {

        char[] wrd = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (wrd[0] == board[i][j] && backtrack(board, wrd, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean backtrack(char[][] board, char[] words, int i, int j, int k) {

        if (k == words.length) {
            return true;
        }

        if (!isPossible(board, i, j, words[k])) {
            return false;
        }
        char tmp = board[i][j];
        board[i][j] = '0';
        if (backtrack(board, words, i + 1, j, k + 1) ||
                backtrack(board, words, i - 1, j, k + 1) ||
                backtrack(board, words, i, j + 1, k + 1) ||
                backtrack(board, words, i, j - 1, k + 1)) return true;
        board[i][j] = tmp;
        return false;
    }

    private static boolean isPossible(char[][] board, int i, int j, char ch) {
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length && board[i][j] == ch;
    }
}
