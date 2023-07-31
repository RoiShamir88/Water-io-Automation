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
    public FlutterElement main_pluse = finder.byValueKey("button.app.bar");
    public FlutterElement btn_play = finder.byValueKey("playButtonBottle");
    public FlutterElement graph = finder.byValueKey("graphButton");
    public FlutterElement test1 = finder.byValueKey("'test.button.page.1");
    public FlutterElement test2 = finder.byValueKey("'test.button.2");
    public FlutterElement test3 = finder.byValueKey("'test.button.3");
    public FlutterElement test4 = finder.byValueKey("'test.button.cap.3");
    public FlutterElement test5 = finder.byValueKey("'test.button.settings");
    public FlutterElement test6 = finder.byValueKey("'test.button.ink.settings");

    public FlutterElement incrementButton2 = finder.byValueKey("incrementButton.2");



//    public FlutterElement gesture_1 = finder.byValueKey("list.view.item.gesture.1");
//    public FlutterElement btn_1 = finder.byValueKey("list.view.item.button.1");
//    public FlutterElement gesture_2 = finder.byValueKey("list.view.item.gesture.2");
//    public FlutterElement btn_2 = finder.byValueKey("list.view.item.button.2");
//    public FlutterElement gesture_3 = finder.byValueKey("list.view.item.gesture.3");
//    public FlutterElement btn_3 = finder.byValueKey("list.view.item.button.3");
//    public FlutterElement btn_ok = finder.byValueKey("alert.button.ok");
//    public FlutterElement tab_bar = finder.byValueKey("tab.bar");
//    public FlutterElement ink = finder.byValueKey("list.view.item.ink.1");





}
