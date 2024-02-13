package pages;

import org.openqa.selenium.By;
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
    @FindBy(xpath = "//div[@class='pay__wrapper']/h2")
    private WebElement blockTitle;
    @FindBy(xpath = "//div[@class='pay__partners']//img")
    private List<WebElement> logoList;
    @FindBy(xpath = "//div[@class='pay__wrapper']/a")
    private WebElement aboutServiceLink;
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

    public String getBlockTitle() {
        return blockTitle.getText();
    }

    public List<WebElement> getLogoList() {
        return logoList;
    }

    public HelpPage goHelpPage() {
        aboutServiceLink.click();
        return new HelpPage(driver);
    }

    public void clickExactOption(String option) {
        if (!selectedOption.getText().equals(option)) {
            buttonDropdown.click();
            WebElement exactOption = driver.findElement(By.xpath("p[@class='select__option' and text()='"+ option +"']"));
            exactOption.click();
        }
    }

    public void inputPhoneNumber(String phoneNumber) {
        phoneField.sendKeys(phoneNumber); }
    public void inputSum(String sum) {
        sumField.sendKeys(sum);
    }
    public void inputEmail(String email) {
        emailField.sendKeys(email);
    }

    public WebElement clickContinueButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        continueButton.click();
        return wait.until(ExpectedConditions.visibilityOf(frameBePaid));
    }

    public void goHomePage() {
        driver.get("https://www.mts.by/");
    }
}