import org.testng.annotations.Test;

public class parallelTesting {

    @Test(invocationCount = 10)
    void test(){
        System.out.println("testing...");
    }
}
