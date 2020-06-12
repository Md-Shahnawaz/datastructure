package com.leetcode.easy;

public class DiameterOfBinaryTree {

    private int diameter;

    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode eight  = new TreeNode(8);
        TreeNode nine = new TreeNode(9);
        TreeNode ten = new TreeNode(10);
        TreeNode eleven = new TreeNode(11);
        TreeNode twelve = new TreeNode(12);
        TreeNode thirteen = new TreeNode(13);
        TreeNode fourteen = new TreeNode(14);
        TreeNode fifteen = new TreeNode(15);
        TreeNode sixteen = new TreeNode(16);

        one.left = two;
        one.right = three;
        two.left = four;
        two.right = five;
        three.right = sixteen;
        four.left = six;
        five.right = seven;
        six.left = eight;
        six.right = nine;
        seven.right = ten;
        eight.left = eleven;
        nine.right = twelve;
        eleven.left = fourteen;
        eleven.right = fifteen;
        ten.right = thirteen;

        System.out.println(new DiameterOfBinaryTree().diameterOfBinaryTree(one));

    }

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode node){

        int l = 0, r = 0;

        if(node.left != null) {
            l += 1;
            l += dfs(node.left);
        }
        if(node.right != null) {
            r += 1;
            r += dfs(node.right);
        }
        diameter = Math.max(diameter, (l + r));
        return Math.max(l, r);
    }

    public static class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
  }
}
