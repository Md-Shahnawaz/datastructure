package com.leetcode.hard.bfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class WordSearch2 {

    public static void main(String[] args) {
        System.out.println(findLadders("hit", "cog", Arrays.asList(new String[]{"hot", "dot", "dog", "lot", "log", "cog"})));
    }

    public static List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> wordSet = new HashSet<>(wordList);
        wordSet.add(beginWord);
        Map<String, List<String>> ladderMap = new HashMap<>();
        Map<String, Integer> stepMap = new HashMap<>();
        List<List<String>> result = new LinkedList<>();

        bfs(ladderMap, stepMap, wordSet, beginWord, endWord);

        List<String> interim = new ArrayList<>();
        interim.add(beginWord);

        dfs(result, ladderMap, stepMap, beginWord, endWord, interim);
        return result;
    }

    private static void dfs(List<List<String>> result, Map<String, List<String>> ladderMap, Map<String, Integer> stepMap, String word, String endWord, List<String> interim) {

        if (interim.get(interim.size() - 1).equals(endWord)) {
            result.add(new LinkedList<>(interim));
            return;
        }
        List<String> list = ladderMap.get(word);
        int steps = stepMap.get(word);
        for (String str : list) {
            if (steps == stepMap.get(str) - 1) {
                interim.add(str);
                dfs(result, ladderMap, stepMap, str, endWord, interim);
                interim.remove(interim.size() - 1);
            }
        }
    }

    private static void bfs(Map<String, List<String>> ladderMap, Map<String, Integer> stepMap, Set<String> wordSet, String beginWord, String endWord) {

        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        int stepCount = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String wrd = queue.poll();
                if (endWord.equals(wrd)) {
                    stepMap.put(wrd, stepCount);
                    return;
                }
                List<String> stepList = new LinkedList<>();
                char[] chars = wrd.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char tmp = chars[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        chars[j] = k;
                        String match = new String(chars);
                        if (!wrd.equals(match) && wordSet.contains(match)) {
                            queue.offer(match);
                            stepList.add(match);
                        }
                    }
                    wordSet.remove(wrd);
                    chars[j] = tmp;
                }
                stepMap.put(wrd, stepCount);
                ladderMap.put(wrd, stepList);
            }
            stepCount++;
        }
    }
}