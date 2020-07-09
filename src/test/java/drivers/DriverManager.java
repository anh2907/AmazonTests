package drivers;

import org.openqa.selenium.WebDriver;
public abstract class DriverManager {
    public WebDriver driver;
    protected abstract void createWebDriver();
    public void quitWebDriver(){
        if(null!=driver){
            driver.quit();
            driver = null;
        }
    }
    public WebDriver getWebDriver(){
        if(null == driver) {
            createWebDriver();
        }
        return driver;
    }
}
