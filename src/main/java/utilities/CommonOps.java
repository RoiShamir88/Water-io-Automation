package utilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.github.ashwith.flutter.FlutterFinder;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import io.appium.java_client.remote.SupportsContextSwitching;


import static io.appium.java_client.remote.AndroidMobileCapabilityType.RESET_KEYBOARD;
import static io.appium.java_client.remote.AndroidMobileCapabilityType.UNICODE_KEYBOARD;
import static io.appium.java_client.remote.MobilePlatform.ANDROID;

public class CommonOps extends Base{

    public static String getData (String nodeName)
    {
        DocumentBuilder dBuilder;
        Document doc = null;
        File fXmlFile = new File("./Configuration/DataConfig.xml");
        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        try {
            dBuilder = dbFactory.newDocumentBuilder();
            doc = dBuilder.parse(fXmlFile);
        }
        catch(Exception e) {
            System.out.println("Exception in reading XML file: " + e);
        }
        doc.getDocumentElement().normalize();
        return doc.getElementsByTagName(nodeName).item(0).getTextContent();
    }

    public static void initMobile() throws MalformedURLException {
                uiAutomator2Options
                .setPlatformName(ANDROID)
                .setUdid("ZPGUJ76XUWQGJRKJ")
                .setPlatformVersion("12")
                .setAutoGrantPermissions(true)
                .setNoReset(true)
                .setNewCommandTimeout(Duration.ofMinutes(5))
                .setAppActivity(".MainActivity")
                .setAppPackage("io.water.hydration")
                .setAutomationName("Flutter")
                .amend(UNICODE_KEYBOARD, false)
                .amend(RESET_KEYBOARD, true);
        mobileDriver = new AndroidDriver(new AppiumServiceBuilder()
//        mobileDriver = new AppiumDriver(new AppiumServiceBuilder()
                .usingPort(4723)
                .withIPAddress("127.0.0.1")
                .build(), uiAutomator2Options);
        finder = new FlutterFinder(mobileDriver);
        ManagePages.pageObjects();
        mobileDriver.manage().timeouts().implicitlyWait(Long.parseLong(getData("Timeout")), TimeUnit.SECONDS);
        wait = new WebDriverWait(mobileDriver, Duration.ofSeconds(Long.parseLong(getData("Timeout"))));
        ((SupportsContextSwitching) mobileDriver).getContextHandles();
    }


        @BeforeClass
        public void startSession () throws Exception {
//        if(getData("PlatformName").equalsIgnoreCase("web"))
//            initBrowser(getData("BrowserName"));
            if (getData("PlatformName").equalsIgnoreCase("mobile"))
                initMobile();
//        else if(getData("PlatformName").equalsIgnoreCase("api"))
//            initAPI();
//        else if(getData("PlatformName").equalsIgnoreCase("electron"))
//            initElectron();
            else
                throw new RuntimeException("Invalid platform name");

            softAssert = new SoftAssert();
//            screen = new Screen();
        }

        @BeforeMethod
        public void beforeMethod (Method method){
            if (!getData("PlatformName").equalsIgnoreCase("api")) {
                try {
                    MonteScreenRecorder.startRecord(method.getName());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }

        @AfterMethod
        public void afterMethod () {
            if (getData("PlatformName").equalsIgnoreCase("web"))
                driver.get(getData("LoggingUrl"));
//        else if(getData("PlatformName").equalsIgnoreCase("electron"))
//            ElectronFlows.emptyList();

        }

        @AfterClass
        public void endSession () {
            mobileDriver.quit();
        }


}


