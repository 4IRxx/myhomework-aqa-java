package forms;

import base.BaseTest;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
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

    @Test(testName = "Test blank fields")
    public void testFields() {
        String[] options = {"Услуги связи", "Домашний интернет", "Рассрочка", "Задолженность"};
        String[] expectedPlaceholders = {
                "Номер телефона", "Сумма", "E-mail для отправки чека",
                "Номер абонента", "Сумма", "E-mail для отправки чека",
                "Номер счета на 44", "Сумма", "E-mail для отправки чека",
                "Номер счета на 2073", "Сумма", "E-mail для отправки чека"
        };

        homePage.clickExactOption(options[0]);
        List<WebElement> list = homePage.getFormFieldsList();
        int fieldIndex = 0;

        for (int i = 0; i < options.length; i++) {
            String currentOption = options[i];
            String[] placeholders = Arrays.copyOfRange(expectedPlaceholders, i * 3, (i + 1) * 3);

            homePage.clickExactOption(currentOption);

            for (String expectedPlaceholder : placeholders) {
                assertEquals(list.get(fieldIndex).getAttribute("placeholder"), expectedPlaceholder, "Text field placeholder doesn't match");
                assertTrue(list.get(fieldIndex).isDisplayed(), "Text field is not displayed");
                fieldIndex++;
            }
        }
    }

}

