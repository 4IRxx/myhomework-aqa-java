package forms_tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.*;

public class PaymentFormTest extends BaseTest {
    @BeforeClass
    public void acceptCookie() {
        homePage.agreeCookie();
    }

    @DataProvider(name = "Logo")
    public Object[][] getLogoData() {
        return new Object[][]{
                {"Visa"},
                {"Verified By Visa"},
                {"MasterCard"},
                {"Белкарт"},
                {"МИР"},
                {"MasterCard Secure Code"}
        };
    }

    @Test(testName = "Test form logo", dataProvider = "Logo")
    public void testLogoVisibility(String logo) {
        homePage.goHomePage();
        WebElement logoElement = homePage.getLogoByName(logo);
        assertTrue(logoElement.isDisplayed(), "Logo is not displayed: " + logo);
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