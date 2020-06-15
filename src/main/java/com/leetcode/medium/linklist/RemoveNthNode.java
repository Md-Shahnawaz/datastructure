package com.leetcode.medium.linklist;

public class RemoveNthNode {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4,new ListNode(5)))));
        removeNthFromEnd(n1, 2);
    }

    public static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode nNode = null, node = head, temp = head;
        while(node != null) {
            if(n > 0) {
                --n;
            } else {
                nNode = temp;
                temp = temp.next;
            }
            node = node.next;
        }
        if(nNode == null) {
            return null;
        }
        System.out.println(nNode.val);
        nNode.next = nNode.next.next;
        return head;
    }

    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
