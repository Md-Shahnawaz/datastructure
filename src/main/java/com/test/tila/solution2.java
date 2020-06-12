package com.test.tila;

import java.util.Calendar;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.TimeZone;

public class solution2 {

    public static void main(String[] args) {

//        List<String> input = new LinkedList<>();
//        Scanner sc = new Scanner(System.in);
//        int t = sc.nextInt();
//        sc.nextLine();
//        for (int n = 0; n < t; n++) {
//            String value = sc.nextLine();
//            input.add(value);
//        }
//        System.out.println(input);
//        solution(input);

    }

    private static void solution(List<String> input) {

        for (String inStr : input) {
            String[] strCord = inStr.trim().split(":");

            int seconds = Integer.parseInt(strCord[2]);
            int minutes = Integer.parseInt(strCord[1]);
            int hours = Integer.parseInt(strCord[0]);

            if (seconds > 60 || minutes > 60 || hours > 24) {
                System.out.println("INVALID");
                continue;
            }

            int nextBigSecond = nextBiggerTime(seconds, 60);
            if (nextBigSecond != -1) {
                System.out.println(strCord[0] + ":" + strCord[1] + ":" + nextBigSecond);
                continue;
            }
            int nextBigMin = nextBiggerTime(minutes, 60);
            if (nextBigMin != -1) {
                System.out.println(strCord[0] + ":" + nextBigMin + ":" + strCord[2]);
                continue;
            }
            int nextBigHour = nextBiggerTime(hours, 24);
            if (nextBigHour != -1) {
                System.out.println(nextBigHour + ":" + strCord[1] + ":" + strCord[2]);
                continue;
            }

            int b_second = bigger(seconds);
            int b_minute = bigger(minutes);

            int rep_second = replace(b_minute, seconds);
            int rep_minute = replace(b_second, minutes);

            if (rep_second < 60 && rep_minute < 60) {
                System.out.println(nextBigHour + ":" + (rep_minute < 10 ? "0" + rep_minute : rep_minute) + ":" + (
                    rep_second < 10 ?
                        "0" + rep_second :
                        rep_second));
                continue;
            }

            b_second = bigger(seconds);
            int b_hour = bigger(hours);

            rep_second = replace(b_hour, seconds);
            int rep_hour = replace(b_second, hours);
            if (rep_second < 60 && rep_hour < 24) {
                System.out.println((rep_hour < 10 ? "0" + rep_hour : rep_hour) + ":" + nextBigMin + ":" + (rep_second
                    < 10 ? "0" + rep_second : rep_second));
                continue;
            }

            b_minute = bigger(minutes);
            b_hour = bigger(hours);

            rep_minute = replace(b_hour, minutes);
            rep_hour = replace(b_minute, hours);
            if (rep_second < 60 && rep_hour < 24) {
                System.out.println((rep_hour < 10 ? "0" + rep_hour : rep_hour) + ":" + (rep_minute < 10 ?
                    "0" + rep_minute :
                    rep_minute) + ":" + nextBigSecond);
            }
        }
    }

    private static int nextBiggerTime(int time, int type) {

        int result = -1;
        int first = time % 10;
        int second = Math.floorDiv(time, 10);

        int number = first * 10 + second;

        if (number < type && number > time) {
            result = number;
        }
        return result;
    }

    private static int replace(int b_minute, int time) {
        int first = time % 10;

        int second = Math.floorDiv(time, 10);
        if (time < 10) {
            second = 0;
        }

        int n1 = b_minute * 10 + first;
        int n2 = second * 10 + b_minute;
        return n2<n1?n2:n1;
    }

    private static int bigger(int time) {
        int first = time % 10;
        int second = Math.floorDiv(time, 10);
        return first > second ? first : second;
    }
}
