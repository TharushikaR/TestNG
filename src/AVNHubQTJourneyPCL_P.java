import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.Test;

import java.time.Duration;

//PCL-policy
public class AVNHubQTJourneyPCL_P {
    @Test(invocationCount = 2)
    void Method_4() throws Exception {
        ScreenRecorderUtils2.startRecord("Method_4");

        System.setProperty("webdriver.marionatte.driver", "C://Users//User//IdeaProjects//NEW//QuoteJourney//lib//geckodriver-v0.32.0-win32//geckodriver.exe");

        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://uat05avn.intertrav.co.uk/avanti/login");

        WebElement varUserName= driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement varPassword= driver.findElement(By.xpath("//*[@id=\"password\"]"));

        if (varUserName.isDisplayed() && varUserName.isEnabled()){
            varUserName.sendKeys("stay");
        }
        if (varPassword.isDisplayed() && varPassword.isEnabled()){
            varPassword.sendKeys("january*27");
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
        driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("livetesttharushiunification@gmail.com");

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
        clickElementWithJS(driver,By.xpath("//*[@id=\"FR\"]"));
        Thread.sleep(1000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"IT\"]"));
        Thread.sleep(1000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"GR\"]"));
        Thread.sleep(1000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"GB\"]"));


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
        clickElementWithJS(driver,By.xpath("//*[@id=\"tripDetailSubmitBtn\"]"));

        //-------------Travellers details-------------------

        WebDriverWait wait6 = new WebDriverWait (driver, Duration.ofSeconds(15));
        WebElement trType = wait6.until(ExpectedConditions.elementToBeClickable(By.xpath(" //*[@id=\"cover-individual-btn\"]")));
        trType.click();

        Thread.sleep(1000);
        Select trNo=new Select(driver.findElement(By.xpath("//*[@id=\"noOfTravellers\"]")));
        trNo.selectByVisibleText("1");

       /* Thread.sleep(1000);
       // Select trTitle=new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[4]/div/form/fieldset/section[2]/div[2]/div/div/table/tbody/tr[1]/td[2]/select")));
        Select trTitle=new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[4]/div/form/fieldset/section[2]/div[2]/div/div/table/tbody/tr[5]/td[2]/select")));
        trTitle.selectByVisibleText("Mr");

        Thread.sleep(1000);
        //WebElement trFName=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[4]/div/form/fieldset/section[2]/div[2]/div/div/table/tbody/tr[1]/td[3]/input"));
        WebElement trFName=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[4]/div/form/fieldset/section[2]/div[2]/div/div/table/tbody/tr[5]/td[3]/input"));
        trFName.clear();
        trFName.sendKeys("Test");

        Thread.sleep(1000);
       // WebElement trLName=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[4]/div/form/fieldset/section[2]/div[2]/div/div/table/tbody/tr[1]/td[4]/input"));
        WebElement trLName=driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[4]/div/form/fieldset/section[2]/div[2]/div/div/table/tbody/tr[5]/td[4]/input"));
        trLName.clear();
        trLName.sendKeys("Unification");

        Thread.sleep(1000);
        //Select trAge=new Select(driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[4]/div/form/fieldset/section[2]/div[2]/div/div/table/tbody/tr[1]/td[5]/select")));
        Select trAge=new Select(driver.findElement(By.xpath(" /html/body/div[1]/div[2]/div/div[1]/div[4]/div/form/fieldset/section[2]/div[2]/div/div/table/tbody/tr[5]/td[5]/select")));
        trAge.selectByVisibleText("45");*/

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

       // Thread.sleep(2000);
        //driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[6]/div[1]/div[5]/div[3]/table/tbody/tr[1]/td[1]/div/span/button")).click();

       // driver.switchTo().defaultContent();
       // Thread.sleep(5000);
       // driver.findElement(By.xpath("//*[@id=\"saveQuote\"]")).click();

      //  Thread.sleep(5000);
       // driver.navigate().back();

       //Thread.sleep(5000);
       // driver.switchTo().frame("externalApp");
        Thread.sleep(5000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"ppContinueBtn\"]"));

        //Thread.sleep(5000);
        //driver.findElement(By.xpath("//*[@id=\"cancellationCoverChangeSubmit\"]")).click();
        clickElementWithJS(driver,By.xpath("//*[@id=\"cancellationCoverChangeSubmit\"]"));

        //-------------payment-------------------

        Thread.sleep(5000);
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

        //-------------Barclay card payment UI-------------------

        driver.switchTo().frame("externalApp");

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
        clickElementWithJS(driver,By.xpath("//*[@id=\"btnSubmit\"]"));

        //------------------PCL-FITS-------------------------------
       // Thread.sleep(10000);
       // clickElementWithJS(driver,By.xpath("//label[@class='radio-inline btn custom-radio focus'][contains(.,'Yes')]"));

       // clickElementWithJS(driver,By.xpath("//*[@id=\"lblAccountHolderYes\"]"));
       // driver.findElement(By.xpath("//*[@id=\"lblAccountHolderYes\"]"));
