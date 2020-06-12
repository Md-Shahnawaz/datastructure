package com.hackerrank.array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class QuickSort {

    public static void main(String[] args) {
        int[] array  = new int[]{2, 3, 4, 1, 5};
        sort(array, new Frame(0, array.length - 1));
        System.out.println(Arrays.toString(array));
    }

    private static void sort(int[] array, Frame frame) {

        Deque<Frame> stackFrame = new LinkedList<>();
        stackFrame.addFirst(frame);
        while(stackFrame.size() > 0){

            Frame s1 = stackFrame.pollFirst();
            int start = s1.start;
            int end = s1.end;

            if(start >= end){
                continue;
            }

            int pivot = partition(array, start, end);
            stackFrame.addFirst(new Frame(pivot + 1, end));
            stackFrame.addFirst(new Frame(start, pivot));
        }
    }

    private static int partition(int[] array, int start, int end) {

        int mid = start + ((end - start)/2);
        int pivot = array[mid];
        swap(array, mid, end);
        int i = start, j = start;
        while (i < end){
            if(array[i] < pivot) {
                swap(array, i, j);
                j++;
            }
            i++;
        }
        swap(array, j, end);
        return j;
    }

    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }

    private static class Frame {
        int start;
        int end;

        public Frame(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
}
