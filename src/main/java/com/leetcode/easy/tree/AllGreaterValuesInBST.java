package com.leetcode.easy.tree;

public class AllGreaterValuesInBST {

    private static int sum = 0;
    public static void main(String[] args) {

        Node fifty = new Node(50);
        Node thirty = new Node(30);
        Node seventy = new Node(70);
        Node twenty = new Node(20);
        Node forty = new Node(40);
        Node sixty = new Node(60);
        Node eighty = new Node(80);

        fifty.left = thirty;
        fifty.right = seventy;

        thirty.left = twenty;
        thirty.right = forty;

        seventy.left = sixty;
        seventy.right = eighty;

        modifyBST(fifty);
        System.out.println(sum);

    }

    private static void modifyBST(Node root) {

        if(root == null) {
            return;
        }

        modifyBST(root.right);
        sum += root.data;
        root.data = sum;
        modifyBST(root.left);

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
