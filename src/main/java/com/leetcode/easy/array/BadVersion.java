package com.leetcode.easy.array;

public class BadVersion {

    private boolean isBadVersion(int version){
        return version == 3 || version == 4 ||  version == 5 || version == 6 || version == 7 || version == 8? true : false;
    }

    public static void main(String[] args) {
        System.out.println(new BadVersion().firstBadVersion(8));
    }

    public int firstBadVersion(int n) {
        return binarySearch(1, n);
    }

    private int binarySearch(int i, int j){

        if(j == i) return j;
        int mid = (j - i)/ 2 + i;
        return isBadVersion(mid) ? binarySearch(i, mid) : binarySearch(mid + 1, j);
    }
}
