package com.myaqa;

public class Main {
    public static void main(String[] args) {
        Apple apple1 = new Apple();
        Apple apple2 = new Apple();

        Orange orange1 = new Orange();
        Orange orange2 = new Orange();

        Box firstBox = new Box();
        Box secondBox = new Box();
        Box movingBox = new Box();

        firstBox.add(apple1);
        firstBox.add(apple2);
        firstBox.add(orange1);

        secondBox.add(orange1);
        secondBox.add(orange2);

        firstBox.moveFruitsTo(movingBox);
        secondBox.moveFruitsTo(movingBox);

        System.out.println(secondBox);
        System.out.println(movingBox);
    }
}