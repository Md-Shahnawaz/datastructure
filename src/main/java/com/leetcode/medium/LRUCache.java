package com.leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private int capacity;
    private Map<Integer, Node> map;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        cache.put(2, 1);
        cache.put(1, 1);
        cache.put(2, 3);
        cache.put(4, 1);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));

    }

    public int get(int key) {

        if (map.containsKey(key)) {

            Node node = map.get(key);
            Node prev = node.prev;
            Node next = node.next;

            if (prev == null && next == null) {
                return node.value;
            }

            if (next == null) {
                tail = prev;
            }

            if (prev == null) {
                return node.value;
            }

            if (next != null) {
                next.prev = prev;
            }
            prev.next = next;
            node.prev = null;
            node.next = head;
            head.prev = node;
            head = node;
            return node.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

        if(map.containsKey(key)) {
            get(key);
            map.get(key).value = value;
            return;
        }

        Node node = new Node(key, value);

        if (map.size() == capacity) {
            Node prev = tail.prev;
            map.remove(tail.key);
            if (prev != null) {
                prev.next = null;
                tail.prev = null;
            } else {
                head = null;
                tail = null;
            }
            tail = prev;
        }

        map.put(key, node);
        if (head == null && tail == null) {
            head = node;
            tail = node;
            return;
        }

        node.next = head;
        head.prev = node;
        head = node;
    }

    private static class Node {

        private int key;
        private int value;
        private Node next;
        private Node prev;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
}
