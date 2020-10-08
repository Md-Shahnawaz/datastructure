package com.leetcode.medium.backtracking;

import java.util.LinkedList;
import java.util.List;

public class GenerateParentheses {

    public static void main(String[] args) {

        System.out.println(new GenerateParentheses().generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {

        List<String> result = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
//        backTrack(result, n, 0, 0, "");
        backtrack(result, sb, n, 0, 0);
        return result;
    }



    private void backtrack(List<String> result, StringBuilder sb, int n, int front, int back) {

        if(sb.length() == 2*n) {
            result.add(sb.toString());
            return;
        }

        if(front < n) {
            sb.append('(');
            backtrack(result, sb, n, front + 1, back);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(back < front) {
            sb.append(')');
            backtrack(result, sb, n, front, back + 1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

//    private void backTrack(List<String> result, int n, int left, int right, String interim) {
//
//        if (interim.length() == n*2) {
//            result.add(interim);
//            return;
//        }
//
//        if(left < n){
//            backTrack(result, n, left + 1, right, interim+"(");
//        }
//        if(right < left){
//            backTrack(result, n,  left, right + 1, interim+")");
//        }
//    }
}
