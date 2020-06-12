package com.leetcode.hard.array;

public class Median2SortedArray {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1,2}, new int[]{3,4}));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int n = nums1.length;
        int m = nums2.length;
        int total = n + m;
        boolean isEven = total % 2 == 0;
        int mid  = total / 2;
        int[] temp = new int[total];

        int i = 0, j = 0, k = 0;

        while(i < n && j < m){

            int ele1 = nums1[i];
            int ele2 = nums2[j];

            if(ele1 < ele2) {
                temp[k] = ele1;
                i ++;
            }else {
                temp[k] = ele2;
                j ++;
            }
            k++;
        }

        while(i < n) {

            temp[k] = nums1[i];
            i++;
            k++;
        }

        while(j < m) {

            temp[k] = nums2[j];
            j++;
            k++;
        }

        return isEven ? ((double) (temp[mid-1] + temp[mid]))/2 : temp[mid];

    }
}
