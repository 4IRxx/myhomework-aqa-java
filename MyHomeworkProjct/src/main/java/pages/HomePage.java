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
    private final WebDriver driver;
    private final WebDriverWait wait;
    private final By basketGoButton = By.cssSelector("a[data-wba-header-name='Cart']");
    private final By popupConfirm = By.cssSelector("div[class*='popup-list-of-sizes'] label");
    private final By popupSize = By.cssSelector("p[class*='product-card__sizes']>a[data-size-name]");


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
        wait.until(ExpectedConditions.elementToBeClickable(basketGoButton)).click();
        return new BasketPage(driver);
    }

    public class ItemInfo {
        private final WebElement itemInfo;
        private final By itemName = By.cssSelector("span.product-card__name");
        private final By itemLowerPrice = By.tagName("ins");
        private final By itemPrice = By.tagName("del");
        private final By basketButton = By.cssSelector("a[href='/lk/basket']");

        public ItemInfo(WebElement itemInfo) {
            this.itemInfo = itemInfo;
        }

        public String getItemName() {
            String text = this.itemInfo.findElement(itemName).getText();
            text = text.replaceFirst("^\\s*/\\s*", "");
            return text;
        }

        public String getItemLowerPrice() {
            String text = this.itemInfo.findElement(itemLowerPrice).getText();
            text = text.replaceFirst("^\\s*/\\s*", "");
            return text;
        }

        public String getItemPrice() {
            String text = this.itemInfo.findElement(itemPrice).getText();
            text = text.replaceFirst("^\\s*/\\s*", "");
            return text;
        }

        public void clickAdToBasket() {
            if (this.checkPopup()) {
                this.itemInfo.findElement(basketButton).click();
                wait.until(ExpectedConditions.elementToBeClickable(popupConfirm)).click();
            } else {
                this.itemInfo.findElement(basketButton).click();
            }
        }

        public boolean checkPopup() {
            try {
                this.itemInfo.findElement(popupSize);
                return true;
            } catch (NoSuchElementException e) {
                return false;
            }
        }

    }
}
