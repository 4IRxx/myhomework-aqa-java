package forms_tests;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PaymentFormTest extends BaseTest {
    @BeforeClass
    public void acceptCookie() {
        homePage.agreeCookie();

    }
    @DataProvider(name = "FieldsData")
    public Object[][] getFieldsData() {
        return new Object[][]{
                {"Услуги связи", "connection-phone", "Номер телефона"},
                {"Услуги связи", "connection-sum", "Сумма"},
                {"Услуги связи", "connection-email", "E-mail для отправки чека"},
                {"Домашний интернет", "internet-phone", "Номер абонента"},
                {"Домашний интернет", "internet-sum", "Сумма"},
                {"Домашний интернет", "internet-email", "E-mail для отправки чека"},
                {"Рассрочка", "score-instalment", "Номер счета на 44"},
                {"Рассрочка", "instalment-sum", "Сумма"},
                {"Рассрочка", "instalment-email", "E-mail для отправки чека"},
                {"Задолженность", "score-arrears", "Номер счета на 2073"},
                {"Задолженность", "arrears-sum", "Сумма"},
                {"Задолженность", "arrears-email", "E-mail для отправки чека"}
        };
    }

    @Test(dataProvider = "FieldsData")
    public void testFields(String option, String fieldId, String expectedFieldName) {
        homePage.clickExactOption(option);
        WebElement field = homePage.getFieldByName(fieldId);
        String actualFieldName = field.getAttribute("placeholder");
        assertTrue(field.isDisplayed(), "Field with id '" + fieldId + "' is not displayed");
        assertEquals(actualFieldName, expectedFieldName, "Actual field name '" + fieldId + "' isn't matched expected one");
    }

}

