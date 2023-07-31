package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonOps;

public class History extends CommonOps {
    private AppiumDriver mobileDriver;
    public History(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
//        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }






}
