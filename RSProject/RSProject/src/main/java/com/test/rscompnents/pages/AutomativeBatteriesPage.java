package com.test.rscompnents.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AutomativeBatteriesPage extends BasePage {

    public AutomativeBatteriesPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='Battery Hydrometers']")
    private WebElement batteryHydrometers;

    public void navigateToBatteryHydrometersPage()
    {
        enter(batteryHydrometers);
    }
}
