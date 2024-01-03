package com.myaqa;

public class Cat extends Animal{
    private static int counterCats = 0;
    private boolean fullness;

    public Cat(String name) {
        super(name);
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
            System.out.println(getName() + " пробежал " + distance + " м.");
        } else {
            System.out.println(getName() + " не может пробежать " + distance + " м.");
        }
    }

    @Override
    public void swim(int distance) {
        System.out.println(getName() + " не умеет плавать.");
    }

    public void eat(int amount) {
        if (amount > 0) {
            System.out.println(getName() + " поел из миски.");
            fullness = true;
                if (fullness == true) {
                    System.out.println(getName() + " сыт");
                }
        } else {
            System.out.println("Миска пуста, " + getName() + " не может поесть.");
        }
    }
}
