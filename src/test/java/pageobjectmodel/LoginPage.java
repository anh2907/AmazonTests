package pageobjectmodel;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    WebDriver driver;
    //Constructor of this PageObject
    public LoginPage (WebDriver driver){
        this.driver= driver;
    }
    //Element locators of the web elements on this page
    private By signInLink = By.xpath(".//a[@id='nav-link-accountList']");
    private By signInButton = By.xpath(".//input[@id='signInSubmit']");
    private By emailInput = By.xpath(".//input[@type='email']");
    private By passwordInput = By.xpath(".//input[@type='password']");
    private By continueButton = By.xpath(".//input[@id='continue']");
    private By loginSuccessMsg = By.xpath(".//span[contains(text(),'Hello, Nguyen')]");
    public By inValidEmailMessage = By.xpath(".//span[contains(text(),'We cannot find an account with that email address')]");
    public By blankEmailMessage = By.xpath(".//div[contains(text(),'Enter your email or mobile phone number')]");
    public  By inValidPasswordMessage = By.xpath(".//span[contains(text(),'Your password is incorrect')]");

    public void login(String email, String password){
        this.clickSignInLink();
        this.setEmailInput(email);
        this.clickContinueButton();
        this.setPassword(password);
        this.clickSignInButton();
    }
    public void setEmailInput(String email){
        driver.findElement(emailInput).sendKeys(email);
    }
    public void setPassword(String password){
        driver.findElement(passwordInput).sendKeys(password);
    }
    public void clickSignInLink(){
        driver.findElement(signInLink).click();
    }
    public void clickContinueButton(){
        driver.findElement(continueButton).click();
    }
    public void clickSignInButton()
    {
        driver.findElement(signInButton).click();
    }
    public String getLoginSuccessMsg(){
        String successMsg;
        successMsg = driver.findElement(loginSuccessMsg).getText();
        return successMsg;
    }
    public String getInvalidEmailMsg(){
        String inValidEmailMsg;
        inValidEmailMsg = driver.findElement(inValidEmailMessage).getText();
        return inValidEmailMsg;
    }
    public void setEmailBlank()
    {
        driver.findElement(emailInput).clear();
    }
    public String getBlankEmailMsg(){
        String blankEmailMsg;
        blankEmailMsg = driver.findElement(blankEmailMessage).getText();
        return blankEmailMsg;
    }
    public String getInvalidPasswordMsg(){
        String inValidPasswordMsg;
        inValidPasswordMsg = driver.findElement(inValidPasswordMessage).getText();
        return inValidPasswordMsg;
    }

}
