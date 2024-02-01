import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class MtsByTest {

    private static WebDriver mts;

    @BeforeAll
    public static void setUp() {
        mts = new ChromeDriver();

        mts.get("https://www.mts.by/");

        try {
            WebElement acceptButton = mts.findElement(By.cssSelector(".btn.btn_black.cookie__ok"));
            acceptButton.click();
        } catch (Exception e) {
            System.out.println("Кнопка 'Принять cookie' не найдена. Продолжаем выполнение теста.");
        }
    }

    @Test
    public void testBlockTitle() {
        WebElement blockTitle = mts.findElement(By.xpath("//h2[contains(., 'Онлайн пополнение без комиссии')]"));
        String actualTitle = blockTitle.getText();
        String expectedTitle = "Онлайн пополнение\nбез комиссии";
        assertEquals(expectedTitle, actualTitle, "Заголовок блока не соответствует ожидаемому");
    }
    @Test
    public void checkPaymentLogos() {
        List<WebElement> paymentLogos = mts.findElements(By.xpath("//div[@class='pay__partners']//img"));

        assertFalse(paymentLogos.isEmpty(), "Логотипы отсутствуют");
        assertEquals(6, paymentLogos.size(), "Неверное количество логотипов");
    }

    @Test
    public void testLinkServiceRedirect() {
        By linkLocator = By.cssSelector("a[href*='/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/']");
        WebElement link = mts.findElement(linkLocator);
        link.click();

        String currentUrl = mts.getCurrentUrl();

        String expectedUrl = "https://www.mts.by/help/poryadok-oplaty-i-bezopasnost-internet-platezhey/";

        assertEquals(expectedUrl, currentUrl, "Ссылка не приводит к ожидаемому URL");
    }

    @Test
    public void checkContinueButton() {
        WebElement selectNow = mts.findElement(By.xpath("//span[@class='select__now' and contains(text(), 'Услуги связи')]"));
        selectNow.click();

        WebElement phoneInput = mts.findElement(By.id("connection-phone"));
        phoneInput.sendKeys("297777777");

        WebElement sumInput = mts.findElement(By.id("connection-sum"));
        sumInput.sendKeys("100");

        WebElement emailInput = mts.findElement(By.id("connection-email"));
        emailInput.sendKeys("example@gmail.com");

        WebElement continueButton = mts.findElement(By.xpath("//form[@id='pay-connection']//button[@type='submit']"));
        assertTrue(continueButton.isEnabled(), "Кнопка 'Продолжить' не кликабельна");

        continueButton.click();
    }

    @AfterEach
    public void setDefault() {
        mts.get("https://www.mts.by/");
    }

    @AfterAll
    public static void tearDown() {
        mts.quit();
    }
}