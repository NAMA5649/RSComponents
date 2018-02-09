package com.test.rscompnents.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AutoRecloserPage extends BasePage {

    public AutoRecloserPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[contains(text(),'Supply Voltage')]")
    private WebElement supplyVoltage;

    @FindBy(xpath = "//span[contains(text(),'230 V ac')]//preceding::input[1]")
    private WebElement acCheckbox;

    @FindBy(xpath = "//button[text()='Apply filters']")
    private WebElement applyFiltersBtn;

    @FindBy(id = "results-table-header")
    private WebElement headersTable;

    @FindBy(xpath = "//a[@title='Next']")
    private WebElement next;

    Boolean stringFound = false;

    public void addFilter() {
        enter(supplyVoltage);
        enter(acCheckbox);
        enter(applyFiltersBtn);
    }

    public void verifyAppliedFilters() {
        List<WebElement> tableHeaders = headersTable.findElements(By.tagName("th"));
        int colposition = 0;
        for (int headers = 0; headers < tableHeaders.size(); headers++) {
            String header = tableHeaders.get(headers).getText();
            if (header.equals("Supply Voltage")) {
                colposition = headers + 1;
                break;
            }
        }
            List<WebElement> coldata = driver.findElements(By.xpath("//table[@id='results-table']/tbody/tr/td[" + colposition + "]"));
            for (WebElement data:coldata) {
                String text = data.getText();
                if (text.equals("230 V ac")) {
                    Assert.assertTrue(text.contains("230 V ac"));

                }

            }

        }
    }
