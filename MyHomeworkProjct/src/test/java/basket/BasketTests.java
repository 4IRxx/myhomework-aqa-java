package basket;

import data_provider.DataProviderTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import static org.testng.Assert.assertEquals;

public class BasketTests extends DataProviderTest {

    @Test (dataProvider = "ComparingItemsPrice", description = "Проверяем товары на предмет изменения цен после перехода в корзину")
    public void testItemPrice(String expected, String actual, String errorMessage) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(expected, actual, errorMessage);
        softAssert.assertAll();
    }

    @Test (dataProvider = "ComparingItemsName", description = "Проверяем товары на предмет соответсвия имен после перехода в корзину")
    public void testItemName(String expected, String actual, String errorMessage) {
        assertEquals(expected.replaceAll("\\.+$", ""), actual.trim().replaceAll("\\.+$", ""), errorMessage);
    }

    @Test (dataProvider = "ComparingItemsAmountAndSum", description = "Проверяем общую сумму и количество штук товаров в корзине(sidebar)")
    public void testItemSumAndAmount(int expected, int actual, String errorMessage) {
        assertEquals(expected, actual, errorMessage);
    }
}
