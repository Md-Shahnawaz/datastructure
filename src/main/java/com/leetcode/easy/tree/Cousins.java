package com.leetcode.easy.tree;

public class Cousins {

    private int xDepth = Integer.MIN_VALUE;
    private int yDepth = Integer.MIN_VALUE;
    private TreeNode xGrandParent;
    private TreeNode yGrandParent;
    private TreeNode xParent;
    private TreeNode yParent;

    public static void main(String[] args) {
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        one.left = two;
        one.right = three;
        three.left = four;
        three.right = five;

        System.out.println(new Cousins().isCousins(one, 4,5));
    }

    public boolean isCousins(TreeNode root, int x, int y) {

        xDepth = Integer.MIN_VALUE;
        yDepth = Integer.MIN_VALUE;
        xGrandParent = null;
        yGrandParent = null;
        xParent = null;
        yParent = null;
        dfs(root, x, y,0);
        return xDepth != Integer.MIN_VALUE && yDepth != Integer.MIN_VALUE
            && xGrandParent != null && yGrandParent != null
            && xParent != null && yParent != null && xParent.val != yParent.val
            && xDepth == yDepth && xGrandParent.val == yGrandParent.val;
    }

    private void dfs(TreeNode node, int x, int y, int depth){

        if(node == null) {
            return;
        }

        if(node.val == x) {
            xDepth = depth;
            return;
        }

        if(node.val == y){
            yDepth = depth;
            return;
        }

        dfs(node.left, x, y,depth + 1);
        dfs(node.right, x, y, depth + 1);

        if(xDepth != Integer.MIN_VALUE && xParent == null && depth == xDepth - 1) {
            xParent = node;
        }

        if(xDepth != Integer.MIN_VALUE && depth == xDepth - 2) {
            xGrandParent = node;
        }

        if(yDepth != Integer.MIN_VALUE && yParent == null && depth == yDepth - 1) {
            yParent = node;
        }

        if(yDepth != Integer.MIN_VALUE && depth == yDepth - 2) {
            yGrandParent = node;
        }

    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
