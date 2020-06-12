package com.leetcode.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagram {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
    public static List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> result = new HashMap<>();
        for (int i = 0; i < strs.length; i++) {
            String token = strs[i];
            char[] chars = new char[token.length()];
            token.getChars(0, chars.length, chars, 0);
            Arrays.sort(chars);
            String key = new String(chars);
            List<String> resultant = result.get(key);
            if(resultant == null){
                resultant = new ArrayList<>();
                result.put(key, resultant);
            }
            resultant.add(token);
        }
        return new ArrayList<>(result.values());
    }
}
