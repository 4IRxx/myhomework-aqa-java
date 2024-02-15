package base;

import config.ConfProperties;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

import java.time.Duration;

public class BaseTests {
    private WebDriver driver;

    protected HomePage homePage;

    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", ConfProperties.getProperty("chromedriver"));
        driver = new ChromeDriver();
        driver.get(ConfProperties.getProperty("homepage"));
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        homePage = new HomePage(driver, wait);
    }

    @AfterClass
    public void turnDown() {
        driver.quit();
    }

}
