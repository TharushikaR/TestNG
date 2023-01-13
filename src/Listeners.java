import org.testng.ITestResult;
import org.testng.TestListenerAdapter;

//ITestResult is an Interface
//TestListenerAdapter is a predefined class
//predefined methods - onTestStart/onTestSuccess/onTestFailure/onTestSkipped
//Like a method overriding in inheritance concept
public class Listeners extends TestListenerAdapter {
    public void onTestStart(ITestResult tr){
        System.out.println("Test started.");
    }

    public void onTestSuccess(ITestResult tr){
        System.out.println("Test passed.");
    }

    public void onTestFailure(ITestResult tr){
        System.out.println("Test failed.");
    }

    public void onTestSkipped(ITestResult tr){
        System.out.println("Test skipped.");
    }
}
