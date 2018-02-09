package com.test.rscompnents.pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class AVConnectorAccessoriesPage extends BasePage {

    public AVConnectorAccessoriesPage(WebDriver driver)
    {

        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (xpath = "//a[text()='Neutrik D Series Sealing Cover']//following::td[1]//input")
    private WebElement productQuantityInputBox;

    @FindBy (xpath = "//a[text()='Neutrik D Series Sealing Cover']//following::td[1]//button")
    private WebElement addToCartButton;

    @FindBy (className = "addToBasketMessage")
    private WebElement addedToBasket;


    public void addItemToCart(String quantity){

        enterText(productQuantityInputBox,quantity);
        enter(addToCartButton);
        enter(addedToBasket);
    }

}
