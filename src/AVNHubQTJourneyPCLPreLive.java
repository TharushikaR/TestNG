import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import java.time.Duration;

//PCL-QT
public class AVNHubQTJourneyPCLPreLive {

    @Test//(invocationCount = 4)
    void AVNHubQTJourneyPCLPreLivePolicy() throws Exception {
        //ScreenRecorderUtils2.startRecord("method_2");

        System.setProperty("webdriver.marionatte.driver", "C://Users//User//IdeaProjects//NEW//QuoteJourney//lib//geckodriver-v0.32.0-win32//geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://uat-hub.avantitravelinsurance.co.uk/avanti/login");

        WebElement varUserName= driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement varPassword= driver.findElement(By.xpath("//*[@id=\"password\"]"));

        if (varUserName.isDisplayed() && varUserName.isEnabled()){
            varUserName.sendKeys("stay");
        }
        if (varPassword.isDisplayed() && varPassword.isEnabled()){
            varPassword.sendKeys("adm1n@Avno2");
        }

        driver.findElement(By.xpath("/html/body/div[1]/div/div[2]/form/fieldset/div[2]/input")).click(); //submit button

        driver.findElement(By.xpath("/html/body/div[1]/aside/div/ul/li[1]/ul/li[2]/a")).click(); //click New MO Quote

        Thread.sleep(1000);
        driver.switchTo().frame("externalApp");
        //-------------organizer details-------------------
        Select orgTitle=new Select(driver.findElement(By.xpath("//*[@id=\"title\"]")));
        orgTitle.selectByVisibleText("Ms");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"organiserDTOFirstName\"]")).sendKeys("Tharushi");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"organiserDTOlastName\"]")).sendKeys("Unification");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"dateOfBirth\"]")).sendKeys("09/08/1995");
        Thread.sleep(1000);
        Select orgCountry=new Select(driver.findElement(By.xpath("//*[@id=\"country\"]")));
        orgCountry.selectByVisibleText("United Kingdom");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"postCode\"]")).sendKeys("NN47YB");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"firstLineOfAddress\"]")).sendKeys("Britannia House");
        driver.findElement(By.xpath("//*[@id=\"secondLineOfAddress\"]")).sendKeys("Rushmills");
        driver.findElement(By.xpath("//*[@id=\"city\"]")).sendKeys("Northampton");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"dayTimeTelephone\"]")).sendKeys("01234567890");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("prelivetharushi2023@gmail.com");

        Thread.sleep(1000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"tick_to_confirm_organiser_details\"]"));

        Thread.sleep(1000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"tick_to_confirm_marketing_preferences\"]"));
        Thread.sleep(1000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"organiserDetailsSubmitBtn\"]"));


        //-------------Eligibility-------------------

        WebDriverWait wait = new WebDriverWait (driver, Duration.ofSeconds(15));
        WebElement trFrom = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//label[@for='fld-travel-UK1'][contains(.,'United Kingdom')]")));
        trFrom.click();

        WebDriverWait wait2 = new WebDriverWait (driver, Duration.ofSeconds(15));
        WebElement custEligible = wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"residencyEligibilityYes\"]")));
        custEligible.click();

        WebDriverWait wait3 = new WebDriverWait (driver, Duration.ofSeconds(15));
        WebElement terProNo = wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[2]/div/form/fieldset/section[3]/div[2]/div/div/div/div/div/div[2]/label/span")));
        terProNo.click();

        Thread.sleep(1000);
        clickElementWithJS(driver,By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[2]/div/form/fieldset/div/div/div/div/div/div[3]/button"));

        //-------------Trip details-------------------
        WebDriverWait wait4 = new WebDriverWait (driver, Duration.ofSeconds(15));
        WebElement policyType = wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"type-amt\"]")));
        policyType.click();

        Thread.sleep(1000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"WORLD_HR\"]"));


        Thread.sleep(1000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"cruise-yes\"]"));

        Thread.sleep(1000);
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[3]/div/section/form/fieldset/div[8]/div[2]/div[1]/div/div/div[1]/img")).click();
        driver.findElement(By.xpath("/html/body/div[82]/div/a[2]/span")).click();
        driver.findElement(By.xpath("/html/body/div[82]/div/div/select[2]")).click();
        driver.findElement(By.xpath("/html/body/div[82]/table/tbody/tr[4]/td[3]/a")).click();


        Thread.sleep(1000);
        WebElement tripDuration=driver.findElement(By.xpath("//*[@id=\"duration\"]"));
        tripDuration.sendKeys("10");

        Thread.sleep(1000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"fcdo-yes\"]"));

        Thread.sleep(1000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"fcdo-travel-advice-yes\"]"));

        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"cancellationCoverRequested\"]")).sendKeys("10000");

        Thread.sleep(1000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"golf-yes\"]"));

        Thread.sleep(1000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"tripDetailSubmitBtn\"]"));

        //-------------Travellers details-------------------

        WebDriverWait wait6 = new WebDriverWait (driver, Duration.ofSeconds(15));
        WebElement trType = wait6.until(ExpectedConditions.elementToBeClickable(By.xpath(" //*[@id=\"cover-individual-btn\"]")));
        trType.click();

        Thread.sleep(1000);
        Select trNo=new Select(driver.findElement(By.xpath("//*[@id=\"noOfTravellers\"]")));
        trNo.selectByVisibleText("1");


        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"baggageCoverRequested\"]")).sendKeys("5000");

        Thread.sleep(1000);
        Select trExWv=new Select(driver.findElement(By.xpath("//*[@id=\"excessWaiverCoverRequested\"]")));
        trExWv.selectByIndex(1);

        Thread.sleep(1000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"gadget-yes\"]"));

        Thread.sleep(1000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"travellerUpdateBtn\"]"));

        //-------------Medical-------------------

        Thread.sleep(5000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"medical-no\"]"));

        Thread.sleep(5000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"covid-no\"]"));

        Thread.sleep(2000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"medicalDetailsNextBtn\"]"));

        //-------------customer acknowledge pop-up-------------------

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"autoRenewalCoverDetailsChecklistAcceptCheckbox\"]")).click();

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"autoRenewalCoverDetailsChecklistPopupOkBtn\"]")).click();

        //-------------price presentation-------------------

        Thread.sleep(5000);
        driver.findElement(By.xpath("//*[@id=\"ANNUAL_MULTI_TRIP_DELUXE_topBtn\"]")).click();

        Thread.sleep(5000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"ppContinueBtn\"]"));

        Thread.sleep(5000);
        //driver.findElement(By.xpath("//*[@id=\"cancellationCoverChangeSubmit\"]")).click();
        clickElementWithJS(driver,By.xpath("//*[@id=\"cancellationCoverChangeSubmit\"]"));

        //-------------payment-------------------

        Thread.sleep(10000);
        Select cardType=new Select(driver.findElement(By.xpath("//*[@id=\"creditCardType\"]")));
        cardType.selectByVisibleText("Visa Credit");


        Thread.sleep(5000);
        clickElementWithJS(driver,By.xpath("//input[contains(@value,'SPREAD_THE_COST')]"));

        Thread.sleep(5000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"purchasePolicyButton\"]"));


        //-------------premium credit scripting-------------------
        Thread.sleep(2000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"pclPaymentDoneByUkAccountHolderYes\"]"));

        Thread.sleep(2000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"pclPaymentDoneByOrganiserAccountYes\"]"));

        Thread.sleep(2000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"pclTermsAndConditionNo\"]"));

        Thread.sleep(2000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"pclTermsCondSubmitId\"]"));

        driver.switchTo().defaultContent();
        Thread.sleep(5000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"confirmPaymentBtn\"]"));


   /*     driver.switchTo().frame("externalApp");
        WebDriverWait waitcardHolderName = new WebDriverWait (driver, Duration.ofSeconds(20));
        WebElement cardHolderName = waitcardHolderName.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='cardholderName']")));
        cardHolderName.sendKeys("Test Card");

        Thread.sleep(2000);
        String visaCardNo= "4111 1111 1111 1111";
        WebElement cardNumber= driver.findElement(By.xpath("//*[@id=\"cardNumber\"]"));
        JavascriptExecutor js= (JavascriptExecutor) driver;
        js.executeScript("arguments[1].value = arguments[0]; ", visaCardNo, cardNumber);

        Thread.sleep(2000);
        Select expDate = new Select(driver.findElement(By.xpath("//*[@id=\"expiryMonth\"]"))); // card exp date
        expDate.selectByVisibleText("5");

        Thread.sleep(2000);
        Select expYear = new Select(driver.findElement(By.xpath("//*[@id=\"expiryYear\"]"))); // card exp year
        expYear.selectByVisibleText("30");

        Thread.sleep(2000);
        WebElement cardSecNo=driver.findElement(By.xpath("//*[@id=\"csc\"]")); //enter security no.
        if (cardSecNo.isDisplayed() && cardSecNo.isEnabled()){
            cardSecNo.sendKeys("111");
        }

        Thread.sleep(2000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"btnSubmit\"]"));*/

        /*Thread.sleep(2000);
        WebElement QTNum= driver.findElement(By.xpath("//*[@id=\"quoteRefId\"]"));
        System.out.println(QTNum.toString());

        driver.quit();*/
      //  Thread.sleep(2000);
      //  WebElement QTNum= driver.findElement(By.xpath("//*[@id=\"quoteRefId\"]"));
      //  System.out.println(QTNum.getText());

      //  Thread.sleep(2000);
      //  driver.close();

       // ScreenRecorderUtils2.stopRecord();

    }

    public static void clickElementWithJS(WebDriver driver, By locator) {
        String jsClickCode = "arguments[0].scrollIntoView(true); arguments[0].click();";
        try {
            WebElement elementToClick = driver.findElement(locator);
            ((JavascriptExecutor) driver).executeScript(jsClickCode, elementToClick);
        } catch(Exception e) {
            System.out.println("Element could not be clicked.. "  + e.getMessage());
        }
    }

    /*public static void scrollIntoView(WebElement element,WebDriver driver){
        JavascriptExecutor js=((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }*/

    }