/*
        WebDriverWait y1 = new WebDriverWait (driver, Duration.ofSeconds(10));
        WebElement vy1 = y1.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"lblAccountHolderYes\"]")));
        vy1.click();

       // Thread.sleep(2000);
        //clickElementWithJS(driver,By.xpath("//label[contains(@id,'lblOnlyToAuthoriseYes')]"));
      //  driver.findElement(By.xpath("//*[@id=\"lblOnlyToAuthoriseYes\"]"));
      //  clickElementWithJS(driver,By.xpath("//*[@id=\"lblOnlyToAuthoriseYes\"]"));

        WebDriverWait y2 = new WebDriverWait (driver, Duration.ofSeconds(10));
        WebElement vy2 = y2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"lblOnlyToAuthoriseYes\"]")));
        vy2.click();

       // driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
       // clickElementWithJS(driver,By.xpath("//*[@id=\"lblAccountHolderYes\"]"));

        Thread.sleep(5000);
        WebElement nameBankAccHolder=driver.findElement(By.xpath("//*[@id=\"txtBankAccountName\"]"));
        if (nameBankAccHolder.isDisplayed() && nameBankAccHolder.isEnabled()){
            nameBankAccHolder.sendKeys("Test Holder");
        }
        Thread.sleep(2000);
        WebElement sortCode_1=driver.findElement(By.xpath("//*[@id=\"txtSortCode1\"]"));
        if (sortCode_1.isDisplayed() && sortCode_1.isEnabled()){
            sortCode_1.sendKeys("09");
        }
        Thread.sleep(2000);
        WebElement sortCode_2=driver.findElement(By.xpath("//*[@id=\"txtSortCode2\"]"));
        if (sortCode_2.isDisplayed() && sortCode_2.isEnabled()){
            sortCode_2.sendKeys("01");
        }
        Thread.sleep(2000);
        WebElement sortCode_3=driver.findElement(By.xpath("//*[@id=\"txtSortCode3\"]"));
        if (sortCode_3.isDisplayed() && sortCode_3.isEnabled()){
            sortCode_3.sendKeys("26");
        }

        Thread.sleep(2000);
        WebElement accNum=driver.findElement(By.xpath("//*[@id=\"txtBankAccountNumber\"]"));
        if (accNum.isDisplayed() && accNum.isEnabled()){
            accNum.sendKeys("02948723");
        }

        Thread.sleep(2000);
        clickElementWithJS(driver,By.xpath("//*[@id=\"btnSubmit\"]"));


        //-----------------------------------------

        Thread.sleep(2000);
        WebElement policyNum= driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/div[7]/div/div[1]/form[1]/div[6]/div[2]/div/div/div[2]/div/span"));
        System.out.println(policyNum.getText());

        Thread.sleep(2000);
        driver.close();
        */


        ScreenRecorderUtils2.stopRecord();

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

