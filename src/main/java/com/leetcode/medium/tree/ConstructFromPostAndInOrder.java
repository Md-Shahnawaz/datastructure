package com.leetcode.medium.tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class ConstructFromPostAndInOrder {

    public static void main(String[] args) {
        //[9,3,15,20]
        //[9,15,20,3]
        TreeNode node = buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }

    public static TreeNode buildTree(int[] inorder, int[] postorder) {

        if (inorder == null || inorder.length == 0) return null;
        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        //build Tree
        return buildTree(postorder,0, 0, inorder.length - 1, inMap);
    }

    private static TreeNode buildTree(int[] post, int rootIndex,int in_start, int in_end, Map<Integer, Integer> inMap) {

        if(in_start > in_end) return null;

        int val = post[rootIndex];
        TreeNode node = new TreeNode(val);
        int mid = inMap.get(val);
        rootIndex--;

        node.right = buildTree(post, rootIndex, mid + 1, in_end, inMap);
        node.left = buildTree(post, rootIndex, rootIndex - (in_end - mid), mid - 1, inMap);

        return node;
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
