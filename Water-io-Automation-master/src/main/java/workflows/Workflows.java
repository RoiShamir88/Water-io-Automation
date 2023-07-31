package workflows;

import io.appium.java_client.AppiumBy;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;

public class Workflows extends CommonOps {
    @Step("Log in")
    public static void login() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("English"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("הבא"))).click();
        wait.until(ExpectedConditions.elementToBeClickable(AppiumBy.accessibilityId("I'm already a member, Sign in"))).click();
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//android.widget.EditText"))).get(0).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//android.widget.EditText"))).get(0).sendKeys("wiotest@test.com");
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//android.widget.EditText"))).get(1).click();
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//android.widget.EditText"))).get(1).sendKeys("Aa3334444");
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//android.view.View[@content-desc='Sign in'])[2]"))).click();
//        Thread.sleep(10000);
//        Dimension screenSize = mobileDriver.manage().window().getSize();
//        int screenWidth = screenSize.getWidth();
//        int screenHeight = screenSize.getHeight();
//        int x = screenWidth / 2; // Horizontal center of the screen
//        int y = screenHeight - 1; // Bottom of the screen
//        mobileDriver.executeScript("mobile: clickGesture", Map.of(
//                "x", x,
//                "y", y));
    }
}


