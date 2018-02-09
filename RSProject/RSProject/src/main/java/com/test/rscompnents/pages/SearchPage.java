package com.test.rscompnents.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(className = "main-page-header")
    private WebElement searchPageHeader;

    public void verifySearchPage(String expectedHeder)
    {
        String ActHeader = searchPageHeader.getText();
        Assert.assertTrue(ActHeader.equals(expectedHeder));
    }
}
