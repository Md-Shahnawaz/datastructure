package com.leetcode.easy.tree;

public class MinimumSumPath {

    private static int minSum = Integer.MAX_VALUE;
    public static void main(String[] args) {

        Node four = new Node(4);
        Node mSix = new Node(-6);
        Node five = new Node(5);
        Node two = new Node(2);
        Node mThree = new Node(-3);
        Node one = new Node(1);
        Node eight = new Node(8);

        four.left = five;
        four.right = mSix;

        five.left = two;
        five.right = mThree;

        mSix.left = one;
        mSix.right = eight;

        findMinSum(four);
        System.out.println(minSum);

    }


    public static int findMinSum(Node root){

        if(root == null){
            return 0;
        }

        int l = 0, r = 0, c = root.data;

        l += findMinSum(root.left);
        r += findMinSum(root.right);

        if(root.left != null || root.right != null){
            minSum = Math.min(minSum, l + r + c);
            return Math.min((l + c), (r + c));
        }
        return c;
    }


    public static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }
    }
}
