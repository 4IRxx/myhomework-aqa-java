package com.myaqa;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Calculator {
    AppiumDriver driver;

    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='divide']")
    WebElement divideButton;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='multiply']")
    WebElement multiplyButton;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='minus']")
    WebElement minusButton;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='plus']")
    WebElement plusButton;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='equals']")
    WebElement equalsButton;
    @FindBy(id = "com.google.android.calculator:id/result_final")
    WebElement result;
    @FindBy(id = "com.google.android.calculator:id/result_preview")
    WebElement resultPreview;
    @FindBy(xpath = "//android.widget.ImageButton[@content-desc='clear']")
    WebElement clearButton;

    public Calculator(AppiumDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public int addition(int numberOne, int NumberTwo) {
        WebElement firstNumber = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='"+ numberOne +"']"));
        firstNumber.click();
        plusButton.click();
        WebElement secondNumber = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='"+ NumberTwo +"']"));
        secondNumber.click();
        equalsButton.click();
        return Integer.parseInt(result.getText());
    }

    public int deduction(int numberOne, int NumberTwo) {
        WebElement firstNumber = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='"+ numberOne +"']"));
        firstNumber.click();
        minusButton.click();
        WebElement secondNumber = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='"+ NumberTwo +"']"));
        secondNumber.click();
        equalsButton.click();
        return Integer.parseInt(result.getText());
    }

    public int multiplication(int numberOne, int NumberTwo) {
        WebElement firstNumber = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='"+ numberOne +"']"));
        firstNumber.click();
        multiplyButton.click();
        WebElement secondNumber = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='"+ NumberTwo +"']"));
        secondNumber.click();
        equalsButton.click();
        return Integer.parseInt(result.getText());
    }

    public int division(int numberOne, int NumberTwo) {
        WebElement firstNumber = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='"+ numberOne +"']"));
        firstNumber.click();
        divideButton.click();
        WebElement secondNumber = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='"+ NumberTwo +"']"));
        secondNumber.click();
        equalsButton.click();
        return Integer.parseInt(result.getText());
    }

    public String divisionByZero(int number) {
        WebElement firstNumber = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='"+ number +"']"));
        firstNumber.click();
        divideButton.click();
        WebElement secondNumber = driver.findElement(By.xpath("//android.widget.ImageButton[@content-desc='0']"));
        secondNumber.click();
        equalsButton.click();
        return resultPreview.getText();
    }

    public void clickClearButton() {
        clearButton.click();
    }
}