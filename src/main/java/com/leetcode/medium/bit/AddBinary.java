package com.leetcode.medium.bit;

public class AddBinary {

    public static void main(String[] args) {
        System.out.println(addBinary("11111010101","10101"));
    }

    public static String addBinary(String a, String b) {

        StringBuilder result = new StringBuilder();
        char charA[] = a.toCharArray(), charB[] = b.toCharArray(), prev = '0';
        int i = charA.length - 1, j = charB.length - 1;
        while(i >= 0 && j >= 0) {
            char chA = charA[i--], chB = charB[j--];
            if(chA == '1' && chB == '1') {
                if(prev == '1') {
                    result.append('1');
                } else {
                    result.append('0');
                }
                prev = '1';
            } else {

                if(chA == '1' || chB == '1') {

                    if(prev == '1'){
                        result.append('0');
                        prev = '1';
                    } else {
                        result.append('1');
                        prev = '0';
                    }
                } else {
                    if(prev == '1') {
                        result.append('1');
                    } else {
                        result.append('0');
                    }
                    prev = '0';
                }
            }
        }

        prev = traverseString(result, charA, i, prev);
        prev = traverseString(result, charB, j, prev);

        if(prev == '1') result.append(prev);
        return result.reverse().toString();
    }

    private static char traverseString(StringBuilder result, char[] chars, int index, char prev) {

        while(index >= 0) {
            char ch = chars[index--];
            if(ch == '1') {
                if(prev == '1'){
                    result.append('0');
                    prev = '1';
                } else {
                    result.append('1');
                    prev = '0';
                }
            } else {
                if(prev == '1') {
                    result.append('1');
                } else {
                    result.append('0');
                }
                prev = '0';
            }
        }
        return prev;
    }
}
