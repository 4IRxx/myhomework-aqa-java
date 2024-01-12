package com.myaqa;

public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "a", "11", "12"},
                {"13", "14", "15", "16"}
        };

        try {
            int result = sumOfArray(array);
            System.out.println("Сумма элементов массива: " + result);
        } catch (MyArraySizeException e) {
            System.out.println("Ошибка размера массива: " + e.getMessage());
            System.out.println("Необходимый размер массива: " + e.getExpectedRows() + "x" + e.getExpectedColumns());
        } catch (MyArrayDataException e) {
            System.out.println("Ошибка данных в массиве: " + e.getMessage());
            System.out.println("Для устранения ошибки измените тип данных в ячейке [" + e.getRowIndex() + "][" + e.getColumnIndex() + "]");
        }
    }

    public static int sumOfArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        int rows = array.length;
        int columns = array[0].length;

        if (rows != 4 || columns != 4) {
            throw new MyArraySizeException("Размер массива должен быть 4x4", 4, 4);
        }

        int sum = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException("Неверные данные в ячейке [" + i + "][" + j + "]", i, j);
                }
            }
        }

        return sum;
    }
}