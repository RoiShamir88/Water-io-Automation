package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.github.ashwith.flutter.FlutterFinder;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

public class Base {


    //---------------------------------------------General
    protected  static WebDriverWait wait;
    protected  static Actions action;
    protected  static SoftAssert softAssert;
//    protected static Screen screen;


    //----------------------------------------------Mobile
    protected static AppiumDriver mobileDriver;
    protected static AndroidDriver driver;
    protected static DesiredCapabilities dc = new DesiredCapabilities();
    protected static UiAutomator2Options uiAutomator2Options = new UiAutomator2Options();
    protected static FlutterFinder finder;



    //----------------------------------------------Page objects
    protected static pageObjects.MainPage main;
    protected static pageObjects.History history;
    protected static pageObjects.NavigationTab navigationTab;
    protected static pageObjects.Settings settings;




}
