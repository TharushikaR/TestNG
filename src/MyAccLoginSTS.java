import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class MyAccLoginSTS {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C://Users//User//IdeaProjects//NEW//QuoteJourney//lib//chromedriver_win32//chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://uat-my.staysure.co.uk/signin");

        WebElement varUserName= driver.findElement(By.xpath("//*[@id=\"username\"]"));
        WebElement varPassword= driver.findElement(By.xpath("//*[@id=\"password\"]"));

        if (varUserName.isDisplayed() && varUserName.isEnabled()){
            varUserName.sendKeys("livetesttharushiunification@gmail.com");
        }
        if (varPassword.isDisplayed() && varPassword.isEnabled()){
            varPassword.sendKeys("Rathnayaka@1995");
        }
        driver.findElement(By.xpath("//*[@id=\"signInBtn\"]")).click();

        driver.findElement(By.xpath("/html/body/div[4]/div/div[2]/div/div[2]/a")).click();
        driver.findElement(By.xpath("//*[@id=\"getQuoteInMyQuotes\"]")).click();

        //System.out.println(driver.getCurrentUrl());

        String currentURL;

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        if (driver.findElement(By.xpath("//*[@id=\"getQuoteInMyQuotes\"]")).isDisplayed()) {
            String previousURL = driver.getCurrentUrl();
            driver.findElement(By.xpath("//*[@id=\"getQuoteInMyQuotes\"]")).click();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

            ExpectedCondition<Boolean> e = d -> {
                assert d != null;
                return (!Objects.equals(d.getCurrentUrl(), previousURL));
            };

            wait.until(e);
            currentURL = driver.getCurrentUrl();
            System.out.println(currentURL);

            //----------About your travel policy---------------------------
            Thread.sleep(1000);
            driver.findElement(By.xpath("//*[@for=\"fld-cover-annualytrip\"]")).click(); //select AMT policy
            Thread.sleep(1000);
            clickElementWithJS(driver, By.xpath("//*[@id='fld-cruise-yes']")); //select cruise as yes
            Thread.sleep(1000);
            WebElement valueTravellingTo = driver.findElement(By.xpath("//*[@id='fld-travel-UK1']")); //select from location
            Actions actionsTravellingTo = new Actions(driver);
            actionsTravellingTo.moveToElement(valueTravellingTo).click().build().perform();

            Thread.sleep(1000);
            Select annualLocation = new Select(driver.findElement(By.xpath("//*[@id='toLocationAnnual']"))); //select to locations
            annualLocation.selectByVisibleText("Worldwide: All Countries");

            Thread.sleep(1000);
            WebElement valueAlreadyBooked = driver.findElement(By.xpath("//*[@id='fld-trip-already-booked-true']")); //select already booked-yes
            scrollIntoView(valueAlreadyBooked, driver);
            Thread.sleep(1000);
            WebElement valueDeptDate = driver.findElement(By.xpath("//*[@id='datepicker-departure-text']")); //select dept date
            valueDeptDate.sendKeys("03/03/2023");
            Thread.sleep(1000);
            clickElementWithJS(driver, By.xpath("//*[@id='fld-cover-individual']")); //select individual cover
            Thread.sleep(1000);
            WebElement travellerAge = driver.findElement(By.xpath("//*[@id='traveler_age_1']")); //enter traveller age
            if (travellerAge.isDisplayed() && travellerAge.isEnabled()) {
                travellerAge.sendKeys("30");
            }

            //----------Your basic details---------------------------
            Thread.sleep(1000);
            Select orgTitle = new Select(driver.findElement(By.xpath("//*[@id='organiserTitle']"))); //select organizer title
            orgTitle.selectByVisibleText("Ms");
            Thread.sleep(1000);
            WebElement fName = driver.findElement(By.xpath("//*[@id='firstname']")); //enter organizer first name
            if (fName.isDisplayed() && fName.isEnabled()) {
                fName.sendKeys("Tharushi");
            }
            Thread.sleep(1000);
            WebElement lName = driver.findElement(By.xpath("//*[@id='lastname']")); //enter organizer surname
            if (lName.isDisplayed() && lName.isEnabled()) {
                lName.sendKeys("Unification");
            }
            Thread.sleep(1000);
            WebElement orgEmail = driver.findElement(By.xpath("//*[@id='email']")); //enter email
            if (orgEmail.isDisplayed() && orgEmail.isEnabled()) {
                orgEmail.sendKeys("livetesttharushiunification@gmail.com");
            }
            Thread.sleep(1000);
            WebElement orgTelNo = driver.findElement(By.xpath("//*[@id='dayTimeTelephone']")); //enter Tel.No.
            if (orgTelNo.isDisplayed() && orgTelNo.isEnabled()) {
                orgTelNo.sendKeys("12341567890");
            }
            Thread.sleep(1000);
            WebElement orgPC = driver.findElement(By.xpath("//*[@id='postcode']")); //enter postal code
            if (orgPC.isDisplayed() && orgPC.isEnabled()) {
                orgPC.sendKeys("NN47YB");
            }

            //--------------------------Travel eligibility statement---------------------
            Thread.sleep(1000);
            WebElement valueBtnSubmit = driver.findElement(By.xpath("//*[@id='btnSubmit']")); //click submit button
            scrollIntoView(valueBtnSubmit, driver);
            valueBtnSubmit.click();


            // Thread.sleep(1000);
            //  WebElement valueCtnQt = driver.findElement(By.xpath("//*[@id='my-account-continue2']")); //click
            //  scrollIntoView(valueCtnQt, driver);
            //  valueCtnQt.click();



            /* go to next page - Your details page*/
            String currentURL1;

            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(30));

            if (driver.findElement(By.xpath("//*[@id='btnSubmit']")).isDisplayed()) {
                String previousURL1 = driver.getCurrentUrl();
                driver.findElement(By.xpath("//*[@id='btnSubmit']")).click();
                driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

                ExpectedCondition<Boolean> e1 = d1 -> {
                    assert d1 != null;
                    return (!Objects.equals(d1.getCurrentUrl(), previousURL1));
                };

                wait1.until(e1);
                currentURL1 = driver.getCurrentUrl();
                System.out.println(currentURL1);


                //-------------Medical Disclaimer Accept-----------------
                Thread.sleep(1000);
                clickElementWithJS(driver, By.xpath("//*[@id='checkbox-accept']")); //Read & Accept Medical Disclaimer

                //-------------------Traveller Details--------------------------
                Thread.sleep(1000);
                Select travellerTitle = new Select(driver.findElement(By.xpath("//*[@id='traveler_title_0']"))); //Traveller title
                travellerTitle.selectByVisibleText("Ms");
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id='traveler_first_name_0']")).sendKeys("Tharushi"); //Traveller first name
                Thread.sleep(1000);
                driver.findElement(By.xpath("//*[@id='traveler_last_name_0']")).sendKeys("Unification"); //Traveller last name

                //-------------------Medical Declaration-----------------------------
                Thread.sleep(1000);
                clickElementWithJS(driver, By.xpath("//*[@id='radio-no0']")); //select whether you have any pre-existing medical conditions


                Thread.sleep(1000);
                WebElement valueBtnNext = driver.findElement(By.xpath("//input[@value=\"Next\"]")); //click next button
                Actions actionsBtnNext = new Actions(driver);
                actionsBtnNext.moveToElement(valueBtnNext).click().build().perform();

                //-------------------Pop Up - Important Please Read-----------------------------
                WebElement valueBtnCnt = driver.findElement(By.xpath("//*[@id='medical_dec_submit_btn']")); //click continue button
                Actions actionsBtnCnt = new Actions(driver);
                actionsBtnCnt.moveToElement(valueBtnCnt).click().build().perform();


                /* go to next page - Your quote page*/
                String currentURL2;

                WebDriverWait wait2 = new WebDriverWait(driver, Duration.ofSeconds(30));

                if (driver.findElement(By.xpath("//*[@id='medical_dec_submit_btn']")).isDisplayed()) {
                    String previousURL2 = driver.getCurrentUrl();
                    clickElementWithJS(driver, By.xpath("//*[@id='medical_dec_submit_btn']"));
                    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

                    ExpectedCondition<Boolean> e2 = d2 -> {
                        assert d2 != null;
                        return (!Objects.equals(d2.getCurrentUrl(), previousURL2));
                    };

                    wait2.until(e2);
                    currentURL2 = driver.getCurrentUrl();
                    System.out.println(currentURL2);

                    Thread.sleep(1000);
                    clickElementWithJS(driver, By.xpath("//*[@id='ANNUAL_MULTI_TRIP_COMPREHENSIVE_BTN']"));
                    Thread.sleep(1000);
                    clickElementWithJS(driver, By.xpath("//*[@id='OEContinueBtn']"));
                    Thread.sleep(1000);
                    clickElementWithJS(driver, By.xpath("//*[@id='cancellationCoverChangeSubmit']"));

                    /* go to next page - Review page*/
                    String currentURL3;

                    WebDriverWait wait3 = new WebDriverWait(driver, Duration.ofSeconds(30));

                    if (driver.findElement(By.xpath("//*[@id='cancellationCoverChangeSubmit']")).isDisplayed()) {
                        String previousURL3 = driver.getCurrentUrl();
                        clickElementWithJS(driver, By.xpath("//*[@id='cancellationCoverChangeSubmit']"));
                        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

                        ExpectedCondition<Boolean> e3 = d3 -> {
                            assert d3 != null;
                            return (!Objects.equals(d3.getCurrentUrl(), previousURL3));
                        };

                        wait3.until(e3);
                        currentURL3 = driver.getCurrentUrl();
                        System.out.println(currentURL3);


                        Thread.sleep(1000);
                        Select orgTitleReview = new Select(driver.findElement(By.xpath("//*[@id='organiserTitle']"))); //organizer title
                        orgTitleReview.selectByVisibleText("Ms");
                        Thread.sleep(1000);
                        WebElement orgFName = driver.findElement(By.xpath("//*[@id='organiserFirstName']")); //enter organizer first name
                        if (orgFName.isDisplayed() && orgFName.isEnabled()) {
                            orgFName.clear();
                            orgFName.sendKeys("Tharushi");
                        }
                        Thread.sleep(1000);
                        WebElement orgLName = driver.findElement(By.xpath("//*[@id='organiserLastName']")); //enter organizer last name
                        if (orgLName.isDisplayed() && orgLName.isEnabled()) {
                            orgLName.clear();
                            orgLName.sendKeys("Unification");
                        }

                        Thread.sleep(1000);
                        Select orgBDay = new Select(driver.findElement(By.xpath("//*[@id='day']"))); //organizer birthdate
                        orgBDay.selectByVisibleText("02");
                        Thread.sleep(1000);
                        Select orgBMonth = new Select(driver.findElement(By.xpath("//*[@id='month']"))); //organizer birth month
                        orgBMonth.selectByVisibleText("11");
                        Thread.sleep(1000);
                        Select orgBYear = new Select(driver.findElement(By.xpath("//*[@id='year']"))); //organizer birth month
                        orgBYear.selectByVisibleText("1995");

                        Thread.sleep(1000);
                        WebElement orgTelNo2 = driver.findElement(By.xpath("//*[@id='telephoneNumber']")); //enter organizer Tel No.
                        if (orgTelNo2.isDisplayed() && orgTelNo2.isEnabled()) {
                            orgTelNo2.clear();
                            orgTelNo2.sendKeys("12345567890");
                        }
                        Thread.sleep(1000);
                        WebElement orgEmail2 = driver.findElement(By.xpath("//*[@id='emailAddress']")); //enter organizer email
                        if (orgEmail2.isDisplayed() && orgEmail2.isEnabled()) {
                            orgEmail2.clear();
                            orgEmail2.sendKeys("prelive-test1-tharushiunification@gmail.com");
                        }

                        Thread.sleep(1000);
                        WebElement orgPC2 = driver.findElement(By.xpath("//*[@id='postcode']")); //enter organizer PC
                        if (orgPC2.isDisplayed() && orgPC2.isEnabled()) {
                            orgPC2.clear();
                            orgPC2.sendKeys("NN47YB");
                        }

                        Thread.sleep(1000);
                        WebElement orgFirstAdrs = driver.findElement(By.xpath("//*[@id='firstLineOfAddress']")); //enter organizer first adrs
                        if (orgFirstAdrs.isDisplayed() && orgFirstAdrs.isEnabled()) {
                            orgFirstAdrs.sendKeys("Britannia House");
                        }
                        Thread.sleep(1000);
                        WebElement orgSecondAdrs = driver.findElement(By.xpath("//*[@id='secondLineOfAddress']")); //enter organizer second adrs
                        if (orgSecondAdrs.isDisplayed() && orgSecondAdrs.isEnabled()) {
                            orgSecondAdrs.sendKeys("Rushmills");
                        }
                        Thread.sleep(1000);
                        WebElement orgCity = driver.findElement(By.xpath("//*[@id='city']")); //enter organizer city
                        if (orgCity.isDisplayed() && orgCity.isEnabled()) {
                            orgCity.sendKeys("Northampton");
                        }

                        Thread.sleep(1000);
                        Select orgCountry = new Select(driver.findElement(By.xpath("//*[@id='organizerCountry']"))); //organizer country
                        orgCountry.selectByVisibleText("United Kingdom");

                        Thread.sleep(1000);
                        clickElementWithJS(driver, By.xpath("//*[@id='arContainerOne']/div/label/input[1]"));

                        Thread.sleep(1000);
                        clickElementWithJS(driver, By.xpath("//input[@value=\"PAY_AT_ONCE\"]"));

                        Thread.sleep(1000);
                        clickElementWithJS(driver, By.xpath("//*[@id='checkbox-declarations']"));
                        Thread.sleep(1000);
                        clickElementWithJS(driver, By.xpath("//*[@id='checkbox-accept']"));
                    }
                }
            }
        }
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

    public static void scrollIntoView(WebElement element,WebDriver driver){
        JavascriptExecutor js=((JavascriptExecutor) driver);
        js.executeScript("arguments[0].scrollIntoView(true);",element);
    }
}
