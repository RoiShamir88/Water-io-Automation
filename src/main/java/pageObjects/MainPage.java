package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.github.ashwith.flutter.FlutterElement;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonOps;

public class MainPage extends CommonOps {

    private AppiumDriver mobileDriver;
//
    public MainPage(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
//        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }


    public FlutterElement counter = finder.byValueKey("counter");
    public FlutterElement incrementButton = finder.byValueKey("incrementButton");
    public FlutterElement filedText = finder.byValueKey("filedText");


}
