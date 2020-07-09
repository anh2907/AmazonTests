package amazonautotest;

import datadriven.SortOption;
import datadriven.TestDataProvider;
import drivers.DriverManager;
import drivers.DriverManagerFactory;
import drivers.DriverType;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageobjectmodel.LoginPage;
import pageobjectmodel.SearchResultPage;

public class SearchResultPageTests {
    DriverManager driverManager;
    WebDriver driver;
    LoginPage loginPage;
    SearchResultPage searchResultPage;
    @BeforeMethod
    public void setUp() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        loginPage = new LoginPage(driver);
        searchResultPage = new SearchResultPage(driver);
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        Assert.assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", driver.getTitle());
    }
    @Test(dataProvider = "ValidLoginData", dataProviderClass = TestDataProvider.class)
    public void verifyPaging(String userName, String password) throws InterruptedException {
        loginPage.login(userName,password);
        Thread.sleep(60000);
        searchResultPage.performSearch("apple");
        Assert.assertEquals(searchResultPage.getResultList(), 16);
        searchResultPage.clickNextButton();
        Assert.assertEquals(searchResultPage.getResultList(), 16);

    }
    @Test(dataProvider = "ValidLoginData", dataProviderClass = TestDataProvider.class)
    public void verifySortByOption(String userName, String password) throws InterruptedException {
        loginPage.login(userName,password);
        Thread.sleep(60000);
        searchResultPage.performSearch("apple");
        searchResultPage.clickSortList();
        searchResultPage.clickOptionPriceLowToHigh();
        Thread.sleep(5000);
        //Assert.assertEquals(searchResultPage.getSelectedSortItem(),"Price: Low to High");
        Assert.assertEquals(searchResultPage.getSelectedSortItem(), SortOption.OptionPriceLowToHigh.getSortOption());

    }
    @AfterMethod
    public void tearDown(){
        driverManager.quitWebDriver();
    }
}
