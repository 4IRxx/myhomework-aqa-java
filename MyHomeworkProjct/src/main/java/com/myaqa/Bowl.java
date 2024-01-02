package com.myaqa;

public class Bowl {
    private int foodAmount;

    public Bowl(int foodAmount) {
        this.foodAmount = (foodAmount > 0) ? foodAmount : 0;
    }

    public int getFoodAmount() {
        return foodAmount;
    }

    public void addFood(int amount) {
        if (amount > 0) {
            foodAmount += amount;
            System.out.println("Добавлено " + amount + " еды в миску.");
        } else {
            System.out.println("Неправильное количество еды.");
        }
    }
}
