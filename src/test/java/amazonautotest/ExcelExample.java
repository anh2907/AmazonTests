package amazonautotest;
import datadriven.ReadExcelFile;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class ExcelExample {
    WebDriver driver;
    XSSFWorkbook work_book;
    XSSFSheet sheet;
    @Test(dataProvider="testData")
    public void demoClass(String username, String password) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\anhntnguyen\\drivers\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.browserstack.com/users/sign_in");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.findElement(By.name("user[login]")).sendKeys(username);
        driver.findElement(By.name("user[password]")).sendKeys(password);
        //driver.findElement(By.name("commit")).click();
        //Thread.sleep(5000);
        //Assert.assertTrue(driver.getTitle().matches("BrowserStack Login | Sign Into The Best Mobile & Browser Testing Tool"), "Invalid credentials");
        System.out.println("Login successful");
    }
//    @AfterMethod
//    public void ProgramTermination() {
//        driver.quit();
//    }
    @DataProvider(name="testData")
    public Object[][] testDataExample(){
        ReadExcelFile config = new ReadExcelFile("C:\\Users\\anhntnguyen\\IdeaProjects\\AmazonTests\\src\\test\\java\\com\\testdata\\AmazonTestData.xlsx");
        int rows = config.getRowCount("Login");
//        sheet = work_book.getSheet("Login");
//        int numberOfColumns = config.countNonEmptyColumns(sheet);
//        int numberOfRows = sheet.getLastRowNum() + 1;
//        Object[][] data = new Object[numberOfRows - 1][numberOfColumns - 1];
        Object[][] data = new Object[rows][2];
        for(int i=0;i<rows;i++)
        {
            data[i][0] = config.getData("Login", i, 0);
            data[i][1] = config.getData("Login", i, 1);
        }
        return data;
    }
}
