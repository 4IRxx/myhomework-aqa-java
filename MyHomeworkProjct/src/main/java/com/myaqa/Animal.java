package com.myaqa;

public class Animal {
    public static int counterAnimals = 0;
    protected String name;

    public Animal(String name) {
        this.name = name;
        counterAnimals++;
    }
    public String getName() {
        return name;
    }
    public static int getCountAnimals() {
        return counterAnimals;
    }

    public void run(int distance) {
        System.out.println(name + " пробежало " + distance + " м.");
    }

    public void swim(int distance) {
        System.out.println(name + " проплыло " + distance + " м.");
    }

}
