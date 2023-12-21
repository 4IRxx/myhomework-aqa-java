package com.myaqa;

public class VoidMethod {

    public static void checkPositiveNumber(int x) {
        System.out.println(x >= 0 ? "Положительное число" : "Отрицательное число");
    }

    public static void printStringNtimes (String ourString, int nTimes) {
        for (int i = 0; i < nTimes; i++) {
            System.out.println(ourString);
        }
    }
}
