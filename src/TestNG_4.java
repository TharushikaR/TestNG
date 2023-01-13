import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.openqa.selenium.*;

public class TestNG_4 {
    @Test
    public void loginTest(){
        System.setProperty("webdriver.chrome.driver", "C://Intervest//My Work//Selenium//chromedriver_win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();

        driver.get("https://prelive-my.staysure.co.uk/signin");

        WebElement username= driver.findElement(By.name("username"));
        WebElement password= driver.findElement(By.name("password"));

        Assert.assertFalse(username.isDisplayed());
        username.sendKeys("livetesttharushiunification@gmail.com");

        Assert.assertFalse(password.isDisplayed());
        password.sendKeys("Rathnayaka@1995");

        driver.findElement(By.id("signInBtn")).click();

        String expTitle="Home";

        Assert.assertEquals(expTitle,driver.getTitle());

        driver.quit();

    }
}
