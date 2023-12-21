package com.myaqa;

public class ReturnMethods {

    public static boolean isSumInRange(int a, int b) {
        int sum = a + b;
        return sum > 10 && sum <= 20;
    }

    public static boolean isNegativeNumber(int y) {
        return y < 0;
    }

    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

}
