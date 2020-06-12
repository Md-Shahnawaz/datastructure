package com.leetcode.medium.bit;

public class BitwiseAnd {

    public static void main(String[] args) {

        System.out.println(Integer.toBinaryString(5));
//        System.out.println(rangeBitwiseAnd(5, 7));
    }

    public static int rangeBitwiseAnd(int m, int n) {
        if(m == n) return m;
        String mStr, nStr;
        if(Math.abs(m - n) > 1){
            mStr = m == 0 ? Integer.toBinaryString(m) : Integer.toBinaryString(m - 1);
            nStr = n == 0 ? Integer.toBinaryString(n) : Integer.toBinaryString(n - 1);
        } else {
            mStr = Integer.toBinaryString(m );
            nStr = Integer.toBinaryString(n);
        }
        int i = mStr.length() - 1 , j = nStr.length() - 1;
        StringBuilder result = new StringBuilder();
        while (i >= 0 && j >= 0){
            if(mStr.charAt(i) == '1' && nStr.charAt(j) == '1'){
                result.append(1);
            } else {
                result.append(0);
            }
            i --;
            j --;
        }
        result.reverse();
        return Integer.parseInt(result.toString(), 2);
    }

}
