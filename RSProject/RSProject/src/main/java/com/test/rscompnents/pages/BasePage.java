package com.test.rscompnents.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;

    public  BasePage(WebDriver driver){

        this.driver = driver;
    }

    public void navigateTo()
    {
        driver.navigate().to(RSComponentsProperties.getRscompUrl());
    }

    //Click Method
    public void enter (WebElement webElement) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 30);
            wait.until(ExpectedConditions.visibilityOf(webElement));
            webElement.click();
        } catch (Exception t) {
            throw t;
        }
    }

    //Write Text
    public void enterText(WebElement webElement,String string) {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 15);
            wait.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(string);
        } catch (Exception t) {
            throw t;
        }
    }

    //Perform mouse hover
    public void hover(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        Actions action = new Actions(driver);
        // move to the element to hover
        action.moveToElement(element).build().perform();

    }

    //Selecting an element from dropdown
    public void selectByVisibleText(WebElement element, String toBeSelected) {
        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(element));
        Select oSelect = new Select(element);
        oSelect.selectByVisibleText(toBeSelected);
    }

}
