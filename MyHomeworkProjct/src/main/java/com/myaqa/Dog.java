package com.myaqa;

public class Dog extends Animal {
    private static int counterDogs = 0;

    public Dog(String name) {
        super(name);
        counterDogs++;
    }

    public static int getCountDogs() {
        return counterDogs;
    }


    @Override
    public void run(int distance) {
        if (distance <= 500) {
            System.out.println(getName() + " пробежала " + distance + " м.");
        } else {
            System.out.println(getName() + " не может пробежать " + distance + " м.");
        }
    }


    @Override
    public void swim(int distance) {
        if (distance <= 10) {
            System.out.println(getName() + " проплыла " + distance + " м.");
        } else {
            System.out.println(getName() + " не может проплыть " + distance + " м.");
        }
    }
}
