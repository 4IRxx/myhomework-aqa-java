package frames;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class BePaidFrame {
    public WebDriver driver;

    @FindBy(xpath = "//p[@class='header__payment-amount']")
    private WebElement sumAmount;
    @FindBy(xpath = "//app-payment-container//button[@type='submit']")
    private WebElement sumAmountBtn;
    @FindBy(xpath = "//p[@class='header__payment-info']")
    private WebElement phoneNumber;
    @FindBy(xpath = "//div[contains (@class, 'icons-container')]//img")
    private List<WebElement> logoList;
    @FindBy(xpath = "//input[@formcontrolname]/following-sibling::label")
    private List<WebElement> fieldsList;

    public BePaidFrame(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public String getSumAmount() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(sumAmount));
        String textSumAmount = sumAmount.getText();
        String resultSumAmount = textSumAmount.replaceAll("[^0-9.]+", "").replaceAll("\\.0+$", "");

        wait.until(ExpectedConditions.visibilityOf(sumAmountBtn));
        String textSumAmountBtn = sumAmountBtn.getText();
        String resultSumAmountBtn = textSumAmountBtn.replaceAll("[^0-9.]+", "").replaceAll("\\.0+$", "");

        if (resultSumAmount.equals(resultSumAmountBtn)) {
            return resultSumAmount;
        } else {
            throw new AssertionError("Суммы вверху фрейма и на кнопке не совпадают: sumAmount = " + resultSumAmount + ", sumAmountBtn = " + resultSumAmountBtn);
        }
    }

    public String getPhoneNumber() {
        String text = phoneNumber.getText();
        return text.substring(text.length() - 9);
    }

    public List<WebElement> getLogoList() {
        return logoList;
    }

    public WebElement getLogoByName(String logoName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        List<WebElement> list = getLogoList();
        for (WebElement logo: list) {
            wait.until(ExpectedConditions.visibilityOf(logo));
            if (logo.getAttribute("src").contains(logoName)) {
                return logo;
            }
        }
        throw new NoSuchElementException("Логотип '" + logoName + "' не найден");
    }

    public List<WebElement> getFieldsList() {
        return fieldsList;
    }

    public WebElement getFieldByName(String fieldName) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        List<WebElement> list = getFieldsList();
        for (WebElement field: list) {
            wait.until(ExpectedConditions.visibilityOf(field));
            if (field.getText().equals(fieldName)) {
                return field;
            }
        }
        throw new NoSuchElementException("Поле '" + fieldName + "' не найдено");
    }
}