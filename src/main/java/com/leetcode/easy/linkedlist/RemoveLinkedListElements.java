package com.leetcode.easy.linkedlist;

public class RemoveLinkedListElements {

    public static void main(String[] args) {

        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(1);
        head.next.next.next.next = new ListNode(1);
        removeElements(head, 1);
    }
    public static ListNode removeElements(ListNode head, int val) {

        while(head != null && head.val == val){
            head = head.next;
        }
        ListNode tmp = head.next, prev = head, result = head;
        while(tmp != null) {

            if(tmp.val != val) {
                prev.next = tmp;
                prev = prev.next;
            }
            tmp = tmp.next;
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
