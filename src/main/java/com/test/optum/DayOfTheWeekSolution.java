package com.test.optum;

import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class DayOfTheWeekSolution {

    public static void main(String[] args){
//        int[] a = new int[]{4, 2, 2, 4, 2};
        int[] a = new int[]{1,2 , 3, 2, 4};
        String input = "Sun 10:00-20:00\\nFri 05:00-10:00\\nFri 16:30-23:50\\nSat 10:00-24:00\\nSun 01:00-04:00\\nSat 02:00-06:00\\nTue 03:30-18:15\\nTue 19:00-20:00\\nWed 04:25-15:14\\nWed 15:14-22:40\\nThu 00:00-23:59\\nMon 05:00-13:00\\nMon 15:00-21:00";
        for (String meeting: input.replace("\\n","D").split("D")) {
            System.out.println(meeting);
        }
        System.out.println(solution(input));
    }

    private static int solution(String a) {

        List<String> list = new ArrayList<>();
        int result = 0;
        String[] days = a.replace("\\n","D").split("D");
        for (int i = 0; i < days.length; i++) {
            String current = days[i].substring(0, 3);
            DayOfTheWeek today = DayOfTheWeek.valueOf(current);
            DayOfTheWeek tomorrow = null;
            if(i < days.length - 1){
                String next = days[i + 1].substring(0, 3);
                tomorrow = DayOfTheWeek.valueOf(next);
            }
            if(tomorrow == null || (DayOfTheWeek.Mon.ordinal() <= today.ordinal() && today.ordinal() < DayOfTheWeek.Sun.ordinal())){
                list.add(days[i]);
            } else if(today == DayOfTheWeek.Sun) {
                list.add(days[i]);
            }
            if(tomorrow == null || tomorrow.ordinal() < today.ordinal()) {
                System.out.println(list);
                list.clear();
            }


        }

        NumberFormat.getCurrencyInstance(new Locale("en", "US"))
            .format(200);
        return result;
    }

    private enum DayOfTheWeek {

        Mon(1), Tue(2), Wed(3), Thu(4), Fri(5), Sat(6), Sun(7);
        private int dayInWeek;
        private static Map<Integer, DayOfTheWeek> dayCache = new HashMap<>();
        static {
            dayCache.putIfAbsent(1, Mon);
            dayCache.putIfAbsent(2, Tue);
            dayCache.putIfAbsent(3, Wed);
            dayCache.putIfAbsent(4, Thu);
            dayCache.putIfAbsent(5, Fri);
            dayCache.putIfAbsent(6, Sat);
            dayCache.putIfAbsent(7, Sun);
        }
        DayOfTheWeek(int dayInWeek){
            this.dayInWeek = dayInWeek;
        }

        public DayOfTheWeek getDayOfTheWeek(int dayInWeek){
            return dayCache.get(dayInWeek);
        }

        static int dayofweek(int d, int m, int y)
        {
            int t[] = { 0, 3, 2, 5, 0, 3, 5, 1, 4, 6, 2, 4 };
            y -= (m < 3) ? 1 : 0;
            return ( y + y/4 - y/100 + y/400 + t[m-1] + d) % 7;
        }
    }
}
