package com.leetcode.hard.backtracking;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class WordSearch2 {

    public static void main(String[] args) {
        char[][] board = new char[][] {
            {'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};

        String[] words = new String[] {"oath","pea","eat","rain"};

        System.out.println(findWords(board, words));
    }

    public static List<String> findWords(char[][] board, String[] words) {

        Set<String> result = new HashSet<>();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if(result.contains(word)) continue;
            for (int j = 0; j < board.length; j++) {
                for (int k = 0; k < board[0].length; k++) {
                    char ch = word.charAt(0);
                    if (ch == board[j][k] && dfs(board, word, j, k, 0)) {
                        result.add(word);
                    }
                }
            }
        }
        return new LinkedList<>(result);
    }

    private static boolean dfs(char[][] board, String word, int i, int j, int w) {

        if (w == word.length()) {
            return true;
        }

        if (isPossible(board, i, j, word.charAt(w))) {
            char temp = board[i][j];
            board[i][j] = 'A';
            if (dfs(board, word, i, j + 1, w + 1)) {
                board[i][j] = temp;
                return true;
            }
            if (dfs(board, word, i, j - 1, w + 1)) {
                board[i][j] = temp;
                return true;
            }
            if (dfs(board, word, i + 1, j, w + 1)) {
                board[i][j] = temp;
                return true;
            }
            if (dfs(board, word, i - 1, j, w + 1)) {
                board[i][j] = temp;
                return true;
            }
            board[i][j] = temp;
        }

        return false;
    }

    private static boolean isPossible(char[][] board, int i, int j, char ch) {
        return i >= 0 && i < board.length && j >= 0 && j < board[0].length && board[i][j] == ch;
    }
}
