import org.testng.Assert;
import org.testng.annotations.Test;

public class ListenerLoginTest {

    @Test
    void loginByEmail(){
        System.out.println("Login by email");
        Assert.assertEquals("Test","Test"); //True
    }

    @Test
    void loginByFacebook(){
        System.out.println("Login by Facebook");
        Assert.assertEquals("test","TEST"); //false
    }
}

    /*@Test(enabled = false)
    void loginByFacebook(){
        System.out.println("Login by Facebook");
        Assert.assertEquals("test","TEST"); //false
    }*/
