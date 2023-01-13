import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.List;

public class GoogleSearchTest {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Intervest//My Work//Selenium//chromedriver_win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.google.com/");

        Thread.sleep(2000);
        driver.findElement(By.xpath("//input[@name=\"q\"]")).sendKeys("Java");

        Thread.sleep(10000);
        String listWebElement="//ul[@role='listbox']//li/descendant::div[@class='pcTkSc']";

        List<WebElement> list= driver.findElements(By.xpath(listWebElement));
        System.out.println(list.size());
        for (int i=0;i< list.size();i++){
            String listItem=list.get(i).getText();

            System.out.println(listItem);

            if (listItem.contains("Javascript")){
                list.get(i).click();
                break;
            }
        }
        Thread.sleep(5000);
        driver.close();
    }
}
