package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.github.ashwith.flutter.FlutterElement;
import org.openqa.selenium.support.PageFactory;
import utilities.CommonOps;

public class History extends CommonOps {
    private AppiumDriver mobileDriver;
    public History(AppiumDriver mobileDriver) {
        this.mobileDriver = mobileDriver;
//        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
    }

    public FlutterElement hydrationHistoryTable = finder.byValueKey("table_hydration_history");


}
