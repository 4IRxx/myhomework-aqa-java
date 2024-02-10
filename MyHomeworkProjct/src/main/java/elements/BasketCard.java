package elements;

public class BasketCard implements Comparable<BasketCard> {
    private final String NAME;
    private final String LOWER_PRICE;
    private final String PRICE;

    public BasketCard (String name, String lowerPrice, String price) {
        this.NAME = name;
        this.LOWER_PRICE = lowerPrice;
        this.PRICE = price;
    }

    public String getNAME() {
        return this.NAME;
    }

    public String getLOWER_PRICE() {
        return this.LOWER_PRICE;
    }

    public String getPRICE() {
        return this.PRICE;
    }

    @Override
    public String toString() {
        return this.NAME + "\nЦена со скидкой: " + this.LOWER_PRICE + " \nЦена без скидки: " + this.PRICE;
    }

    @Override
    public int compareTo(BasketCard o) {
        return this.NAME.compareTo(o.getNAME());
    }
}

