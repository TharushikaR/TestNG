import com.aventstack.extentreports.reporter.configuration.Theme;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class GenerateExtentReport2 {
    public WebDriver driver;
    public  ExtentHtmlReporter htmlReporter;
    public ExtentReports extent;
    public ExtentTest test;

    @BeforeTest
    public void setExtent(){
        htmlReporter=new ExtentHtmlReporter(System.getProperty("user.dir")+"/MyReport2.html");
        htmlReporter.config().setDocumentTitle("Automation Report For Web Site"); //Title of the report
        htmlReporter.config().setReportName("Functional Report"); //Name of the report
        htmlReporter.config().setTheme(Theme.DARK);

        extent=new ExtentReports();
        extent.attachReporter(htmlReporter);
        extent.setSystemInfo("Hostname","LocalHost");
        extent.setSystemInfo("OS","Windows10");
        extent.setSystemInfo("Tester Name","Tharushi");
        extent.setSystemInfo("Browser","Chrome");
    }

    @AfterTest
    public void endReport(){
        extent.flush();
    }

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "C://Intervest//My Work//Selenium//chromedriver_win32//chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://prelive-my.staysure.co.uk/signin");
    }

    @Test
    public void STSTitleTest(){
        test= extent.createTest("STSTitleTest");
        String title= driver.getTitle();
        System.out.println(title);
        Assert.assertEquals(title,"Sign In");
    }

    @Test
    public void STSLogoTest(){
        test= extent.createTest("STSLogoTest");
        Boolean status=driver.findElement(By.xpath("//*[@id=\"header_home\"]/img")).isDisplayed();
        Assert.assertTrue(status);
    }

    @Test
    public void STSLoginTest(){
        test= extent.createTest("STSLoginTest");
        test.createNode("Login with Valid Input");
        Assert.assertTrue(true);
        test.createNode("Login with Invalid Input");
        Assert.assertTrue(true);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus()==ITestResult.FAILURE){
            test.log(Status.FAIL,"TEST CASE FAILED IS "+result.getName()); //To add name in extent report
            test.log(Status.FAIL,"TEST CASE FAILED IS "+result.getThrowable()); //To add error,exception in extent report

            String screenshotPath=GenerateExtentReport2.getScreenShot(driver,result.getName());
            test.addScreenCaptureFromPath(screenshotPath); //adding screenshot
        }else if(result.getStatus()==ITestResult.SKIP){
            test.log(Status.SKIP,"Test Case SKIPPED IS "+result.getName());
        }else if (result.getStatus()==ITestResult.SUCCESS){
            test.log(Status.PASS,"Test Case PASSED IS "+result.getName());
        }
        driver.quit();
    }

    public static String getScreenShot(WebDriver driver,String screenShotName) throws IOException {
        String dateName=new SimpleDateFormat("yyyy-MM-dd-hh:mm:ss").format(new Date());
        TakesScreenshot ts=(TakesScreenshot) driver;
        File source=ts.getScreenshotAs(OutputType.FILE);

        //After execution, can see a folder "Failed Tests Screenshots" under src folder
        String destination=System.getProperty("user.dir")+"/Screenshots/"+screenShotName+dateName+".png";
        File finalDestination=new File(destination);
        FileUtils.copyFile(source,finalDestination);
        return destination;
    }

}
