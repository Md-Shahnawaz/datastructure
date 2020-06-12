package com.leetcode.medium.hashmap;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class LRUCache {

    private Node first;
    private Node last;
    private Map<Integer, Node> cache;
    private int size;

    public LRUCache(int capacity) {
        this.size = capacity;
        cache = new HashMap<>();
    }

    public int get(int key) {
        Node value = cache.get(new Node(key));
        if(Objects.nonNull(value)) {

            value.previous.next = value.next;
            value.next = first;
            first = value;
            return value.value;
        } else {
            return -1;
        }
    }

    public void put(int key, int value) {

        if(cache.size() == 0){
            first = new Node(value);
            last = first;
            cache.put(key, first);
        } else {


        }
    }

    public static class Node {
        Node next;
        Node previous;
        int value;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Node node = (Node) o;
            return value == node.value;
        }

        @Override public int hashCode() {
            return Objects.hash(value);
        }
    }
}
