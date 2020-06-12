package com.leetcode.medium.tree;

import java.util.Stack;

public class PreOrderTraversal {

    public static void main(String[] args) {
//8,5,1,7,10,12
        bstFromPreorder(new int[]{8,5,1,7,10,12});
    }

    public static TreeNode bstFromPreorder(int[] preorder) {

        TreeNode root = new TreeNode(preorder[0]);
        for (int i = 0; i < preorder.length; i++) {
            traverse(root, preorder[i]);
        }
        return root;
    }

    public static boolean traverse(TreeNode node, int ele){

        if(node == null){
            return true;
        }

        if(node.val > ele){
            if(traverse(node.left, ele)){
                node.left = new TreeNode(ele);
            }
        }

        if(node.val < ele){
            if(traverse(node.right, ele)){
                node.right = new TreeNode(ele);
            }
        }
        return false;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
