import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class ScreenRcorderTestCase {
    WebDriver driver;

    @BeforeClass
    void setup(){
        System.setProperty("webdriver.chrome.driver", "C://Intervest//My Work//Selenium//chromedriver_win32//chromedriver.exe");
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test
    void verifyLinks(){

        ScreenRecorderUtils.startRecord("verifyLinks");

        //computers
        driver.findElement(By.xpath("//div[6]/div[2]/ul[1]/li[1]/a[1]")).click();
        System.out.println(driver.getTitle());
        //electronics
        driver.findElement(By.xpath("//div[6]/div[2]/ul[1]/li[2]/a[1]")).click();
        System.out.println(driver.getTitle());
        //apparelS
        driver.findElement(By.xpath("//div[6]/div[2]/ul[1]/li[3]/a[1]")).click();
        System.out.println(driver.getTitle());
        //Digital Downloads
        driver.findElement(By.xpath("//div[6]/div[2]/ul[1]/li[4]/a[1]")).click();
        System.out.println(driver.getTitle());
        //Books
        driver.findElement(By.xpath("//div[6]/div[2]/ul[1]/li[5]/a[1]")).click();
        System.out.println(driver.getTitle());
        //Jewellery
        driver.findElement(By.xpath("//div[6]/div[2]/ul[1]/li[6]/a[1]")).click();
        System.out.println(driver.getTitle());
        //Gift cards
        driver.findElement(By.xpath("//div[6]/div[2]/ul[1]/li[7]/a[1]")).click();
        System.out.println(driver.getTitle());

        ScreenRecorderUtils.stopRecord();
    }

    @AfterClass
    void tearDown(){
        driver.close();
    }
}
