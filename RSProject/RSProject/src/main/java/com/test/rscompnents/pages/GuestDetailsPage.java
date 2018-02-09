package com.test.rscompnents.pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class GuestDetailsPage extends BasePage{

    public GuestDetailsPage(WebDriver driver)
    {
        super(driver);
        PageFactory.initElements(driver, this);
    }




    @FindBy (xpath = "//select[contains(@name,'deliveryCollectionForm:CustomerContactDetailsWidgetAction_title_decorate')]")
    private WebElement titleDropDown;

    @FindBy (id="deliveryCollectionForm:CustomerContactDetailsWidgetAction_firstName_decorate:CustomerContactDetailsWidgetAction_firstName")
    private WebElement firstNameInput;

    @FindBy (id = "deliveryCollectionForm:CustomerContactDetailsWidgetAction_surName_decorate:CustomerContactDetailsWidgetAction_surName")
    private WebElement lastNameInput;

    @FindBy (id = "deliveryCollectionForm:CustomerContactDetailsWidgetAction_contactNumber_decorate:CustomerContactDetailsWidgetAction_contactNumber")
    private WebElement contactTelePhoneNo;


    @FindBy (id ="deliveryCollectionForm:GuestDeliveryAddressWidgetAction_companyNameOne_decorate:GuestDeliveryAddressWidgetAction_companyNameOne")
    private WebElement companyName;

    @FindBy (id = "deliveryCollectionForm:GuestDeliveryAddressWidgetAction_addressLineOne_decorate:GuestDeliveryAddressWidgetAction_addressLineOne")
    private WebElement addressLineOne;

    @FindBy (id = "deliveryCollectionForm:GuestDeliveryAddressWidgetAction_addressLineThree_decorate:GuestDeliveryAddressWidgetAction_addressLineThree")
    private WebElement townInput;

    @FindBy (id = "deliveryCollectionForm:GuestDeliveryAddressWidgetAction_selectedRegion_decorate:selectedRegion")
    private WebElement countyNameDropdown;

    @FindBy (id = "deliveryCollectionForm:GuestDeliveryAddressWidgetAction_postCode_decorate:GuestDeliveryAddressWidgetAction_postCode")
    private WebElement postCodeInput;

    @FindBy (id = "checkoutSecurelyBtn")
    private WebElement continueToPaymentBtn;

    public void deliveryAddressEntries(String titleOpt, String firstName, String lastName, String tel, String company, String address, String town, String county, String postCode){

        selectByVisibleText(titleDropDown,titleOpt);
        enterText(firstNameInput,firstName);
        enterText(lastNameInput,lastName);
        enterText(contactTelePhoneNo,tel);
        enterText(companyName,company);
        enterText(addressLineOne,address);
        enterText(townInput,town);
        selectByVisibleText(countyNameDropdown,county);
        enterText(postCodeInput,postCode);
        enter(continueToPaymentBtn);
    }
}
