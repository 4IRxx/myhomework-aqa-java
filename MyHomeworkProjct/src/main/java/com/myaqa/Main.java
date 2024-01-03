package com.myaqa;

public class Main {
    public static void main(String[] args) {
        Dog myDog = new Dog("Hachi");
        myDog.swim(5);

        Cat firstCat = new Cat("Garfield");
        firstCat.swim(5);
        Cat secondCat = new Cat("Ghost");
        secondCat.run(200);
        Cat thirdCat = new Cat("Summer");
        thirdCat.run(201);

        Cat[] myCats = new Cat[3];
        myCats[0] = firstCat;
        myCats[1] = secondCat;
        myCats[2] = thirdCat;

        Bowl myBowl = new Bowl(15);

        for (Cat cat : myCats) {
            cat.eat(myBowl.getFoodAmount());
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