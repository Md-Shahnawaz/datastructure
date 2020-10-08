package com.leetcode.medium.linklist;

public class RemoveDuplicates {

    public static void main(String[] args) {
        ListNode node = new ListNode(1);
        node.next = new ListNode(2);
        node.next.next = new ListNode(3);
        node.next.next.next = new ListNode(3);
        node.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next = new ListNode(4);
        node.next.next.next.next.next.next = new ListNode(5);

        System.out.println(deleteDuplicates(node));
    }

    public static ListNode deleteDuplicates(ListNode head) {

        ListNode node = eliminateDuplicates(head); head = node;
        while(node != null) {
            node = node.next;
            node.next = eliminateDuplicates(node);
        }
        return head;
    }

    private static ListNode eliminateDuplicates(ListNode head) {
        boolean isStartRepeating = false;
        while(head != null && head.next != null && head.val == head.next.val) {
            head = head.next;
            isStartRepeating = true;
        }
        return isStartRepeating && head!=null ? head.next : head;
    }

    public static class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
