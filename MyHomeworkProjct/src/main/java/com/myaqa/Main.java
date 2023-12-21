package com.myaqa;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Задание 1
        System.out.println("Сумма лежит в нужном пределе: " + ReturnMethods.isSumInRange(10,10));
        // Задание 2
        VoidMethod.checkPositiveNumber(1);
        // Задание 3
        System.out.println("Это отрицательное число: " + ReturnMethods.isPositiveNumber(10));
        // Задание 4
        VoidMethod.printStringNtimes("I love Java", 3);
        // Задание 5
        System.out.println("Это високосный год: " + ReturnMethods.isLeapYear(2020));

        // Задание 6
        int[] binaryArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        VoidArrays.invertArray(binaryArray);
        System.out.println("Инвертированный массив: " + Arrays.toString(binaryArray));
        // Задание 7
        System.out.println("Массив от 1 до 100: " + Arrays.toString(ReturnArrays.fillArray(100)));
        // Задание 8
        int[] numbersArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        VoidArrays.multiplyLessSix(numbersArray);
        System.out.println("Всё что <6 * 2: " + Arrays.toString(numbersArray));
        // Задание 9
        int[][] diagonalMatrix = new int[5][5];
        VoidArrays.fillDiagonalWithOnes(diagonalMatrix);
        System.out.println("Заполненый массив 1 по диогонали: " + Arrays.deepToString(diagonalMatrix));
        // Задание 10
        System.out.println("Task 10: " + Arrays.toString(ReturnArrays.createArray(6, 9)));
    }
}