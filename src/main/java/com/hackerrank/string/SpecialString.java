package com.hackerrank.string;

import java.util.HashSet;
import java.util.Objects;

public class SpecialString {

    public static void main(String[] args) {
        System.out.println(substrCount(7, "mnonopoo"));
    }
    static long substrCount(int n, String s) {

        HashSet<DP> set = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            set.add(new DP(i,i));
        }
        n = s.length();
        long sum = n;
        for (int i = n - 2; i >= 0; i--) {
            char c1 = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                char c2 = s.charAt(j);
                if(c1 == c2 && (set.contains(new DP(i, j - 1)) || set.contains(new DP(i + 1, j - 1)))){
                    set.add(new DP(i,j));
                    sum += 1;
                }
            }
        }
        return sum;
    }

    private static class DP{
        int i;
        int j;

        public DP(int i, int j) {
            this.i = i;
            this.j = j;
        }

        @Override public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            DP dp = (DP) o;
            return i == dp.i && j == dp.j;
        }

        @Override public int hashCode() {
            return Objects.hash(i, j);
        }
    }
}
