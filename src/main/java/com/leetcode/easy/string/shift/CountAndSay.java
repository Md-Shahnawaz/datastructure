package com.leetcode.easy.string.shift;

import java.util.Deque;
import java.util.LinkedList;

public class CountAndSay {

    public static void main(String[] args) {
        System.out.println(new CountAndSay().countAndSay(5));
    }
    public String countAndSay(int n) {
        Deque<Integer> stack1 = new LinkedList<>();
        Deque<Integer> stack2 = new LinkedList<>();
        stack1.offer(1);

        for (int i = 1; i < n; i++) {

            int count = 0, prev = stack1.peek();
            while (!stack1.isEmpty()) {

                Integer i1 = stack1.poll();
                if (i1 == prev) {
                    count++;
                    continue;
                }

                stack2.offer(count);
                stack2.offer(prev);
                prev = i1;
                count = 1;
            }

            stack2.offer(count);
            stack2.offer(prev);

            Deque<Integer> temp = stack2;
            stack2 = stack1;
            stack1 = temp;
        }

        StringBuilder builder = new StringBuilder();
        while (!stack1.isEmpty()) {
            builder.append(stack1.poll());
        }

        return builder.toString();
    }
}
