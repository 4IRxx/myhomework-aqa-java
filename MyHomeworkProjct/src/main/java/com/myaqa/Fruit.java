package com.myaqa;

public abstract class Fruit {
    private String name;
    private int weight;

    public Fruit (String name, int weight) {
        this.name = name;
        this.weight = weight;
    }

    public String getName() {
        return name;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return this.name + " (" + this.weight + " кг)";
    }

}