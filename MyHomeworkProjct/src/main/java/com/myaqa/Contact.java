package com.myaqa;

public class Contact {
    private String sureName;
    private int number;

    public Contact(String sureName, int number) {
        this.sureName = sureName;
        this.number = number;
    }

    public String getSureName() {
        return this.sureName;
    }

    public int getNumber() {
        return this.number;
    }

    public String toString() {
        return "Фамилия: " + this.sureName + "\nНомер телефона: " + this.number;
    }
}
