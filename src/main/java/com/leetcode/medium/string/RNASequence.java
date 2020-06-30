package com.leetcode.medium.string;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RNASequence {

    public static void main(String[] args) {
        System.out.println(findRepeatedDnaSequencesBit("AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"));
    }

    //Rabin - Karp Rolling hash
    public static List<String> findRepeatedDnaSequences(String s) {
        int mod = Integer.MAX_VALUE;
        int factor = 26, n = 10;
        double hash = 0, multiplier = 1;
        Set<Double> set = new HashSet<>();
        for(int i = 0; i < n; i++) {
            hash = ((hash*factor + s.charAt(i)) % mod);
        }
        set.add(hash);
        for(int i = 0; i < n; i++) {
            multiplier = ((multiplier * factor) % mod);
        }
        List<String> result = new ArrayList<>();
        for(int i = 0; i < (s.length() - n); i++) {
            hash = (((hash*factor - multiplier*s.charAt(i))) % mod + mod) % mod;
            hash = (hash + s.charAt(i + n)) % mod;
            if(set.contains(hash)) {
                result.add(s.substring(i + 1, i + n + 1));
            }
            set.add(hash);
        }
        return result;
    }

    //Rabin - Karp rolling hash bitManipulation
    public static List<String> findRepeatedDnaSequencesBit(String s) {
        List<String> result = new ArrayList<>();
        int[] map = new int['T' + 1];
        map['A'] = 0;
        map['B'] = 1;
        map['C'] = 2;
        map['T'] = 3;
        int hash = 0;
        byte[] hashSet = new byte[0xFFFFF];
        for(int i = 0; i < 10; i++) {
            hash = hash << 2 | map[s.charAt(i)];
        }
        hashSet[hash] = 1;
        for(int i = 10; i < s.length(); i++) {
            hash = (hash << 2) & 0xFFFFF | map[s.charAt(i)];
            if(hashSet[hash] == 0) {
                hashSet[hash]++;
            }
            else if(hashSet[hash] == 1) {
                result.add(s.substring(i - 9, i + 1));
                hashSet[hash]++;
            }
        }
        return result;

        //List<String> ans = new ArrayList<>();
        //        if(s.length() < 10){
        //            return ans;
        //        }
        //
        //        int a = 1<<20;
        //        a--;
        //        char str[] = s.toCharArray();
        //        byte hashset[] = new byte[a];
        //        byte map[] = new byte['T' + 1];
        //        map['A'] = 0;
        //        map['C'] = 1;
        //        map['G'] = 2;
        //        map['T'] = 3;
        //
        //        int hash = 0;
        //        for(int i = 0;i < 10;i++)
        //            hash = hash<< 2 | map[str[i]];
        //
        //        hashset[hash] = 1;
        //
        //        for(int i = 10; i < s.length(); i++){
        //            hash = hash << 2 & a | map[str[i]];
        //            if(hashset[hash] == 0)
        //                hashset[hash]++;
        //            else if(hashset[hash] == 1){
        //                hashset[hash]++;
        //                ans.add(s.substring(i - 9, i + 1));
        //            }
        //        }
        //        return ans;
        //    }
    }
}
