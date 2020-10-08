package com.leetcode.easy.tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Objects;

public class InvertBT {

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);

        four.left = two;
        four.right = seven;
        two.left = one;
        two.right = three;
        seven.left = six;
        seven.right = nine;

        TreeNode result = invertTree(four);
        System.out.println(result);
        System.out.println(depth(four, 1));
    }

    private static void print(TreeNode node){
        if(node == null) return;

        print(node.left);
        System.out.println(node.val);
        print(node.right);

    }

    /**
     *
     * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
     *
     * Example:
     *
     * Input: [0,1,0,3,12]
     * Output: [1,3,12,0,0]
     */
    //     4
    //   /   \
    //  2     7
    // / \   / \
    //1   3 6   9

    public static TreeNode invertTree(TreeNode root) {

        if(root == null)
            return null;

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);

        root.left = right;
        root.right = left;

        return root;
    }

    public static int depth(TreeNode node, int depth){
        if(node == null){
            return depth - 1;
        }

        return Math.max(depth(node.left, depth + 1),depth(node.right, depth + 1));
    }

    private static TreeNode recursive(TreeNode node, TreeNode result) {

        if(node == null) {
            return result;
        }

        if(node.left != null) {
            result.right = new TreeNode(node.left.val);
            recursive(node.left, result.right);
        }

        if(node.right != null) {
            result.left = new TreeNode(node.right.val);
            recursive(node.right, result.left);
        }
        return result;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
