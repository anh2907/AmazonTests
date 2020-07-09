package extentReport;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import junit.framework.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;

public class GenerateExtentReport {
    ExtentReports extent; //specify the location of the report
    ExtentTest test;// what details should be populate in the report

    @BeforeTest
    public void startReport(){
        extent = new ExtentReports(System.getProperty("user.dir")+ "/test-output/MyOwnReport.html", true);
        extent.addSystemInfo("Host Name", "Local Host");
        extent.addSystemInfo("Environment", "QA");
        extent.addSystemInfo("User name", "Anh Nguyen");
        extent.loadConfig(new File(System.getProperty("user.dir")+"\\extent-config.xml"));

    }
    @Test
    public void reportPass(){
        test = extent.startTest("ReportPassed");
        Assert.assertTrue(true);
        test.log(LogStatus.PASS, "Assert Passed as condition is true");

    }
    @Test
    public void reportFail(){
        test = extent.startTest("ReportFailed");
        Assert.assertTrue(false);
        test.log(LogStatus.FAIL,"Assert Failed as condition is false");
    }
    @AfterMethod
    public void getResult(ITestResult result){
        if(result.getStatus()==ITestResult.FAILURE)
        {
            test.log(LogStatus.FAIL, result.getThrowable());
        }
        extent.endTest(test);
    }
    @AfterTest
    public void endReport(){
        extent.flush();
    }

}

