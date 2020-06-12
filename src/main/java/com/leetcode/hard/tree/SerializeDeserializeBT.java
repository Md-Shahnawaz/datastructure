package com.leetcode.hard.tree;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class SerializeDeserializeBT {

    public static void main(String[] args) {

        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode six = new TreeNode(6);
        TreeNode seven = new TreeNode(7);
        TreeNode nine = new TreeNode(9);

        four.left = two;
//        four.right = seven;
        two.left = one;
        two.right = three;
        seven.left = six;
        seven.right = nine;
        String serial = serialize(four);
        System.out.println(serial);
        TreeNode root = deserialize(serial);
    }

    public static String serialize(TreeNode root) {
        if(root == null) return "null";
        StringBuilder sb = new StringBuilder();
        serialTraverse(root, sb);
        sb.delete(sb.length() - 1, sb.length());
        return sb.toString();
    }

    public static TreeNode deserialize(String data) {
        String[] token = data.split(",");
        if(token[0].equals("null")){
            return null;
        }
        Queue<String> queue = new LinkedList<>();
        Collections.addAll(queue, token);
        return deSerialTraverse(queue);
    }

    private static void serialTraverse(TreeNode node, StringBuilder container){

        if(node == null){
            container.append("null");
            container.append(",");
            return;
        }

        container.append(node.val);
        container.append(",");
        serialTraverse(node.left, container);
        serialTraverse(node.right, container);
    }

    private static TreeNode deSerialTraverse(Queue<String> queue){

        if(queue.isEmpty()) {
            return null;
        }

        String ele = queue.poll();
        if(ele.equals("null")){
            return null;
        }

        TreeNode node = new TreeNode(Integer.parseInt(ele));
        node.left = deSerialTraverse(queue);
        node.right = deSerialTraverse(queue);
        return node;
    }

    private static class TreeNode {
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

        @Override
        public String toString() {
            return ""+val;
        }
    }
}
