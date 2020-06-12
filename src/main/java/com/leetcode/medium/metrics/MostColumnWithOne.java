package com.leetcode.medium.metrics;

import java.util.List;

public class MostColumnWithOne {

    public static void main(String[] args) {

    }

    public int leftMostColumnWithOne(BinaryMatrix binaryMatrix) {
        List<Integer> dim = binaryMatrix.dimensions();
        int n = dim.get(0);
        int m = dim.get(1);

        int i = 0, j = m - 1;
        int result = -1;

        while(i < n){
            while( j >= 0 && binaryMatrix.get(i, j) == 1){
                result = j;
                j--;
            }
            i++;
        }
        return result;
    }

    interface BinaryMatrix {
        int get(int row, int col);
        List<Integer> dimensions();
    }


}
