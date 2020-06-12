package com.leetcode.hard.tree;

public class ValidPath {

    public boolean isValidSequence(TreeNode root, int[] arr) {

        return isValidPath(root, arr, 0);
    }

    private boolean isValidPath(TreeNode node, int[] arr, int i){

        if(node == null || i >= arr.length){
            return false;
        }

        if(i == arr.length - 1 && arr[i] == node.val && node.right == null && node.left == null){
            return true;
        }

        if(arr[i] == node.val){
            return isValidPath(node.left, arr, i + 1) || isValidPath(node.right, arr, i + 1);
        } else {
            return false;
        }
    }

    public class TreeNode {
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
