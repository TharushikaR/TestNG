import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

public class DatePicker2 {
    public static void main(String[] args) throws InterruptedException {

        String month="March 2023";
        String day="23";

        System.setProperty("webdriver.chrome.driver", "C://Intervest//My Work//Selenium//chromedriver_win32//chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.expedia.ca/");

        driver.findElement(By.xpath("//*[@id='d1-btn']")).click();
        Thread.sleep(2000);

        while (true) {
            String monthText = driver.findElement(By.xpath("//div[@class='uitk-layout-flex uitk-layout-flex-justify-content-space-between uitk-date-picker-menu-pagination-container'][contains(.,'Previous monthNext month')]")).getText();


            //div[contains(@class,'uitk-layout-flex uitk-layout-flex-justify-content-space-between uitk-date-picker-menu-pagination-container')]

            //div[@class='uitk-layout-flex uitk-layout-flex-justify-content-space-between uitk-date-picker-menu-pagination-container']

            //div[@class='uitk-layout-flex uitk-layout-flex-justify-content-space-between uitk-date-picker-menu-pagination-container'][contains(.,'Previous monthNext month')]

            //*[@id="app-layer-datepicker-check-in-out-start"]/div[2]/div/div/div[2]/div/div[2]/h2
            //h2[@class='uitk-date-picker-month-name uitk-type-medium'][contains(.,'January 2023')]
            //h2[@class='uitk-date-picker-month-name uitk-type-medium'][contains(.,'January 2023')]

            //*[@id="app-layer-datepicker-check-in-out-start"]/div[2]/div/div/div[2]/div/div[2]/h2 //wrong
            if (monthText.equals(month)){
                break;
            }else {
                Thread.sleep(1000);
                driver.findElement(By.xpath("//button[@data-stid='date-picker-paging'][contains(.,'Next month')]")).click();
                //*[@id="nextMonth-title"]
                ////*[@id="wizard-hotel-pwa-v2-1"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[1]/button[2]/svg
            }
        }

        Thread.sleep(1000);
        driver.findElement(By.xpath("//button[@aria-label='Mar 23, 2023 selected, current check in date.']")).click();

        //driver.findElement(By.xpath("//*[@id=\"fadein\"]/div[8]/div[1]/table/tbody/tr[4]/td[contains(text(),"+day+")]")).click();
        //*[@id="fadein"]/div[8]/div[1]/table/tbody/tr[4]/td[contains(text(),'23')]

        //button[@aria-label='Mar 23, 2023 selected, current check in date.']

        //*[@id="wizard-hotel-pwa-v2-1"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr[4]/td[5]

        //*[@id="wizard-hotel-pwa-v2-1"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr[4]/td[5]/button

        //*[@id="wizard-hotel-pwa-v2-1"]/div[2]/div[2]/div/div/div[1]/div/div[2]/div/div[1]/div[2]/div[1]/table/tbody/tr[4]/td[5]/button[@aria-label='Mar 23, 2023 selected, current check in date.']
    }
}
