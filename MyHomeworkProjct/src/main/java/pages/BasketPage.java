package pages;

import elements.BasketCard;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BasketPage {
    private WebDriver driver;
    private WebDriverWait wait;

    private final By ITEM_NAME = By.cssSelector("span.good-info__good-name");
    private final By ITEM_DISCOUNT_PRICE = By.cssSelector("div.list-item__price-new");
    private final By ITEM_PRICE = By.cssSelector("div.list-item__price-old");
    private final By BASKET_CARDS = By.cssSelector("div.list-item__wrap");
    private final By SIDEBAR = By.cssSelector("div.sidebar__sticky-wrap");


    public BasketPage (WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    public List<WebElement> getAllBasketCards() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(BASKET_CARDS));
        return driver.findElements(BASKET_CARDS);
    }

    public ArrayList<BasketCard> createBasketItemList() {
        List<WebElement> list = getAllBasketCards();
        ArrayList<BasketCard> basketCardsList = new ArrayList<>();

        for (WebElement e: list) {
            basketCardsList.add(new BasketCard(e.findElement(ITEM_NAME).getText(), e.findElement(ITEM_DISCOUNT_PRICE).getText(), e.findElement(ITEM_PRICE).getText()));
        }

        Collections.sort(basketCardsList);
        return basketCardsList;
    }

    public BasketSidebar getBasketSidebar() {
        WebElement bar = wait.until(ExpectedConditions.visibilityOfElementLocated(SIDEBAR));
        return new BasketSidebar(bar);
    }

    public int getSum(List<BasketCard> list) {
        int sum = 0;

        for (BasketCard c: list) {
            String str = c.getLOWER_PRICE();
            String format = str.replaceAll("[^0-9]", "");
            int price = Integer.parseInt(format);
            sum += price;
        }
        return sum;
    }

    public class BasketSidebar {
        private WebElement basketSidebar;
        private final By TOP = By.cssSelector("div[class*='b-top__count line']");

        public BasketSidebar(WebElement basketSidebar) {
            this.basketSidebar = basketSidebar;
        }

        public int getAmount() {
            String text = this.basketSidebar.findElement(TOP).getText();
            String[] lines = text.split("\\n");
            String quantityLine = lines[0];
            String priceLine = lines[1];

            return Integer.parseInt(quantityLine.replaceAll("\\D+", ""));
        }

        public int getSum() {
            String text = this.basketSidebar.findElement(TOP).getText();
            String[] lines = text.split("\\n");
            String quantityLine = lines[0];
            String priceLine = lines[1];


            String price = priceLine.replaceAll("\\D+", "");
            return Integer.parseInt(price);
        }
    }
}
