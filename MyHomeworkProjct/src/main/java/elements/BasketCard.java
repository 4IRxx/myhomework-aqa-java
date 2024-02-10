package elements;

import java.util.ArrayList;

public class BasketCard implements Comparable<BasketCard> {
    private final String name;
    private String lowerPrice;
    private String price;

    public BasketCard (String name, String lowerPrice, String price) {
        this.name = name;
        this.lowerPrice = lowerPrice;
        this.price = price;
    }

    public String getName() {
        return this.name;
    }

    public String getLowerPrice() {
        return this.lowerPrice;
    }

    public String getPrice() {
        return this.price;
    }

    @Override
    public String toString() {
        return this.name + "\nЦена со скидкой: " + this.lowerPrice + " \nЦена без скидки: " + this.price;
    }

    @Override
    public int compareTo(BasketCard o) {
        return this.name.compareTo(o.getName());
    }
}

