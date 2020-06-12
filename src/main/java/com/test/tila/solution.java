package com.test.tila;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class solution {

    public static void main(String[] args) {

//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        for (int n = 0; n < t; n++) {
//            int a = sc.nextInt();
//            List<String> input = new LinkedList<>();
//            sc.nextLine();
//            for (int m = 0; m < a; m++) {
//                String value = sc.nextLine();
//                input.add(value);
//            }
//            solution(input);
//        }
        List<String> input = new LinkedList<>();
        input.add("0 0");
        input.add("0 4");
        input.add("2 2");
        solution(input);
    }

    public static void solution(List<String> input){

        int i = 0, j =0;
        List<Pair> filledCoordinates = new ArrayList<>();
        for (String inStr : input) {
            String[] strCord = inStr.trim().split("\\s");
            int t1 = Integer.parseInt(strCord[0]);
            int t2 = Integer.parseInt(strCord[1]);
            filledCoordinates.add(new Pair(t1, t2));
            if(i < t1) {
                i = t1;
            }
            if(j < t2){
                j = t2;
            }
        }

        int minDistance = Integer.MAX_VALUE;
        int totalMinCord = 0;
        for (int k = 0; k < i; k++) {
            for (int l = 0; l < j; l++) {
                int distance = 0;
                for (Pair p: filledCoordinates) {
                    distance += Math.abs(p.x - k) + Math.abs(p.y - l);
                }
                if(minDistance > distance) {
                    minDistance = distance;
                    totalMinCord = 1;
                    continue;
                }
                if(minDistance == distance){
                    totalMinCord += 1;
                }
            }
        }

        System.out.println(minDistance + " " + totalMinCord);

    }

    private static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
