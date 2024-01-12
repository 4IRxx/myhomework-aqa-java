package com.myaqa;
import java.util.ArrayList;
public class PhoneDirectory {
    private ArrayList<Contact> phoneBook;

    public PhoneDirectory() {
        this.phoneBook = new ArrayList<>();
    }

    public void add(Contact number) {
        this.phoneBook.add(number);

    }

    public void get(String sureName) {
        boolean found = false;
        for (Contact value: this.phoneBook) {
            if (sureName.equals(value.getSureName())) {
                System.out.println(value.getNumber());
                found = true;
            }
        }
        if (!found) {
            System.out.println("Такой фамилии нет в телефонной книжке.");
        }
    }
    public void print() {
        for (Contact value: this.phoneBook) {
            System.out.println(value);
        }
    }

}
