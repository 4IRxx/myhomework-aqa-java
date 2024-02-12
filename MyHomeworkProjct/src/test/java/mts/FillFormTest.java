package mts;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class FillFormTest extends BaseTest {
    @BeforeClass
    public void acceptCookie() {
        homePage.acceptCookie();
    }

    @DataProvider(name = "FillForm")
    public Object[][] getDataFillForm () {
        String blockTitle = homePage.getBlockTitle();
        var helpPage = homePage.goToHelpPage();
        String helpPageTitle = helpPage.getTitle();
        homePage.goHomePage();
        String frameText = homePage.fillForm();

        return new Object[][] {
                {blockTitle, "Онлайн пополнение\nбез комиссии", "Название блока неправильное"},
                {helpPageTitle, "Порядок оплаты и безопасность интернет платежей", "Cсылка «Подробнее о сервисе» работает некорректно"},
                {frameText, "Номер карты", "Кнопка 'продолжить' не ведёт к форме оплаты"}
        };
    }

    @DataProvider(name = "Logo")
    public Object[][] getDataLogo () {
        homePage.goHomePage();
        List<WebElement> logoList = homePage.getPaymentLogos();
        int size = Math.min(logoList.size(), 6);
        Object[][] data = new Object[size][1];
        for (int i = 0; i < size; i++) {
            data[i][0] = logoList.get(i);
        }
        return data;
    }

    @Test(dataProvider = "Logo", description = "Тестирование логотипов формы")
    public void testLogoVisibility(WebElement logo) {
        assertTrue(logo.isDisplayed(), "Логотип не отображается");
    }
    @Test(dataProvider = "FillForm", description = "Тестирование элементов формы")
    public void testFillForm(String actual, String expected, String errorMessage) {
        assertEquals(actual, expected, errorMessage);
    }
}