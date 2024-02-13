package forms;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PaymentFormTest extends BaseTest {
    @BeforeClass
    public void acceptCookie() {
        homePage.agreeCookie();
    }

    @DataProvider(name = "Logo")
    public Object[][] getDataLogo() {
        homePage.goHomePage();
        List<WebElement> logoList = homePage.getLogoList();
        int size = Math.min(logoList.size(), 6);
        Object[][] data = new Object[size][1];
        for (int i = 0; i < size; i++) {
            data[i][0] = logoList.get(i);
        }
        return data;
    }

    @Test(testName = "Test form logo", dataProvider = "Logo")
    public void testLogoVisibility(WebElement logo) {
        assertTrue(logo.isDisplayed(), "Logo inst displayed");
    }
    @Test(testName = "Test fill form")
    public void testFillForm() {
        homePage.clickExactOption("Услуги связи");
        homePage.inputPhoneNumber("297777777");
        homePage.inputSum("100");
        homePage.inputEmail("example@gmail.com");
        var frame = homePage.clickContinueButton();

        assertTrue(frame.isDisplayed(), "Frame hasnt shown");
    }

    @Test(testName = "Test payment form elements")
    public void testFormElements() {
        homePage.goHomePage();
        String blockTitle = homePage.getBlockTitle();
        var helpPage = homePage.goHelpPage();
        String helpPageTitle = helpPage.getTitle();

        assertEquals(blockTitle, "Онлайн пополнение\nбез комиссии", "Block title isnt matched");
        assertEquals(helpPageTitle, "Порядок оплаты и безопасность интернет платежей", "HelpPage title arent matched");
    }
}