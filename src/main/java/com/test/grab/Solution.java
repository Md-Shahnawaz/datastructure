package com.test.grab;

public class Solution {

    public static void main(String[] args) {
        int a[] = {1,1,1,0,1,0,1,0,1,0,1,1,0,1,1,1,1,0,1,0,1,1,0,0,0,0,0,1,0,1,0,1,0,0,0,0,0,0,0};
//        int a[] = {1,1,1,1,1};
        System.out.println(solution(a));
    }


    static int solution(int[] A) {
        int n = A.length;
        int result[] = {0, 0}, temp = 0;
        for(int i = 0; i < n - 1; i++){
            if(A[i] == A[i+1]) temp += 1;
            else temp = 0;
            result[A[i]] = Math.max(result[A[i]], temp);
        }
        int r = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            if (i > 0) {
                if (A[i - 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            if (i < n - 1) {
                if (A[i + 1] != A[i])
                    count = count + 1;
                else
                    count = count - 1;
            }
            r = Math.max(r, count);
        }
        return Math.max(result[0], result[1]) + r + 1;
    }
}
