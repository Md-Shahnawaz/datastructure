package com.test.grab;

public class DayOfTheWeek {

    public static void main(String[] args) {
        System.out.println(new DayOfTheWeek().solution("Sun", 147));
    }

    public String solution(String S, int k) {

      return DayOW.valueOf(S).plus(k).toString();
    }

    enum DayOW{

        Mon, Tue, Wed, Thu, Fri, Sat, Sun;

        private static final DayOW[] ENUMS = DayOW.values();

        public DayOW plus(long days) {
            int amount = (int) (days % 7);
            return ENUMS[(ordinal() + amount) % 7];
        }
    }
}
