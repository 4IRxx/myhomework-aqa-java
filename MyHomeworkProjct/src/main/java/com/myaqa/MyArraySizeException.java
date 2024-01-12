package com.myaqa;

public class MyArraySizeException extends Exception {
    private int expectedRows;
    private int expectedColumns;

    public MyArraySizeException(String message, int rows, int columns) {
        super(message);
        this.expectedRows = rows;
        this.expectedColumns = columns;
    }

    public int getExpectedRows() {
        return expectedRows;
    }

    public int getExpectedColumns() {
        return expectedColumns;
    }
}
