package frame_tests;

import base.BaseTest;
import config.ConfProperties;
import frames.BePaidFrame;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class BePaidFrameTest extends BaseTest {
    private BePaidFrame frame;

    @BeforeClass
    public void initFrame() {
        homePage.agreeCookie();
        homePage.clickExactOption("Услуги связи");
        homePage.inputPhoneNumber(ConfProperties.getProperty("expected.phone"));
        homePage.inputSum(ConfProperties.getProperty("expected.sum"));
        homePage.inputEmail(ConfProperties.getProperty("expected.email"));
        frame = homePage.clickContinueButton();
    }

    @DataProvider(name = "Logo")
    public Object[][] getLogoData() {
        return new Object[][]{
                {"mastercard"},
                {"visa"},
                {"belkart"},
                {"mir"},
                {"maestro"}
        };
    }

    @Test(testName = "Test frame logo", dataProvider = "Logo")
    public void testLogoVisibility(String logo) {
        WebElement logoElement = frame.getLogoByName(logo);
        assertTrue(logoElement.isDisplayed(), "Logo is not displayed: " + logo);
    }

    @DataProvider(name = "Fields")
    public Object[][] getFieldData() {
        return new Object[][]{
                {"Номер карты"},
                {"Срок действия"},
                {"CVC"},
                {"Имя держателя (как на карте)"}
        };
    }

    @Test(testName = "Test frame blank fields", dataProvider = "Fields", description = "(there is no need check text match - we've already checked getText()) in method")
    public void testField(String field) {
        WebElement fieldElement = frame.getFieldByName(field);
        assertTrue(fieldElement.isDisplayed(), "Field is not displayed: " + field);
    }

    @Test(testName = "Test frame with input data")
    public void testInputData() {
        String actualSum = frame.getSumAmount();
        String actualNumber = frame.getPhoneNumber();
        String expectedSum = ConfProperties.getProperty("expected.sum");
        String expectedNumber = ConfProperties.getProperty("expected.phone");
        assertEquals(actualSum, expectedSum, "Input sum in PaymentForm and sum in frame arent matched");
        assertEquals(actualNumber, expectedNumber, "Input phone number in PaymentForm and number in frame arent matched");
    }
}
