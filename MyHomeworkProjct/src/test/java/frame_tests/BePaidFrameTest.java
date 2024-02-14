package frame_tests;

import base.BaseTest;
import config.ConfProperties;
import frames.BePaidFrame;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BePaidFrameTest extends BaseTest {
    private List<WebElement> logoList;
    private BePaidFrame frame;
    private List<WebElement> fieldList;
    @BeforeClass
    public void acceptCookie() {
        homePage.agreeCookie();
    }

    @BeforeClass
    public void loadData() {
        homePage.clickExactOption("Услуги связи");
        homePage.inputPhoneNumber(ConfProperties.getProperty("expected.phone"));
        homePage.inputSum(ConfProperties.getProperty("expected.sum"));
        homePage.inputEmail(ConfProperties.getProperty("expected.email"));
        frame = homePage.clickContinueButton();
        fieldList = frame.getFieldsList();
        logoList = frame.getLogoList();
    }

    @DataProvider(name = "FrameData")
    public Object[][] getFrameData () {
        return new Object[][]{
                {frame.getSumAmount(), ConfProperties.getProperty("expected.sum"), "Actual sum isnt matched expected sum"},
                {frame.getPhoneNumber(), ConfProperties.getProperty("expected.phone"), "CardNumberField isnt matched expected name"},
                {frame.getCardNumberField(), "Номер карты", "CardNumberField isnt matched expected name"},
                {frame.getCardDateField(), "Срок действия", "CardDateField isnt matched expected name"},
                {frame.getCardCvcField(), "CVC", "CardCvcField isnt matched expected name"},
                {frame.getCardHolderField(), "Имя держателя (как на карте)", "CardHolderField isnt matched expected name"}
        };
    }
    @Test(testName = "Test frame with input data", dataProvider = "FrameData")
    public void testFrameWithData(String actualResult, String expectedResult, String errorMessage) {
        assertEquals(actualResult, expectedResult, errorMessage);
    }

    @DataProvider(name = "FrameLogo")
    public Object[][] getDataLogo () {
        WebDriverWait wait = new WebDriverWait(homePage.driver, Duration.ofSeconds(5));
        Object[][] data = new Object[logoList.size()][1];

        for (int i = 0; i < logoList.size(); i++) {
            WebElement logo = wait.until(ExpectedConditions.visibilityOf(logoList.get(i)));
            data[i][0] = logo;
        }
        return data;
    }

    @Test(priority = 1, testName = "Test logo visability", dataProvider = "FrameLogo")
    public void testLogoVisability(WebElement logo) {
        assertTrue(logo.isDisplayed(), "Logo is not visible");
    }


    @DataProvider(name = "FrameFields")
    public Object[][] getDataFields () {
        WebDriverWait wait = new WebDriverWait(homePage.driver, Duration.ofSeconds(30));
        Object[][] data = new Object[fieldList.size()][1];

        for (int i = 0; i < fieldList.size(); i++) {
            WebElement field = wait.until(ExpectedConditions.visibilityOf(logoList.get(i)));
            data[i][0] = field;
        }
        return data;
    }

    @Test(testName = "Test blank fields visability", dataProvider = "FrameFields")
    public void testFieldsVisability(WebElement field) {
        assertTrue(field.isDisplayed(), "Field is not visible");
    }
}