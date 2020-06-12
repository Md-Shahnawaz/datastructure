package com.leetcode.easy.string.shift;

public class ShiftingLetters {

    public static void main(String[] args) {
        System.out.println(shiftingLetters("abc", new int[] {3,5,9}));
        System.out.println(shiftingLetters("mkgfzkkuxownxvfvxasy", new int[] {505870226,437526072,266740649,224336793,532917782,311122363,567754492,595798950,81520022,684110326,137742843,275267355,856903962,148291585,919054234,467541837,622939912,116899933,983296461,536563513}));
        System.out.println(shiftingLetters("gdhbjaph", new int[] {74,34,65,30,43,91,14,10}));
    }

    public static String shiftingLetters(String S, int[] shifts) {

        char[] alphabets = new char[S.length()];
        S.getChars(0, alphabets.length, alphabets, 0);
        int shift = 0;
        for (int i = shifts.length - 1; i >= 0; i--) {

            shift = (shift + shifts[i]) % 26;
            int temp = (((int)alphabets[i]) + shift) % 123;
            if(temp < 97){
                alphabets[i] = (char)(97 + temp);
            } else {
                alphabets[i] = (char)temp;
            }
        }
        return new String(alphabets);
    }
}
