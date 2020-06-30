package com.leetcode.hard.slidingwindow;

import java.util.*;

public class SubStrngWithConcat {

    public static void main(String[] args) {
        System.out.println(findSubstring("barfoothefoobarmanfoothefoobar", new String[]{"foo","bar"}));
        System.out.println(findSubstring("wordgoodbestwordgoodbestwordgoodword", new String[]{"word","good","best","word"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword", new String[]{"word","good","best","word"}));
        System.out.println(findSubstring("lingmindraboofooowingdingbarrwingmonkeypoundcakefooowingdingbarrwing", new String[]{"fooo","barr","wing","ding","wing"}));
    }
    public static List<Integer> findSubstring(String s, String[] words) {
        if(s.length() == 0 || words == null || words.length == 0) return Collections.emptyList();
        Map<String, Integer> map = new HashMap<>();

        int index = 1;
        List<Integer> result = new LinkedList<>();

        for (String word : words) {
            if(!map.containsKey(word)) {
                map.put(word, index++);
            }
        }

        long patternHash = 0, matchHash = 0;
        for (String  word: words) {
            patternHash += generateHash(map, word);
        }

        boolean found = false;
        int n = words.length, m = words[0].length(), start = 0, end = 0;
        while((end + m) <= s.length()) {

            String token = s.substring(end, end + m);
            if(map.containsKey(token)){
                if(matchHash == 0) start = end;
                matchHash += generateHash(map, token);
                found = true;
            } else {
                matchHash = 0;
                start = end;
                found = false;
            }

            while(matchHash > patternHash) {
                token = s.substring(start, start + m);
                if(map.containsKey(token)){
                    matchHash -= generateHash(map, token);
                }
                start += m;
            }

            if(matchHash == patternHash) {
                start = end - (n - 1)*m;
                result.add(start);
                token = s.substring(start, start + m);
                if(map.containsKey(token)){
                    matchHash -= generateHash(map, token);
                }
                start += m;
                found = false;
            }

            end += found ? m : 1;
        }
        return result;
    }

    private static long generateHash(Map<String, Integer> map, String word){
        long primeNumber = (7 << map.get(word)) % Long.MAX_VALUE;
        return primeNumber * map.get(word);
    }
}
