package com.myaqa;

public class OperatorIf {

    public static void printColor() {
        int value = 1995;

        if (value <= 0) {
            System.out.println("Красный");
        } else if (value <= 100) {
            System.out.println("Жёлтый");
        } else {
            System.out.println("Зелёный");
        }
    }
}