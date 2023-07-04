package POC;

import extensions.MobileActions;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utilities.CommonOps;

import static org.testng.Assert.assertEquals;
@Listeners(utilities.Listeners.class)
public class Test1 extends CommonOps {

    @Test(description = "Test01 - can't upload a nw post before the previous is approved")
    @Description("This test case verify a user can't send a post before the previous one is approved")
    @Step("Test")
    public void test01_verifyWaterio() throws InterruptedException {
        System.out.println(mobileDriver.executeScript("flutter:waitFor",main.counter));
        main.incrementButton.click();
        assertEquals(main.counter.getText(),"1");
//        MobileElement teset = (MobileElement) driver.findElement(By.id("settings_profile_name"));
//        String [] name = waterioMain.txt_name.toString().split(",");
//        assertTrue(waterioMain.txt_name.toString().contains("Roi"),"Name isn't Roi");
//        assertEquals(name[1], "Roi']]})");
    }
}
