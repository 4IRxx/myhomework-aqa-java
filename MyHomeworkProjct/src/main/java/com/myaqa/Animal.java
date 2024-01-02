package com.myaqa;

public class Animal {
    public static int counterAnimals = 0;

    public Animal() {
        counterAnimals++;
    }

    public static int getCountAnimals() {
        return counterAnimals;
    }

    public void run(int distance) {
        System.out.println("Животное пробежало " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println("Животное проплыло " + distance + " м.");
    }

}
