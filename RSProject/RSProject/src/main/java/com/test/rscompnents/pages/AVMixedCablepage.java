package com.test.rscompnents.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AVMixedCablepage extends BasePage {

    public AVMixedCablepage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Connector A')]")
    private WebElement connectorA;
    @FindBy(xpath = "//a[contains(text(),'Connector B')]")
    private WebElement connectorB;
    @FindBy(xpath = "//span[contains(text(),'Male BNC')]//preceding::input[1]")
    private WebElement connectorAMaleBNC;
    @FindBy(xpath = "//span[contains(text(),'Male BNC')]//preceding::input[1]")
    private WebElement connectorBMaleBNC;
    @FindBy(xpath = "//button[text()='Apply filters']")
    private WebElement applyFiltersBtn;
    @FindBy(id = "results-table-header")
    private WebElement headersTable;


    public void addMultipleFilter()
    {
        enter(connectorA);
        enter(connectorAMaleBNC);
        enter(applyFiltersBtn);
        enter(connectorB);
        enter(connectorBMaleBNC);
        enter(applyFiltersBtn);
    }

    public void verifyAppliedFiltersForConnectorB() {
        List<WebElement> tableHeaders = headersTable.findElements(By.tagName("th"));
        int colposition = 0;
        for (int headers = 0; headers < tableHeaders.size(); headers++) {
            String header = tableHeaders.get(headers).getText();
            if (header.equals("Connector B")) {
                colposition = headers + 1;
                break;
            }
        }
        List<WebElement> coldata = driver.findElements(By.xpath("//table[@id='results-table']/tbody/tr/td[" + colposition + "]"));
        for ( WebElement data:coldata) {
            String text = data.getText();
            Assert.assertTrue(text.contains("Male BNC"));
        }

    }

    public void verifyAppliedFiltersForConnectorA() {
        List<WebElement> tableHeaders = headersTable.findElements(By.tagName("th"));
        int colposition = 0;
        for (int headers = 0; headers < tableHeaders.size(); headers++) {
            String header = tableHeaders.get(headers).getText();
            if (header.equals("Connector A")) {
                colposition = headers + 1;
                break;
            }
        }
        List<WebElement> coldata = driver.findElements(By.xpath("//table[@id='results-table']/tbody/tr/td[" + colposition + "]"));
        for ( WebElement data:coldata) {
            String text = data.getText();
            Assert.assertTrue(text.contains("Male BNC"));
        }

    }
}
