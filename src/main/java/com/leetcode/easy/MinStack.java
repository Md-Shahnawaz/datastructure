package com.leetcode.easy;

import java.util.Objects;
import java.util.Stack;

public class MinStack {

    Stack<Pair<Integer, Integer>> st;
    /** initialize your data structure here. */
    public MinStack() {
        st = new Stack();
    }

    public void push(int x) {
        int curMin = st.empty() ? x : st.peek().getKey();
        st.push(new Pair(Math.min(curMin, x), x));
    }

    public void pop() {
        st.pop();
    }

    public int top() {
        return st.peek().getValue();
    }

    public int getMin() {
        return st.peek().getKey();
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }

    public static class Pair<T, K> {
        T i;
        K j;

        public Pair(T i, K j) {
            this.i = i;
            this.j = j;
        }

        public T getKey() {
            return i;
        }

        public K getValue() {
            return j;
        }

        @Override public String toString() {
            return "Pair{" + "i=" + i + ", j=" + j + '}';
        }

        @Override public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Pair<?, ?> pair = (Pair<?, ?>) o;
            return Objects.equals(i, pair.i) && Objects.equals(j, pair.j);
        }

        @Override public int hashCode() {
            return Objects.hash(i, j);
        }
    }

}
