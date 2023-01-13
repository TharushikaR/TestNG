import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class parallelTesting2 {

    WebDriver driver;

    @BeforeClass
    void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
    }

    @Test(priority = 1)
    void testLogo(){
        try {
            boolean status=driver.findElement(By.xpath("/html/body/div[1]/div[1]/div/div[1]/div/div[1]/img")).isDisplayed();
            Assert.assertTrue(status);
            //Assert.assertEquals(status,true);
        }catch (Exception e){
            Assert.fail();
        }

    }

    @Test(priority = 2)
    void testHomePageTitle(){
        Assert.assertEquals(driver.getTitle(),"OrangeHRM","Both Titles matched");
    }


    @AfterClass
    void closeApp(){
        driver.quit();
    }
}
