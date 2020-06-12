package com.leetcode.easy.binary;

public class NumberComplement {

    public static void main(String[] args) {
        System.out.println(findComplement(5));
    }

    public static int findComplement(int num) {
        String binary = Integer.toBinaryString(num);
        String result = "";
        for (int i = 0; i < binary.length(); i++) {
            result = binary.charAt(i) == '1' ? result.concat("0") : result.concat("1");
        }
        return Integer.valueOf(result, 2);
    }
}
