package com.test.rscompnents.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AudioVideoConnectorsPage extends BasePage {

    public AudioVideoConnectorsPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy (xpath = "//a[text()='Audio & Video Connector Accessories']")
    private WebElement avConnectorAccessories;

    @FindBy (xpath = "//a[text()='Audio & Video Connector Adapters']")
    private WebElement avConnectorAdapters;


    public  void navigateToAVConnectorAccessoriesPage(){

        enter(avConnectorAccessories);

    }

    public void navigateToAVConnectorsAdaptersPage(){

        enter(avConnectorAdapters);
    }
}
