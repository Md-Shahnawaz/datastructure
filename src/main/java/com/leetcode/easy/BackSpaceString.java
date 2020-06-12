package com.leetcode.easy;

public class BackSpaceString {

    public static void main(String[] args) {
        System.out.println(backspaceCompare("y#fo##f", "y#f#o##f"));
        System.out.println(backspaceCompare("ab#c", "ad#c"));
        System.out.println(backspaceCompare("ab##", "c#d#"));
        System.out.println(backspaceCompare("a##c", "#a#c"));
        System.out.println(backspaceCompare("a#c", "#"));
    }

    public static boolean backspaceCompare(String S, String T) {
        char[] charS = new char[S.length()];
        char[] charT = new char[T.length()];
        S.getChars(0, S.length(), charS, 0);
        T.getChars(0, T.length(), charT, 0);

        int j = 0, k = 0;
        for (int i = 0; i < charS.length; i++) {
            char ch = charS[i];
            if(ch == '#'){
                j =  j - 1 < 0 ? 0 : j - 1;
            } else{
                charS[j] = charS[i];
                j ++;
            }
        }

        for (int i = 0; i < charT.length; i++) {
            char ch = charT[i];
            if(ch == '#'){
                k =  k - 1 < 0 ? 0 : k - 1;
            } else{
                charT[k] = charT[i];
                k ++;
            }
        }

        while(j >= 0 && k >= 0) {

            j -- ;
            k -- ;

            if(k != j || (j >= 0 && k >= 0 && charS[j] != charT[k])){
                return false;
            }

        }

        return true;
    }
}
