package com.leetcode.easy.array;

public class BuyandSellStock {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[] {1, 2, 3, 4, 5}));
        System.out.println(maxProfit(new int[] {7, 6, 4, 3, 1}));
    }

    public static int maxProfit(int[] prices) {

        int maxProfit = 0, minPrice = Integer.MAX_VALUE, maxPrice = Integer.MIN_VALUE;

        for (int i = 0; i < prices.length; i++) {

            if (minPrice > prices[i]) {
                minPrice = prices[i];
                maxPrice = minPrice;
                continue;
            }

            if (maxPrice < prices[i]) {
                maxPrice = prices[i];
                maxProfit += maxPrice - minPrice;
                minPrice = maxPrice;
            }
        }
        return maxProfit;
    }
}
