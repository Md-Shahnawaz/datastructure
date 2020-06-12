package com.leetcode.medium.tree;

public class KthSmallest {

    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);

//        five.left = three;
//        five.right = six;
        three.left = one;
        three.right = four;
        one.right = two;

        System.out.println(kthSmallest(three, 4));
    }

    private static int smallestEle = 0;
    public static int kthSmallest(TreeNode root, int k) {
        smallestEle = 0;
        recurse(root, k);
        return smallestEle;
    }

    private static int recurse(TreeNode root, int k) {

        if(root == null) {
            return k;
        }

        k = recurse(root.left, k);
        k = k - 1;
        if(k == 0) {
            smallestEle = root.val;
        }
        k = recurse(root.right, k);
        return k;
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
