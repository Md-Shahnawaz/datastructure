package com.dp;

public class CountBinaryString {

    public static void main(String[] args) {
        countBinary(3);
    }

    private static void countBinary(int i) {

        int counter = 1, k = i;
        while(k <= i && k >= 0) {
            int j = k - 1, temp = k;
            int[] dp = new int[k];
            if (k == 1) {
                counter++;
                break;
            }
            while (temp > 0) {

                if (temp % 2 == 0) {
                    temp = temp / 2;
                    dp[j] = 0;
                } else {
                    temp = temp / 2;
                    dp[j] = 1;
                }

                if (j == k - 1 || (dp[j] == 1 && dp[j + 1] != 1)) {
                    counter++;
                }
                --j;
            }
            --k;
        }

        System.out.println(counter);
    }
}
