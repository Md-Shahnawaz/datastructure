package com.leetcode.medium.linklist;

public class OddEvenLinkList {

    public static void main(String[] args) {

        ListNode head = new ListNode(2);
        head.next = new ListNode(1);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(6);
        head.next.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next.next = new ListNode(7);
        head = oddEvenList(head);
        while(head != null) {
            System.out.print(head.val + "->");
            head = head.next;
        }
        System.out.println();
    }

    public static ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode even = head, evenHead = even;
        ListNode odd = head.next, oddHead = odd;
        int count = 0;
        head = head.next.next;
        while(head != null) {
            if(count%2 == 0) {
                even.next = head;
                even = even.next;
            } else {
                odd.next = head;
                odd = odd.next;
            }
            head = head.next;
            count ++;
        }
        even.next = oddHead;
        odd.next = null;
        return evenHead;
    }


    private static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}
