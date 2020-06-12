package com.leetcode.medium.stack;

import java.util.Stack;

public class RemoveKdigits {

    public static void main(String[] args) {

//        System.out.println(removeKdigits("1432219", 3));
//        System.out.println(removeKdigits("10200", 1));
//        System.out.println(removeKdigits("10", 2));
        System.out.println(removeKdigits("112", 1));
    }

    public static String removeKdigits(String num, int k) {

        if(num.length() <= k) return "0";
        Stack<Integer> stack = new Stack<>();
        for (int i = (num.length() - 1); i >= 0; i--) {
            char ch = num.charAt(i);
            stack.push((int)ch - 48);
        }

        for (int i = 0; i < k; i++) {
            int ele = stack.pop();
            if(ele < stack.peek()){
                stack.pop();
                stack.push(ele);
            }
        }

        while(stack.size() > 0 && stack.peek() == 0){
            stack.pop();
        }

        StringBuilder result = new StringBuilder();
        while(stack.size() > 0) {
            result.append(stack.pop());
        }
        return result.toString().equals("") ? "0" : result.toString();
    }
}
