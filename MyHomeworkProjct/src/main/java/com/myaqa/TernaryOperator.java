package com.myaqa;

public class TernaryOperator {

    public static void checkSumSign() {
        int a = 6;
        int b = 9;

        System.out.println(a + b >= 0 ? "Сумма положительная" : "Сумма отрицательная");
    }

    public static void compareNumbers() {
        int a = 10;
        int b = 9;

        System.out.println(a >= b ? "a >= b" : "a < b");
    }
}