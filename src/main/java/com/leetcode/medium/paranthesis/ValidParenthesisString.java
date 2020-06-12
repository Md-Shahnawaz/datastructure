package com.leetcode.medium.paranthesis;


import java.util.Stack;

public class ValidParenthesisString {

    public static void main(String[] args) {
//        System.out.println(checkValidString("(**))"));
        System.out.println(checkValidString("(())((())()()(*)(*()(())())())()()((()())((()))(*"));
    }

    public static boolean checkValidString(String s) {
        Stack<Node> bracket = new Stack<>();
        Stack<Node> astrix = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if(ch == '('){
                bracket.push(new Node(ch, i));
                continue;
            }
            if(ch == '*'){
                astrix.push(new Node(ch, i));
                continue;
            }



        }
        return bracket.size() == 0;
    }

    public static class Node {
        char ch;
        int index;

        public Node(char ch, int index) {
            this.ch = ch;
            this.index = index;
        }
    }
}
