package com.leetcode.hard.string.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConcatString {

    public static void main(String[] args) {
        System.out.println(findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcake", new String[]{"fooo","barr","wing","ding","wing"}));
    }

    public static List<Integer> findSubstring(String s, String[] words) {

        List<Integer> result = new ArrayList<>();
        if(words.length == 0 || s.length() == 0) return result;
        int wordsLen = words.length, wLen = words[0].length(), total = wordsLen * wLen;

        Map<String, Integer> map = new HashMap<>();
        for(String w : words) {
            map.put(w, map.getOrDefault(w, 0) + 1);
        }

        int i = 0, j = total, diff = 0;
        for(int k = 0; k < wLen; k++) {
            i = k;
            while(i <= (s.length() - wLen)) {

                String token = s.substring(i, i + wLen);

                if(!map.containsKey(token)) {

                    if(map.size() == 0) {
                        diff = i - total;
                        result.add(diff);
                    } else {
                        diff = i - (total - j);
                    }
                    while(!map.containsKey(token) && diff < i) {
                        String w = s.substring(diff, diff+wLen);
                        map.put(w, map.getOrDefault(w, 0) + 1);
                        diff += wLen;
                        j += wLen;
                    }
                }

                if(map.containsKey(token)) {

                    Integer count = map.get(token);
                    if(count <= 1) {
                        map.remove(token);
                    } else {
                        map.put(token, count - 1);
                    }
                    j -= wLen;
                    i += wLen;
                    continue;
                }
                i ++;
            }
        }

        if(map.size() == 0) {
            diff = i - total;
            result.add(diff);
        }

        return result;
    }
}
