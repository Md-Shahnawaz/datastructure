package com.dp;

public class MDSP {

    public static void main(String[] args) {
        MDSP mdsp = new MDSP();
        System.out.println(mdsp.numDecodings("121212"));
//        System.out.println(mdsp.numDecodings("cddpd"));
//        System.out.println(mdsp.numDecodings("pqr"));
    }

    private static int numDecodings(String s) {

        int[] dp = new int[s.length() + 1];
        dp[0] = 1;
        dp[1] = s.indexOf(0) == '0'? 0: 1;
        for (int i = 2; i <= s.length(); i++) {
            char c1 = s.charAt(i - 1);
            char c0 = s.charAt(i - 2);
            if(c1 != '0') {
                dp[i] = dp[i-1];
            }
            if(c0 == '1'|| (c0 == '2' && c1 < '6')){
                dp[i] += dp[i-2];
            }
        }
        return dp[s.length()];
    }
}
