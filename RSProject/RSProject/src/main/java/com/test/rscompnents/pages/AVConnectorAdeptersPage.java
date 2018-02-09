package com.test.rscompnents.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AVConnectorAdeptersPage extends BasePage {

    public AVConnectorAdeptersPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[text()='RS Pro Adapter']//following::td[1]//input")
    private WebElement productQuantityInputBox;

    @FindBy (xpath = "//a[text()='RS Pro Adapter']//following::td[1]//button")
    private WebElement addToCartButton;

    @FindBy (className = "addToBasketMessage")
    private WebElement addedToBasket;

    public void addItemToCart(String quantity){

        enterText(productQuantityInputBox,quantity);
        enter(addToCartButton);
        enter(addedToBasket);
    }
}
