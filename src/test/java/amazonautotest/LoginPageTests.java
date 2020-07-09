package amazonautotest;
import datadriven.TestDataProvider;
import drivers.DriverManager;
import drivers.DriverManagerFactory;
import drivers.DriverType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;
import pageobjectmodel.LoginPage;

public class LoginPageTests {
    DriverManager driverManager;
    WebDriver driver;
    LoginPage loginPage;
    @BeforeMethod
    public void setUp() {
        driverManager = DriverManagerFactory.getDriverManager(DriverType.CHROME);
        driver = driverManager.getWebDriver();
        loginPage = new LoginPage(driver);
        driver.get("https://www.amazon.com/");
        driver.manage().window().maximize();
        Assert.assertEquals("Amazon.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more", driver.getTitle());
    }
    @Test(dataProvider = "ValidLoginData", dataProviderClass = TestDataProvider.class)
    public void loginTest(String userName, String password) throws InterruptedException {
        //driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        loginPage.login(userName,password);
        Thread.sleep(60000);
        String loginSuccessMsg = loginPage.getLoginSuccessMsg();
        Assert.assertEquals(loginSuccessMsg, "Hello, Nguyen");
    }
    @Test(dataProvider = "InValidEmail",dataProviderClass = TestDataProvider.class)
    public void verifyLoginWithInvalidEmail(String email){
        loginPage.clickSignInLink();
        loginPage.setEmailInput(email);
        loginPage.clickContinueButton();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.inValidEmailMessage));
        Assert.assertEquals(loginPage.getInvalidEmailMsg(),"We cannot find an account with that email address");
    }
    @Test
    public void verifyLoginWithBlankEmail()
    {
        loginPage.clickSignInLink();
        loginPage.setEmailBlank();
        loginPage.clickContinueButton();
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.blankEmailMessage));
        Assert.assertEquals(loginPage.getBlankEmailMsg(),"Enter your email or mobile phone number");
    }
    @Test (dataProvider = "InValidPassword", dataProviderClass = TestDataProvider.class)
    public void verifyLoginWithInvalidPassword(String password) throws InterruptedException {
        loginPage.clickSignInLink();
        loginPage.setEmailInput("sunflower837@yahoo.com");
        loginPage.clickContinueButton();
        //Thread.sleep(30000);
        loginPage.setPassword(password);
        loginPage.clickSignInButton();
        WebDriverWait wait = new WebDriverWait(driver,30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(loginPage.inValidPasswordMessage));
        Assert.assertEquals(loginPage.getInvalidPasswordMsg(),"Your password is incorrect");
    }
    @AfterMethod
    public void tearDown(){
        driverManager.quitWebDriver();
    }

}
