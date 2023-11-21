package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.github.ashwith.flutter.FlutterElement;
import utilities.CommonOps;

public class Settings extends CommonOps {
    private AppiumDriver mobileDriver;
    public Settings(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
//        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }


}
