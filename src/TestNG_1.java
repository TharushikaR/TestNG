import org.testng.*;
import org.testng.annotations.Test;

public class TestNG_1 {
    @Test
    void demoTest(){
        Assert.assertTrue(true); //passed
        Assert.assertEquals("welcome","Welcome"); //false-failed
        Assert.assertEquals("selenium","selenium"); //true-passed
        System.out.println("Successfully passed");
    }
}
