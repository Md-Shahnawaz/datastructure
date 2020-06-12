package com.leetcode.easy.tree;

public class RangeSumOfBST {

    int sum;
    boolean record;

    public static void main(String[] args) {

        TreeNode ten = new TreeNode(10);
        TreeNode five = new TreeNode(5);
        TreeNode fifteen = new TreeNode(15);
        TreeNode three = new TreeNode(3);
        TreeNode seven = new TreeNode(7);
        TreeNode eighteen = new TreeNode(18);
        TreeNode thirteen = new TreeNode(13);
        TreeNode six = new TreeNode(6);
        TreeNode one = new TreeNode(1);

        ten.left = five;
        ten.right = fifteen;

        five.left =three;
        five.right = seven;

        fifteen.right = eighteen;
        fifteen.left = thirteen;

        seven.left = six;
        three.left = one;

        System.out.println(new RangeSumOfBST().rangeSumBST(ten, 6, 10));
    }

    public int rangeSumBST(TreeNode root, int L, int R) {

        if (root == null || (sum > 0 && !record)) {
            return 0;
        }

        rangeSumBST(root.left, L, R);

        if (root.val == L) {
            record = true;
        }

        if (record) {
            sum += root.val;
        }

        if (root.val == R) {
            record = false;
        }

        rangeSumBST(root.right, L, R);

        return sum;
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
