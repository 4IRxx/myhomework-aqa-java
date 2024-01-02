package com.myaqa;

public class Main {
    public static void main(String[] args) {
        Cat[] myCats = new Cat[3];
        for (int i = 0; i < myCats.length; i++) {
            myCats[i] = new Cat();
        }

        Bowl myBowl = new Bowl(15);

        for (Cat cat : myCats) {
            cat.eat(myBowl.getFoodAmount());
        }

        System.out.println("Кот сыт?");
        for (Cat cat : myCats) {
            System.out.println("Кот " + cat.isFull());
        }

        myBowl.addFood(10);

        Circle myCircle = new Circle(9, "Красный", "Белый");
        myCircle.displayInfo();

        Rectangle myRectangle = new Rectangle(5, 3, "Зеленый", "Жёлтый");
        myRectangle.displayInfo();

        Triangle myTriangle = new Triangle (3.5, 3.2, 2, "Красный", "Чёрный");
        myTriangle.displayInfo();
    }
}