package com.myaqa;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Задание 1-5:
        System.out.println("Сумма лежит в нужном пределе: " + ReturnMethods.isSumInRange(10,10));
        VoidMethod.checkPositiveNumber(1);
        System.out.println("Это отрицательное число: " + ReturnMethods.isNegativeNumber(-10));
        VoidMethod.printStringNtimes("I love Java", 3);
        System.out.println("Это високосный год: " + ReturnMethods.isLeapYear(2020));
        // Задание 6-10:
        int[] binaryArray = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        VoidArrays.invertArray(binaryArray);
        System.out.println("Инвертированный массив: " + Arrays.toString(binaryArray));

        System.out.println("Массив от 1 до 100: " + Arrays.toString(ReturnArrays.fillArray(100)));

        int[] numbersArray = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        VoidArrays.multiplyLessSix(numbersArray);
        System.out.println("Всё что <6 * 2: " + Arrays.toString(numbersArray));

        int[][] diagonalMatrix = new int[5][5];
        VoidArrays.fillDiagonalWithOnes(diagonalMatrix);
        System.out.println("Заполненый массив 1 по диогонали: " + Arrays.deepToString(diagonalMatrix));

        System.out.println("Каждая ячейка равна initialValue:  " + Arrays.toString(ReturnArrays.createArray(6, 9)));
    }
}