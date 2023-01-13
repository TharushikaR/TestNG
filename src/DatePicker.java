import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker {
    public static void main(String[] args) throws InterruptedException {

        String month="March 2023";
        String day="23";

        System.setProperty("webdriver.chrome.driver", "C://Intervest//My Work//Selenium//chromedriver_win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://phptravels.net/");

        driver.findElement(By.xpath("//*[@id='checkin']")).click();
        Thread.sleep(2000);

        while (true) {
            String monthText = driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[8]/div[1]/table/thead/tr[1]/th[2]")).getText();
            if (monthText.equals(month)){
                break;
            }else {
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[8]/div[1]/table/thead/tr[1]/th[3]")).click();
            }
        }

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[8]/div[1]/table/tbody/tr[4]/td[contains(text(),"+day+")]")).click();
        //*[@id="fadein"]/div[8]/div[1]/table/tbody/tr[4]/td[contains(text(),'23')]
    }
}
