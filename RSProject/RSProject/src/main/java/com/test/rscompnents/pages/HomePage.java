package com.test.rscompnents.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    WebDriver driver;
    public HomePage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy (xpath = "//a[contains(text(),'All Products')]")
     private WebElement allProducts;

    @FindBy (xpath = "//a[text()='Batteries']")
     private WebElement batteriesMenuItem;

    @FindBy (xpath = "//a[text()='Automotive Battery Maintenance']")
    private WebElement automativeBatteryMaintenence;

    @FindBy (xpath = "//a[text()='Connectors']")
     private WebElement connectors;

    @FindBy(xpath = "//a[text()='Audio & Video Connectors']")
    private WebElement audioVideoConnectors;

    @FindBy(xpath = "//a[text()='Automation & Control Gear']")
    private WebElement autmationControlGear;

    @FindBy(xpath = "//a[text()='Circuit Protection & Circuit Breakers']")
    private WebElement circuitProtectionBreakers;

    @FindBy(xpath = "//a[text()='Cables & Wires']")
    private WebElement cablesAndWires;

    @FindBy(xpath = "//a[contains(text(),'Audio Video Cable')]")
    private WebElement audioVideocables;

    @FindBy(id = "searchTerm")
    private WebElement searchTxtBox;

    @FindBy(id = "btnSearch")
    private WebElement searchBtn;



    public void navigateToAutomativeBatteryPage(){

        enter(allProducts);
        hover(batteriesMenuItem);
        enter(automativeBatteryMaintenence);
    }

    public void navigateToAudioVideoConnectorsPage(){

        enter(allProducts);
        hover(connectors);
        enter(audioVideoConnectors);
    }

    public void navigateToCircuitsProtectionBreakersPage()
    {
        enter(allProducts);
        hover(autmationControlGear);
        enter(circuitProtectionBreakers);
    }

    public void navigateToAudioVideoCables()
    {
        enter(allProducts);
        hover(cablesAndWires);
        enter(audioVideocables);
    }

    public void searchItem(String itemName)
    {
        enterText(searchTxtBox,itemName);
        enter(searchBtn);
    }

}
