package com.leetcode.hard.bfs;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class WordBreak2 {

    public static void main(String[] args) {
        System.out.println(wordBreak("catsanddogcat", Arrays.asList(new String[]{"cat","cats","and","sand","san","dog"})));
        System.out.println(wordBreak("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Arrays.asList(new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"})));
        System.out.println(wordBreak("abaaaa", Arrays.asList(new String[]{"a","b"})));
        System.out.println(wordBreak("catsandog", Arrays.asList(new String[]{"cats", "dog", "sand", "and", "cat"})));
        System.out.println(wordBreak("pineapplepenapple", Arrays.asList(new String[]{"apple", "pen", "applepen", "pine", "pineapple"})));

    }

    public static List<String> wordBreak(String s, List<String> wordDict) {

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        List<String>[] str = DP(s, wordDict, dp);
        if(!dp[n]) return Collections.emptyList();

        List<String> result = new LinkedList<>();
        StringBuilder builder = new StringBuilder();
        backtracking(result, builder, 0, str);
        return result;
    }

    private static void backtracking(List<String> result, StringBuilder builder, int index, List<String>[] str) {

        if(index == str.length - 1) {
            result.add(builder.deleteCharAt(builder.length() - 1).toString());
            return;
        }
        List<String> list = str[index];
        for(String next : list) {
            int size = builder.length();
            builder.append(next);
            builder.append(" ");
            backtracking(result, builder, index + next.length(), str);
            builder.delete(size, builder.length());
        }

    }

    private static List<String>[] DP(String s, List<String> wordDict, boolean[] dp) {

        List<String>[] str = new List[dp.length];
        for(int i = 0; i < dp.length - 1; i++) {
            if(dp[i]) {
                List<String> list = new LinkedList<>();
                for (String word: wordDict) {
                    if(s.indexOf(word, i) == i) {
                        dp[i + word.length()] = true;
                        list.add(word);
                    }
                }
                str[i] = list;
            }
        }
        return str;
    }
}
