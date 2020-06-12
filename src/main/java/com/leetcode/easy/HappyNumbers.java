package com.leetcode.easy;

import java.util.HashSet;
import java.util.Set;

public class HappyNumbers {

    public static void main(String[] args) {
        System.out.println(isHappy(11111123));
    }

    public static boolean isHappy(int n) {

        int sum = n;
        Set<Integer> uniq = new HashSet<>();

        while (sum != 1) {

            int temp = sum;
            sum = 0;
            long divisor = 1;

            while (temp > divisor) {
                divisor *= 10;
                sum += Math.pow(Math.floorDiv(temp % divisor, divisor/10), 2);
                temp -= temp % divisor;
            }

            sum += Math.pow(Math.floorDiv(temp, divisor), 2);

            if(uniq.contains(sum)){
                return false;
            }

            uniq.add(sum);
        }
        return true;
    }
}
