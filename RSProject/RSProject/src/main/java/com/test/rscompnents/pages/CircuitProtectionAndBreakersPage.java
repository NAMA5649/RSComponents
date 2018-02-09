package com.test.rscompnents.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CircuitProtectionAndBreakersPage extends BasePage {

    public CircuitProtectionAndBreakersPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Auto Recloser']")
    private WebElement autoRecloser;

    public void navigateToAutoRecloserPage()
    {
        enter(autoRecloser);
    }
}
