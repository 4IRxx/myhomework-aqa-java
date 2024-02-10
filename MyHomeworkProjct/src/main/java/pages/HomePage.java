package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import elements.ItemCard;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final By BASKET_BUTTON = By.cssSelector("a[data-wba-header-name='Cart']");
    private final By POPUP_CONFIRM = By.cssSelector("div[class*='popup-list-of-sizes'] label");
    private final By POPUP_SIZE = By.cssSelector("p[class*='product-card__sizes']>a[data-size-name]");


    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public List<ItemCard> prepareItemsToCompare() {
        List<ItemInfo> itemInfoList = getItemList();
        addItemToBasket(itemInfoList);
        return createItemListToBasket(itemInfoList);
    }

    public List<ItemInfo> getItemList() {
        WebElement item1 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("article[data-card-index='2']")));
        WebElement item2 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("article[data-card-index='4']")));
        WebElement item3 = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("article[data-card-index='5']")));

        List<ItemInfo> itemInfoList = new ArrayList<>();
        itemInfoList.add(new ItemInfo(item1));
        itemInfoList.add(new ItemInfo(item2));
        itemInfoList.add(new ItemInfo(item3));

        return itemInfoList;
    }

    public void addItemToBasket(List<ItemInfo> list) {
        for (ItemInfo e: list) {
            e.clickAdToBasket();
        }
    }

    public List<ItemCard> createItemListToBasket(List<ItemInfo> list) {
        ArrayList<ItemCard> itemCardsList = new ArrayList<>();

        for (ItemInfo e: list) {
            itemCardsList.add(new ItemCard(e.getItemName(), e.getItemLowerPrice(), e.getItemPrice()));
        }

        Collections.sort(itemCardsList);
        return itemCardsList;
    }

    public BasketPage goToBasket() {
        wait.until(ExpectedConditions.elementToBeClickable(BASKET_BUTTON)).click();
        return new BasketPage(driver);
    }

    public class ItemInfo {
        private final WebElement itemInfo;
        private final By ITEM_NAME = By.cssSelector("span.product-card__name");
        private final By ITEM_LOWER_PRICE = By.tagName("ins");
        private final By ITEM_PRICE = By.tagName("del");
        private final By BASKET_BUTTON = By.cssSelector("a[href='/lk/basket']");

        public ItemInfo(WebElement itemInfo) {
            this.itemInfo = itemInfo;
        }

        public String getItemName() {
            String text = this.itemInfo.findElement(ITEM_NAME).getText();
            text = text.replaceFirst("^\\s*/\\s*", "");
            return text;
        }

        public String getItemLowerPrice() {
            String text = this.itemInfo.findElement(ITEM_LOWER_PRICE).getText();
            text = text.replaceFirst("^\\s*/\\s*", "");
            return text;
        }

        public String getItemPrice() {
            String text = this.itemInfo.findElement(ITEM_PRICE).getText();
            text = text.replaceFirst("^\\s*/\\s*", "");
            return text;
        }

        public void clickAdToBasket() {
            if (this.checkPopup()) {
                this.itemInfo.findElement(BASKET_BUTTON).click();
                wait.until(ExpectedConditions.elementToBeClickable(POPUP_CONFIRM)).click();
            } else {
                this.itemInfo.findElement(BASKET_BUTTON).click();
            }
        }

        public boolean checkPopup() {
            try {
                this.itemInfo.findElement(POPUP_SIZE);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }

    }
}
