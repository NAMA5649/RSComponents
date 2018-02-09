package com.test.rscompnents.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AudioVideoCablesPage extends BasePage {

    public AudioVideoCablesPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='A/V Mixed Cable Assemblies']")
    private WebElement avMixedCable;

    public void navigateToAVMixedCablePage()
    {
        enter(avMixedCable);
    }
}
