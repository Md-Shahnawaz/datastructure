package com.leetcode.medium.linklist;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

    public ListNode mergeKLists(ListNode[] lists) {

        ListNode result = null, interim = null;

        PriorityQueue<ListNode> pq = new PriorityQueue(Comparator.comparingInt((ListNode l) -> l.val));

        for(int i = 0; i < lists.length; i++) {
            if(lists[i] != null) {
                pq.offer(lists[i]);
            }
        }

        while(!pq.isEmpty()) {

            ListNode temp = pq.poll();
            if(result == null) {
                interim = temp;
                result = interim;
            } else {
                interim.next = temp;
                interim = interim.next;
            }
            if(temp.next == null) continue;
            pq.offer(temp.next);
        }

        return result;
    }
    private class ListNode {
        int val;
        ListNode next;
    }
}
