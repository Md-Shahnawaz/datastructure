package com.leetcode.easy.string.shift;

public class PerformStringShifts {

    public static void main(String[] args) {

        System.out.println(stringShift("abcdefg", new int[][]{{1,1},{1,1},{0,2},{1,3}}));
    }

    public static String stringShift(String s, int[][] shift) {

        StringBuilder s1 = new StringBuilder();
        StringBuilder s2 = new StringBuilder();
        char[] resultant = new char[s.length()];
        if(s.length() <= 1) return s;

        int[] moves = new int[2];
        for (int i = 0; i < shift.length; i++) {
            if(shift[i][0] == 0){
                moves[0] += shift[i][1];
            }else{
                moves[1] += shift[i][1];
            }
        }

        moves[0] = moves[0] % s.length();
        moves[1] = moves[1] % s.length();

        int move = Math.abs(moves[0] - moves[1]);
        int indexToMove = -1;

        if(moves[0] > moves[1]){
            indexToMove = s.length() - (s.length() - move);
        }else{
            indexToMove = s.length() - move;
        }

        s1.append(s.substring(0, indexToMove));
        s1.reverse();
        s2.append(s.substring(indexToMove, s.length()));
        s2.reverse();

        int l = s1.length() - 1, r = s2.length() - 1;
        int index = 0;
        while(r >= 0){
            resultant[index] = s2.charAt(r);
            r--;
            index++;
        }

        while (l >= 0){
            resultant[index] = s1.charAt(l);
            l--;
            index++;
        }

        return new String(resultant);
    }

}
