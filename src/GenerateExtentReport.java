import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import java.io.File;
public class GenerateExtentReport {
    ExtentReports extent;   //specify the location of the report-predefined class
    ExtentTest test;        //what details should be populated in the report-predefined class

    @BeforeTest
    public void startReport(){
        extent=new ExtentReports(System.getProperty("user.dir")+"/MyReport.html",true);
        extent.addSystemInfo("Host Name","LocalHost");
        extent.addSystemInfo("Environment","QA");
        extent.addSystemInfo("User Name","Tharushi");
        extent.loadConfig(new File(System.getProperty("user.dir")+"/extent-config.xml"));
    }

    @Test
    public void demoReportPass(){
        test=extent.startTest("demoReportPass");
        Assert.assertTrue(true);
        test.log(LogStatus.PASS,"Assert Pass as condition is true.");
    }

    @Test
    public void demoReportFail(){
        test=extent.startTest("demoReportFail");
        Assert.assertTrue(false);
        test.log(LogStatus.FAIL,"Assert Fail as condition is false.");
    }

    @AfterMethod
    public void getResult(ITestResult result){
        if (result.getStatus()==ITestResult.FAILURE){
            test.log(LogStatus.FAIL,result.getThrowable());
        }
        extent.endTest(test);
    }

    @AfterTest
    public void endReport(){
        extent.flush();
    }
}
