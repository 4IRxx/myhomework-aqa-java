package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class HomePage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final By cookie = By.cssSelector(".btn.btn_black.cookie__ok");
    private final By blockTitle = By.xpath("//div[@class='pay__wrapper']/h2");
    private final By paymentLogos = By.xpath("//div[@class='pay__partners']//img");
    private final By aboutServiceLink = By.linkText("Подробнее о сервисе");
    private final By connectionService = By.xpath("//span[@class='select__now' and contains(text(), 'Услуги связи')]");
    private final By phone = By.id("connection-phone");
    private final By sum = By.id("connection-sum");
    private final By email = By.id("connection-email");
    private final By continueButton = By.xpath("//form[@id='pay-connection']//button[@type='submit']");
    private final By iframe = By.cssSelector("iframe.bepaid-iframe");
    private final By cardNumberField = By.xpath("//label[contains(., 'Номер карты')]");

    public HomePage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public void acceptCookie() {
        try {
            WebElement acceptButton = driver.findElement(cookie);
            acceptButton.click();
        } catch (Exception e) {
            System.out.println("Кнопка 'Принять cookie' не найдена. Продолжаем выполнение теста.");
        }
    }

    public String getBlockTitle() {
        WebElement title = driver.findElement(blockTitle);
        return title.getText();
    }

    public List<WebElement> getPaymentLogos() {
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(paymentLogos));
        return driver.findElements(paymentLogos);
    }

    public HelpPage goToHelpPage() {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(aboutServiceLink));
        link.click();
        return new HelpPage(driver, wait);
    }

    public String fillForm() {
        WebElement selectNow = driver.findElement(connectionService);
        selectNow.click();

        WebElement phoneInput = driver.findElement(phone);
        phoneInput.sendKeys("297777777");
        WebElement sumInput = driver.findElement(sum);
        sumInput.sendKeys("100");
        WebElement emailInput = driver.findElement(email);
        emailInput.sendKeys("example@gmail.com");

        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(continueButton));
        button.click();
        WebElement iframeElement = wait.until(ExpectedConditions.visibilityOfElementLocated(iframe));
        driver.switchTo().frame(iframeElement);

        WebElement field = wait.until(ExpectedConditions.visibilityOfElementLocated(cardNumberField));
        return field.getText();
    }

    public void goHomePage() {
        driver.get("https://www.mts.by/");
    }

}
