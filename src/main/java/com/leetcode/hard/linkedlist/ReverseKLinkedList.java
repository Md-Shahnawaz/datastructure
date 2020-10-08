package com.leetcode.hard.linkedlist;

public class ReverseKLinkedList {

    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        reverseKGroup(head, 2);

        System.out.println(Integer.toBinaryString(16));
        System.out.println(Integer.toBinaryString(26));
        System.out.println(Integer.toBinaryString(10));
    }


    public static ListNode reverseKGroup(ListNode head, int k) {

        ListNode node = head, start = head, result = null, prevEnd = null;
        while(node != null) {

            for(int i = 1; i < k && node != null; i++) {
                node = node.next;
            }

            if(node == null) continue;

            ListNode next = node.next;
            node.next = null;
            ListNode end = reverse(start);

            if(result == null) {
                result = node;
            } else {
                prevEnd.next = node;
            }
            prevEnd = end;
            node = next;
            start = next;
        }

        return result;
    }

    private void toString(ListNode node){
        while(node != null){
            System.out.println(node.val);
            node = node.next;
        }
    }

    private static ListNode reverse(ListNode node) {

        if(node.next == null) return node;
        ListNode tmp = node;
        ListNode rev = reverse(node.next);
        tmp.next = null;
        rev.next = tmp;
        return tmp;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
