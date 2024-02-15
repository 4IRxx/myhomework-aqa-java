package pages;

import frames.BePaidFrame;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HomePage {
    public WebDriver driver;
    @FindBy(xpath = "//button[@id='cookie-agree']")
    private WebElement buttonCookieAgree;
    @FindBy(xpath = "//div[@class='pay__wrapper']//span[@class='select__now']")
    private WebElement selectedOption;
    @FindBy(xpath = "//div[@class='pay__wrapper']//button[@class='select__header']")
    private WebElement buttonDropdown;
    @FindBy(id = "connection-phone")
    private WebElement phoneField;
    @FindBy(id = "connection-sum")
    private WebElement sumField;
    @FindBy(id = "connection-email")
    private WebElement emailField;
    @FindBy(xpath = "//form[@id='pay-connection']//button[@type='submit']")
    private WebElement continueButton;
    @FindBy(xpath = "//iframe[@class='bepaid-iframe']")
    private WebElement frameBePaid;
    @FindBy(xpath = "//div[@class='pay__forms']//input")
    private List<WebElement> formFieldsList;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void agreeCookie() {
        try {
            buttonCookieAgree.click();
        } catch (Exception e) {
            System.out.println("Кнопка 'Принять cookie' не найдена. Продолжаем выполнение теста.");
        }
    }

    public void clickExactOption(String option) {

        if (!selectedOption.getText().equals(option)) {
            buttonDropdown.click();
            WebElement exactOption = driver.findElement(By.xpath("//p[@class='select__option' and text()='"+ option +"']"));
            exactOption.click();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public List<WebElement> getFormFieldsList() {
        return formFieldsList;
    }

    public WebElement getFieldById(String fieldId) {
        List<WebElement> list = getFormFieldsList();
        for (WebElement field: list) {
            if (field.getAttribute("id").equals(fieldId)) {
                return field;
            }
        }
        throw new NoSuchElementException("Поле '" + fieldId + "' не найдено");
    }

    public void inputPhoneNumber(String phoneNumber) {
        phoneField.sendKeys(phoneNumber); }
    public void inputSum(String sum) {
        sumField.sendKeys(sum);
    }
    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }

    public BePaidFrame clickContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        continueButton.click();
        WebElement frame = wait.until(ExpectedConditions.visibilityOf(frameBePaid));
        driver.switchTo().frame(frame);
        return new BePaidFrame(driver);
    }

    public void goHomePage() {
        driver.get("https://www.mts.by/");
    }
}