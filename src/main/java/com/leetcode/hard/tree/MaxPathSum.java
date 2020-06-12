package com.leetcode.hard.tree;

public class MaxPathSum {

    private static int max = Integer.MIN_VALUE;

    public static void main(String[] args) {
        TreeNode mTen = new TreeNode(1);
//        TreeNode twenty = new TreeNode(20);
        TreeNode nine = new TreeNode(-2);
        TreeNode fifteen = new TreeNode(3);
//        TreeNode seven = new TreeNode(7);

        mTen.left = nine;
        mTen.right = fifteen;
//        twenty.left = fifteen;
//        twenty.right = seven;
        System.out.println(maxPathSum(mTen));

    }

    public static int maxPathSum(TreeNode root) {
        if(root.left != null || root.right != null){
            max = Math.max(dfs(root), max);
        } else {
            max = root.val;
        }
       return max;
    }

    private static int dfs(TreeNode root){
        if(root == null){
            return 0;
        }
        int l, r, c = root.val;
        if(root.left == null && root.right == null){
            return c;
        }

        if(root.left != null && root.right != null){
            l = dfs(root.left);
            r = dfs(root.right);
            max = Math.max(max, Math.max(l, Math.max(r, Math.max(c, l+r+c))));
            return Math.max(c, Math.max(l + c, r + c));
        } else if (root.left != null){
            l = dfs(root.left);
            max = Math.max(max, Math.max(l, Math.max(c, l+c)));
            return Math.max(l + c, c);
        } else {
            r = dfs(root.right);
            max = Math.max(max, Math.max(r, Math.max(c, r+c)));
            return Math.max(r + c, c);
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

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
