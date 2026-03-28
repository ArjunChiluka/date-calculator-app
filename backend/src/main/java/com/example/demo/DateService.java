package com.example.demo;

public class DateService {

    public static int calculateDaysBetween(String d1, String d2) {
        int total1 = convertToDays(d1);
        int total2 = convertToDays(d2);
        return Math.abs(total2 - total1);
    }

    private static int convertToDays(String date) {
        String[] parts = date.split("/");
        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]);
        int year = Integer.parseInt(parts[2]);

        int days = day;

        for (int i = 0; i < month - 1; i++) {
            days += getDaysInMonth(i + 1, year);
        }

        for (int i = 0; i < year; i++) {
            days += isLeap(i) ? 366 : 365;
        }

        return days;
    }

    private static int getDaysInMonth(int month, int year) {
        int[] days = {31,28,31,30,31,30,31,31,30,31,30,31};
        if (month == 2 && isLeap(year)) return 29;
        return days[month - 1];
    }

    private static boolean isLeap(int year) {
        return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0;
    }
}
