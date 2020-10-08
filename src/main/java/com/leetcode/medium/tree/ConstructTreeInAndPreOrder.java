package com.leetcode.medium.tree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeInAndPreOrder {

    public static void main(String[] args) {
//        buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        buildTree(new int[]{1,2,3}, new int[]{2,3,1});
    }

    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        Map<Integer, Integer> inMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++) {
            inMap.put(inorder[i], i);
        }
        return build(preorder, 0, 0, preorder.length - 1, inMap);
    }

    private static TreeNode build(int[] preorder, int root, int start, int end, Map<Integer, Integer> inMap) {

        if(start > end) return null;

        int val = preorder[root];
        int mid = inMap.get(val);

        TreeNode node = new TreeNode(val);
        root++;

        node.left = build(preorder, root, start, mid - 1, inMap);
        node.right = build(preorder, root + (end - start), mid + 1, end, inMap);

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
