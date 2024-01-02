package com.myaqa;

public class Cat extends Animal{
    private static int counterCats = 0;
    private boolean fullness;

    public Cat() {
        counterCats++;
        fullness = false;
    }

    public static int getCountCats() {
        return counterCats;
    }

    public boolean isFull() {
        return fullness;
    }

    public void run(int distance) {
        if (distance <= 200) {
            System.out.println("Кот пробежал " + distance + " м.");
        } else {
            System.out.println("Кот не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println("Кот не умеет плавать.");
    }

    public void eat(int amount) {
        if (amount > 0) {
            System.out.println("Кот поел из миски.");
            fullness = true;
        } else {
            System.out.println("Миска пуста, кот не может поесть.");
        }
    }
}
