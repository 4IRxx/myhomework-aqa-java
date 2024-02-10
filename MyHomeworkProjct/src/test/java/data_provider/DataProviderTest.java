package data_provider;

import base.BaseTests;
import elements.BasketCard;
import elements.ItemCard;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import pages.BasketPage;
import java.util.List;

public class DataProviderTest extends BaseTests {
    private List<ItemCard> itemCardslist;
    private List<BasketCard> basketCardslist;
    private BasketPage.BasketSidebar sidebar;
    private int basketItemSum;
    @BeforeClass
    public void loadData() {
        this.itemCardslist = homePage.prepareItemsToCompare();
        var basket = homePage.goToBasket();
        this.basketCardslist = basket.createBasketItemList();
        this.sidebar = basket.getBasketSidebar();
        basketItemSum = basket.getSum(basketCardslist);
    }

    @DataProvider (name = "ComparingItemsPrice")
    public Object[][] getDataPrice() {
        int numItems = Math.min(itemCardslist.size(), basketCardslist.size());
        Object[][] testData = new Object[numItems * 2][3];

        for (int i = 0; i < numItems; i++) {
            testData[i * 2][0] = itemCardslist.get(i).getLowerPrice();
            testData[i * 2][1] = basketCardslist.get(i).getLowerPrice();
            testData[i * 2][2] = "Цена со скидкой \"" + itemCardslist.get(i).getName() + "\" изменилась\"";

            testData[i * 2 + 1][0] = itemCardslist.get(i).getPrice();
            testData[i * 2 + 1][1] = basketCardslist.get(i).getPrice();
            testData[i * 2 + 1][2] = "Цена без скидки \"" + itemCardslist.get(i).getName() + "\" изменилась";
        }
        return testData;
    }

    @DataProvider (name = "ComparingItemsName")
    public Object[][] getDataName() {
        int size = Math.min(itemCardslist.size(), basketCardslist.size());
        Object[][] testData = new Object[size][3];

        for (int i = 0; i < size; i++) {
            testData[i][0] = itemCardslist.get(i).getName();
            testData[i][1] = basketCardslist.get(i).getName();
            testData[i][2] = "Имя товара " + (i + 1) + " не совпадает";
        }
        return testData;
    }

    @DataProvider (name = "ComparingItemsAmountAndSum")
    public Object[][] getDataSidebar () {
        return new Object[][]{
            {itemCardslist.size(), basketCardslist.size(), "Количетсво добавленных товаров в корзину и количество товаров в корзине не совпадают"},
            {basketCardslist.size(), sidebar.getAmount(), "Количество штук не совпадает"},
            {basketItemSum, sidebar.getSum(), "Общая сумма товаров отличается"}
        };
    }
}