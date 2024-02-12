package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HelpPage {
    private WebDriver driver;
    private WebDriverWait wait;
    private final By title = By.xpath("//span[@itemprop='item']/span[@itemprop='name']");

    public HelpPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
    }

    public String getTitle() {
        WebElement name = wait.until(ExpectedConditions.visibilityOfElementLocated(title));
        return name.getText();
    }
}
