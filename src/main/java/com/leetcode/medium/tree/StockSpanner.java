package com.leetcode.medium.tree;

import java.util.Objects;
import java.util.Stack;
import java.util.TreeMap;

public class StockSpanner {

    private Stack<Pair> stack;

    public static void main(String[] args) {
        StockSpanner S = new StockSpanner();
//        System.out.println(S.next(29));
//        System.out.println(S.next(91));
//        System.out.println(S.next(62));
//        System.out.println(S.next(76));
//        System.out.println(S.next(51));

        System.out.println(S.next(100));
        System.out.println(S.next(80));
        System.out.println(S.next(60));
        System.out.println(S.next(70));
        System.out.println(S.next(60));
        System.out.println(S.next(75));
        System.out.println(S.next(85));
    }

    //29, 91, 62, 76, 51
    public StockSpanner() {
        this.stack = new Stack<>();
    }

    public int next(int price) {

        Pair p = new Pair(price, 1);
        while(!stack.isEmpty() && stack.peek().num <= price){
            p.span += stack.peek().span;
            stack.pop();
        }
        stack.add(p);
        return stack.peek().span;
    }

    static class Pair {
        int num;
        int span;

        public Pair(int num, int span) {
            this.num = num;
            this.span = span;
        }
    }
}
