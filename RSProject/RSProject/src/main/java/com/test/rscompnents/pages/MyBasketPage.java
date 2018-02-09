package com.test.rscompnents.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MyBasketPage extends BasePage{

    public MyBasketPage(WebDriver driver)
    {

        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy (id = "checkoutSecurelyAndPuchBtn")
    private WebElement checkOutBtn;

    @FindBy (id = "guestCheckoutForm:GuestWidgetAction_emailAddress_decorate:GuestWidgetAction_emailAddress")
    private WebElement guestEmailInput;

    @FindBy (id = "guestCheckoutForm:guestCheckout")
    private WebElement guestCheckoutButton;



    public void clickChekoutButton(){

        enter(checkOutBtn);
    }

    public void continueAsGuest(String guestEmailId){

        enterText(guestEmailInput,guestEmailId);
        enter(guestCheckoutButton);

    }
}
