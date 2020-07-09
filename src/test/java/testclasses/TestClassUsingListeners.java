package testclasses;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestClassUsingListeners {

    public WebDriver driver;
    @BeforeClass
    public void beforeClass(){
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anhntnguyen\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://letskodeit.com/");
    }
    @AfterClass
    public void afterClass(){
        driver.quit();
    }
    @Test
    public void testSuccessful(){
        System.out.println("Executing Successful Test Method");
    }
    @Test
    public void testFailed(){
        System.out.println("Executing Successful Failed Method");
        Assert.fail("Executing Failed Method");
    }
    @Test
    public void testSkipped(){
        System.out.println("Executing Successful Skipped Method");
        throw new SkipException("Executing Skipped Method");
    }

}
