package com.myaqa;

public class Dog extends Animal {
    private static int counterDogs = 0;

    public Dog() {
        counterDogs++;
    }

    public static int getCountDogs() {
        return counterDogs;
    }


    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println("Собака пробежала " + distance + " м.");
        } else {
            System.out.println("Собака не может пробежать " + distance + " м.");
        }
    }


    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println("Собака проплыла " + distance + " м.");
        } else {
            System.out.println("Собака не может проплыть " + distance + " м.");
        }
    }
}
