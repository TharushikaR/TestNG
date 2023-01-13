/*
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;

public class LoginTestOnWindowsusingChrome {
    WebDriver driver;

    @Test(priority = 1)
    void setup(){
        String nodeURL="";

        DesiredCapabilities cap=DesiredCapabilities.chrome();
        cap.setBrowserName("chrome");
        cap.setPlatform(Platform.WIN10);

        System.setProperty("webdriver.chrome.driver", "C://Intervest//My Work//Selenium//chromedriver_win32//chromedriver.exe");
        driver=new RemoteWebDriver(new URL(nodeURL),cap);
    }

    @Test(priority = 2)
    void login(){
        driver.get("https://prelive-my.staysure.co.uk/signin");

        driver.findElement(By.name("username")).sendKeys("livetesttharushiunification@gmail.com");
        driver.findElement(By.name("password")).sendKeys("Rathnayaka@1995");
        driver.findElement(By.id("signInBtn")).click();

        String capText=driver.findElement(By.xpath("//*[@id='header_home']/img[1]")).getText();

        if (capText.contains("MyStaysure")){
            System.out.println("Test Passed");
        }else {
            System.out.println("Test Failed");
        }
    }
}
*/
