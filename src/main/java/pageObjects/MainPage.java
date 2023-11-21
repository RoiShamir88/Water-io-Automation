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


    public FlutterElement addHydration_btn = finder.byValueKey("button_add_hydration");
    public FlutterElement addHydration500_btn = finder.byValueKey("button_add_hydration_500");
    public FlutterElement addHydration330_btn = finder.byValueKey("button_add_hydration_330");
    public FlutterElement addHydration180_btn = finder.byValueKey("button_add_hydration_180");
    public FlutterElement txt_avg_sip = finder.byValueKey("'text_avg_sip");
    public FlutterElement txt_hydrated = finder.byValueKey("text_hydrated");
    public FlutterElement text_daily_goal = finder.byValueKey("text_daily_goal");
    public FlutterElement main_btn = finder.byValueKey("button_main");





}
