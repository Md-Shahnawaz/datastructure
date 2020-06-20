package com.leetcode.hard.backtracking;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class StickersToSpellWord {

    private static int minStickers = Integer.MAX_VALUE;
    public static void main(String[] args) {
//        System.out.println(minStickers(new String[]{"notice","possible","basic"}, "basicbasic"));
//        System.out.println(minStickers(new String[]{"notice","possible","basicbasic"}, "basicbasic"));
//        System.out.println(minStickers(new String[]{"with", "example", "science"}, "thehat"));
//        System.out.println(minStickers(new String[]{"bring","plane","should","against","chick"}, "greatscore"));
//        System.out.println(minStickers(new String[]{"wrote","travel","quotient","nose","any"}, "lastwest"));
        System.out.println(Integer.toBinaryString(48));
        System.out.println(Integer.toBinaryString(48>>3));
        System.out.println(48>>3);
    }

    public static int minStickers(String[] stickers, String target) {
        if(target == null || stickers == null || stickers.length == 0) return -1;
        if(target.length() == 0) return 0;
        minStickers = Integer.MAX_VALUE;

        // Start of preprocessing
        Set<Character> targetChars = new HashSet<>();
        for (char c : target.toCharArray()) targetChars.add(c); // Get all chars in target.
        Set<String> usableStickers = new HashSet<>();
        for (String s : stickers) {
            String prunedSticker = getPrunedSticker(s, targetChars);
            if (!prunedSticker.equals("")) usableStickers.add(prunedSticker); // Get all stickers which contains any char in target
        }

        int size = usableStickers.size();
        stickers = new String[size];
        for (String s : usableStickers) stickers[--size] = s;

        Arrays.sort(stickers, (a, b) -> b.length() - a.length());
        for (int i = 0; i < stickers.length; ++i) {
            for (int j = i + 1; j < stickers.length; ++j) {
                if (usableStickers.contains(stickers[j]) && dominates(stickers[i], stickers[j])) {
                    usableStickers.remove(stickers[j]); // remove dominated sticker
                }
            }
        } // end of preprocessing

        Map<Character, Integer> map = new HashMap<Character, Integer>();
        dfs(usableStickers, target, map, 0, 0);
        return minStickers == Integer.MAX_VALUE ? -1 : minStickers;
    }

    private static void dfs(Set<String> stickers, String target, Map<Character, Integer> map, int pos, int cnt) {
        if (cnt >= minStickers) return;
        if (pos == target.length()) {
            minStickers = Math.min(minStickers, cnt);
            return;
        }
        char t = target.charAt(pos);
        if (map.containsKey(t) && map.get(t) > 0) {
            map.put(t, map.get(t) - 1);
            dfs(stickers, target, map, pos + 1, cnt);
            map.put(t, map.get(t) + 1);
            return;
        }

        for (String sticker : stickers) {
            if (!sticker.contains(String.valueOf(t))) continue;
            for (char c : sticker.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
            map.put(t, map.get(t) - 1);
            dfs(stickers, target, map, pos + 1, cnt + 1);
            map.put(t, map.get(t) + 1);
            for (char c : sticker.toCharArray()) map.put(c, map.get(c) - 1);
        }
    }
    // used for preprocessing
    private static boolean dominates(String A, String B) {
        int[] charCount = new int[26];
        for (char c : A.toCharArray()) charCount[c - 'a']++;
        for (char c : B.toCharArray()) charCount[c - 'a']--;
        for (int i = 0; i < 26; ++i)
            if (charCount[i] < 0)
                return false;
        return true;
    }
    // used for preprocessing
    private static String getPrunedSticker(String s, Set<Character> targetChars) {
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (targetChars.contains(c))
                sb.append(c);
        }
        return sb.toString();
    }
//
//    public static int minStickers(String[] stickers, String target) {
//        if(target == null || stickers == null || stickers.length == 0) return -1;
//        if(target.length() == 0) return 0;
//        minStickers = Integer.MAX_VALUE;
//        char[] targetChar = target.toCharArray();
//        int[] chars = new int[26];
//        for (int i = 0; i < targetChar.length; i++) {
//            chars[targetChar[i] - 97]++;
//        }
//        backTrack(stickers, chars, target.length(),0, 0);
//        return minStickers == Integer.MAX_VALUE ? -1: minStickers;
//    }
//
//    private static void backTrack(String[] stickers, int[] targetChars, int target, int totalStickers, int index){
//        if(target == 0){
//            minStickers = Math.min(totalStickers, minStickers);
//            return;
//        }
//
//        if(index >= stickers.length) return;
//
//        char[] sticker = stickers[index].toCharArray();
//        int max = 0;
//        int[] stickerChars = new int[26];
//        int[] cache = new int[26];
//        for (int i = 0; i < sticker.length; i++) {
//            stickerChars[sticker[i] - 97]++;
//        }
//        for (int i = 0; i < 26; i++) {
//            int stickerCount = stickerChars[i];
//            int targetCount = targetChars[i];
//            if(stickerCount > 0 && targetCount > 0) {
//                if(targetCount <= stickerCount) {
//                    max = 1;
//                } else {
//                    int temp = 1;
//                    while(stickerCount * temp < targetCount) temp++;
//                    max = Math.max(max, temp);
//                }
//                target -= targetCount;
//                targetChars[i] = 0;
//                cache[i] = targetCount;
//            }
//        }
//
//        backTrack(stickers, targetChars, target,max + totalStickers, index + 1);
//        for (int i = 0; i < 26; i++) {
//            if(cache[i] > 0){
//                targetChars[i] = cache[i];
//                target += cache[i];
//            }
//        }
//        backTrack(stickers, targetChars, target, totalStickers, index + 1);
//    }
}
