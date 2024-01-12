package com.myaqa;

public class MyArrayDataException extends Exception {
    private int rowIndex;
    private int columnIndex;
    public MyArrayDataException(String message, int row, int column) {
        super(message);
        this.rowIndex = row;
        this.columnIndex = column;
    }

    public int getRowIndex() {
        return rowIndex;
    }

    public int getColumnIndex() {
        return columnIndex;
    }



}
