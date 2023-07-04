package utilities;

import io.qameta.allure.Attachment;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.File;

public class Listeners extends CommonOps implements ITestListener {
    public void onStart(ITestContext execution){
        System.out.println("------------------Starting Execution-----------------");
    }

    public void onFinish(ITestContext execution){
        System.out.println("------------------Execution Ended-----------------");
    }

    public void onTestStart(ITestResult test){
        System.out.println("------------------Starting Test: " + test.getName() + "-----------------");
    }

    public void onTestSuccess(ITestResult test) {
        System.out.println("------------------Test: " + test.getName() + " Passed-----------------");

        if (!getData("PlatformName").equalsIgnoreCase("api")) {
            //Stop recording
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            //Delete recorded file
            File file = new File("./test-recordings/" + test.getName() + ".avi");
            if (file.delete())
                System.out.println("File deleted successfully");
            else
                System.out.println("Failed to delete file");
        }
    }

    public void onTestFailure(ITestResult test) {
        System.out.println("------------------Test: " + test.getName() + " Failed-----------------");

        if (!getData("PlatformName").equalsIgnoreCase("api")) {
            try {
                MonteScreenRecorder.stopRecord();
            } catch (Exception e) {
                e.printStackTrace();
            }
            saveScreenshot();
        }
    }

    public void onTestFailedButWithinSuccessPercentage(ITestResult test) {
        System.out.println("------------------Test: " + test.getName() + " Failed but within success rate-----------------");
    }

    public void onTestSkipped(ITestResult test){
        System.out.println("------------------Skipped Test: " + test.getName() + "-----------------");
    }

    @Attachment(value = "Page screenshot", type = "Image/png")
    public byte[] saveScreenshot(){
        if(!getData("PlatformName").equalsIgnoreCase("mobile"))
            return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
        else
            return ((TakesScreenshot)mobileDriver).getScreenshotAs(OutputType.BYTES);
    }
}
