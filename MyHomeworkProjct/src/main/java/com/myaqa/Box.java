package com.myaqa;

import java.util.ArrayList;

public class Box {
    private ArrayList<Fruit> box;

    public Box() {
        this.box = new ArrayList<>();
    }

    public void add (Fruit fruit) {
        if (this.isTheSameFruits(fruit)) {
            this.box.add(fruit);
        } else {
            System.out.println("Вы не можете добавить " + fruit.getName() + " в коробку, в ней уже лежат другие фрукты!");
        }
    }

    public boolean isTheSameFruits(Fruit fruit) {
        if (fruit == null || this.box.isEmpty()) {
            return true;
        }

        Class<?> expectedType = fruit.getClass();
        for (Fruit f : this.box) {
            if (f.getClass() != expectedType) {
                return false;
            }
        }
        return true;
    }

    public int getWeight() {
        int totalWeight = 0;

        for (Fruit f: this.box) {
            totalWeight += f.getWeight();
        }
        return totalWeight;
    }

    public boolean compare(Box comparedBox) {
        return this.getWeight() == comparedBox.getWeight();
    }

    public void moveFruitsTo(Box destination) {
        if (this.isTheSameFruits(destination.box.isEmpty() ? null : destination.box.get(0))) {
            Box cloneBox = new Box();
            cloneBox.box.addAll(this.box);
            destination.box.addAll(cloneBox.box);
            this.box.clear();
        } else {
            System.out.println("Нельзя пересыпать фрукты, т.к. в коробке уже лежат другие фрукты!");
        }
    }

    public String toString() {
        return this.box.toString() + "\n Общий вес коробки: " + this.getWeight() + " кг.";
    }

}