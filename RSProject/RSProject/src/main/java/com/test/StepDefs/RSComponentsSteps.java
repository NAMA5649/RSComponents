package com.test.StepDefs;


import com.test.rscompnents.pages.*;
import cucumber.api.PendingException;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;



public class RSComponentsSteps {

    public static final String USER_DIR= System.getProperty("user.dir");
    public static String PATH = USER_DIR+"\\src\\main\\resources\\drivers\\";
    public WebDriver driver;
    HomePage homePage;
    AudioVideoConnectorsPage audioVideoConnectorsPage;
    AVConnectorAccessoriesPage avConnectorAccessoriesPage;
    MyBasketPage myBasketPage;
    GuestDetailsPage guestDetailsPage;
    AVConnectorAdeptersPage avConnectorAdeptersPage;
    AutomativeBatteriesPage automativeBatteriesPage;
    BatteryHydrometersPage batteryHydrometersPage;
    CircuitProtectionAndBreakersPage circuitProtectionAndBreakersPage;
    AutoRecloserPage autoRecloserPage;
    AudioVideoCablesPage audioVideoCablesPage;
    AVMixedCablepage avMixedCablepage;
    SearchPage searchPage;

    String itemName = "AC Motors";

    @Before
    public void startUp() throws IOException {
        Properties prop = new Properties();
        InputStream input = new FileInputStream("propertyfile.properties");
        prop.load(input);
        String browser=prop.getProperty("browser");
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", PATH +"chromedriver.exe");
            driver=new ChromeDriver();
        }

        else if (browser.equals("internet explorer")) {
            System.setProperty("webdriver.ie.driver", PATH+ "IEDriverServer");
            driver = new InternetExplorerDriver();
        }

        else if(browser.equals("firefox")){
            System.setProperty("webdriver.firefox.driver", PATH+"geckodriver.exe");
            driver = new FirefoxDriver();
        }

        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^I navigate to rsonline website$")
    public void iNavigateToRsonlineWebsite() throws Throwable {

        homePage = new HomePage(driver);
        homePage.navigateTo();
    }

    @When("^I select Connectors and AudiovideoConnectors accesories$")
    public void iSelectConnectorsAndAudiovideoConnectors() throws Throwable {

        homePage.navigateToAudioVideoConnectorsPage();
        audioVideoConnectorsPage = new AudioVideoConnectorsPage(driver);
        audioVideoConnectorsPage.navigateToAVConnectorAccessoriesPage();
    }


    @And("^I enter the quantity for accesories$")
    public void iEnterThe() throws Throwable {

        avConnectorAccessoriesPage = new AVConnectorAccessoriesPage(driver);
        avConnectorAccessoriesPage.addItemToCart("1");
    }

    @Then("^I succesfully add item to cart and purchase$")
    public void iSuccesfullyAddItemToCartAndPurchase() throws Throwable {
        myBasketPage = new MyBasketPage(driver);
        myBasketPage.clickChekoutButton();
        myBasketPage.continueAsGuest("vsrk@gmail.com");
        guestDetailsPage = new GuestDetailsPage(driver);
        guestDetailsPage.deliveryAddressEntries("Mr.","abc","xyz","12345","comp","sdc","dfs","Buckinghamshire","HP18 4AP");

    }


    @When("^I select Connectors and AudiovideoConnectors adepters$")
    public void iSelectConnectorsAndAudiovideoConnectorsAdepters() throws Throwable {

        homePage.navigateToAudioVideoConnectorsPage();
        audioVideoConnectorsPage = new AudioVideoConnectorsPage(driver);
        audioVideoConnectorsPage.navigateToAVConnectorsAdaptersPage();
    }

    @And("^I enter the quantity for adepters$")
    public void iEnterTheQuantityForAdepters() throws Throwable {

        avConnectorAdeptersPage = new AVConnectorAdeptersPage(driver);
        avConnectorAdeptersPage.addItemToCart("1");
    }

    @When("^I select Batteries and AutomativeBatteries$")
    public void iSelectBatteriesAndAutomativeBatteries() throws Throwable {

        homePage.navigateToAutomativeBatteryPage();
        automativeBatteriesPage = new AutomativeBatteriesPage(driver);
        automativeBatteriesPage.navigateToBatteryHydrometersPage();
    }

    @And("^I enter the quantity for AutomativeBatteries$")
    public void iEnterTheQuantityForAutomativeBatteries() throws Throwable {

        batteryHydrometersPage = new BatteryHydrometersPage(driver);
        batteryHydrometersPage.addItemToCart("1");
    }

    @When("^I select Automation & Gear control and select circuit protection & circuit breakers$")
    public void iSelectAutomationGearControlAndSelectCircuitProtectionCircuitBreakers() throws Throwable {

        homePage.navigateToCircuitsProtectionBreakersPage();
        circuitProtectionAndBreakersPage = new CircuitProtectionAndBreakersPage(driver);
        circuitProtectionAndBreakersPage.navigateToAutoRecloserPage();

    }

    @And("^Apply the filters for supply voltage$")
    public void applyTheFiltersForSupplyVoltage() throws Throwable {
        autoRecloserPage = new AutoRecloserPage(driver);
        autoRecloserPage.addFilter();
    }

    @Then("^verify the applied filter products are displayed$")
    public void verifyTheAppliedFilterProductsAreDisplayed() throws Throwable {
       autoRecloserPage.verifyAppliedFilters();
    }

    @When("^I select Cables & wires and select Audio video cable$")
    public void iSelectCablesWiresAndSelectAudioVideoCable() throws Throwable {

        homePage.navigateToAudioVideoCables();
        audioVideoCablesPage = new AudioVideoCablesPage(driver);
        audioVideoCablesPage.navigateToAVMixedCablePage();

    }

    @And("^Apply multiple filters for Connector$")
    public void applyTheFiltersForConnectorB() throws Throwable {

        avMixedCablepage = new AVMixedCablepage(driver);
        avMixedCablepage.addMultipleFilter();
    }

    @Then("^verify the applied filter products are displayed for AV mixed cable$")
    public void verifyTheAppliedFilterProductsAreDisplayedForAVMixedCable() throws Throwable {
       avMixedCablepage.verifyAppliedFiltersForConnectorA();
       avMixedCablepage.verifyAppliedFiltersForConnectorB();
    }

    @When("^Enter the product name in search box$")
    public void enterTheProductNameInSearchBox() throws Throwable {

        homePage.searchItem(itemName);
    }

    @Then("^Verify the search page$")
    public void verifyTheSeachPage() throws Throwable {

        searchPage = new SearchPage(driver);
        searchPage.verifySearchPage(itemName);
    }
}
