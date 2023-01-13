import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestNG_5 {

    SoftAssert softAssert1=new SoftAssert();
    SoftAssert softAssert2=new SoftAssert();

    @Test
    void demoTest1(){
        softAssert1.assertEquals("welcome","w"); //false-failed
        softAssert1.assertAll();
    }

    @Test
    void demoTest2(){
        softAssert2.assertEquals("welcome","welcome"); //true-passed
        softAssert2.assertAll();
    }
}
