package extensions;

//import io.appium.java_client.MobileElement;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
//import io.appium.java_client.android.AndroidDriver;
//import io.appium.java_client.android.WebElement;
import io.github.ashwith.flutter.FlutterElement;
import org.openqa.selenium.WebElement;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;
import io.qameta.allure.Step;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import utilities.CommonOps;
import java.time.Duration;
import java.util.Arrays;
import java.util.HashMap;

public class MobileActions extends CommonOps {

    @Step("Tap on element")
    public static void tap(WebElement elem){
        wait.until(ExpectedConditions.elementToBeClickable(elem));
        TouchAction action = new TouchAction((PerformsTouchActions) mobileDriver);
        action.tap((new TapOptions()).withElement(ElementOption.element(elem))).perform();
    }
    private static void tapByCoordinate(int x, int y) {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), x, y));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        mobileDriver.perform(Arrays.asList(tap));
    }


    public static void startPress(BtnPress click, FlutterElement elem, AppiumDriver driver) {
        HashMap<String, Object> stringObjectsHashMap = new HashMap<>();
        stringObjectsHashMap.put("durationMilliseconds", click.getDuration());
        stringObjectsHashMap.put("frequency", 30);
        driver.executeScript("flutter:longTap", elem, stringObjectsHashMap);
    }

    public enum BtnPress {
        CLICK(100),
        LONG_CLICK(1000);
        private final int duration;
        BtnPress(int duration) {
            this.duration = duration;
        }
        public int getDuration() {
            return duration;
        }
    }
    @Step("Swipe")
    public static void swipe(Direction dir) {
        System.out.println("swipeScreen(): dir: '" + dir + "'"); // always log your actions

        // Animation default time:
        //  - Android: 300 ms
        //  - iOS: 200 ms
        // final value depends on your app and could be greater
        final int ANIMATION_TIME = 200; // ms

        final int PRESS_TIME = 200; // ms

        int edgeBorder = 10; // better avoid edges
        PointOption pointOptionStart, pointOptionEnd;

        // init screen variables
        Dimension dims = driver.manage().window().getSize();

        // init start point = center of screen
        pointOptionStart = PointOption.point(dims.width / 2, dims.height / 2);

        switch (dir) {
            case DOWN: // center of footer
                pointOptionEnd = PointOption.point(dims.width / 2, dims.height - edgeBorder);
                break;
            case UP: // center of header
                pointOptionEnd = PointOption.point(dims.width / 2, edgeBorder);
                break;
            case LEFT: // center of left side
                pointOptionEnd = PointOption.point(edgeBorder, dims.height / 2);
                break;
            case RIGHT: // center of right side
                pointOptionEnd = PointOption.point(dims.width - edgeBorder, dims.height / 2);
                break;
            default:
                throw new IllegalArgumentException("swipeScreen(): dir: '" + dir + "' NOT supported");
        }

        // execute swipe using TouchAction
        try {
            new TouchAction((PerformsTouchActions) mobileDriver)
                    .press(pointOptionStart)
                    // a bit more reliable when we add small wait
                    .waitAction(WaitOptions.waitOptions(Duration.ofMillis(PRESS_TIME)))
                    .moveTo(pointOptionEnd)
                    .release().perform();
        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
            return;
        }

        // always allow swipe action to complete
        try {
            Thread.sleep(ANIMATION_TIME);
        } catch (InterruptedException e) {
            // ignore
        }
    }

    @Step("Pinch Element")
    public static void pinch(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        int x = elem.getLocation().getX() + elem.getSize().getWidth() / 2;
        int y = elem.getLocation().getY() + elem.getSize().getHeight() / 2;
        TouchAction finger1 = new TouchAction((PerformsTouchActions) mobileDriver);
        finger1.press(new ElementOption().withElement(elem).withCoordinates(x, y-100))
                .moveTo(new ElementOption().withElement(elem).withCoordinates(x, y-10));
        TouchAction finger2 = new TouchAction((PerformsTouchActions) mobileDriver);
        finger1.press(new ElementOption().withElement(elem).withCoordinates(x, y+100))
                .moveTo(new ElementOption().withElement(elem).withCoordinates(x, y+10));

        MultiTouchAction action = new MultiTouchAction((PerformsTouchActions) mobileDriver);
        action.add(finger1).add(finger2).perform();
    }

    @Step("Zoom Element")
    public static void zoom(WebElement elem){
        wait.until(ExpectedConditions.visibilityOf(elem));
        int x = elem.getLocation().getX() + elem.getSize().getWidth() / 2;
        int y = elem.getLocation().getY() + elem.getSize().getHeight() / 2;
        TouchAction finger1 = new TouchAction((PerformsTouchActions) mobileDriver);
        finger1.press(new ElementOption().withElement(elem).withCoordinates(x, y-10))
                .moveTo(new ElementOption().withElement(elem).withCoordinates(x, y-100));
        TouchAction finger2 = new TouchAction((PerformsTouchActions) mobileDriver);
        finger1.press(new ElementOption().withElement(elem).withCoordinates(x, y+10))
                .moveTo(new ElementOption().withElement(elem).withCoordinates(x, y+100));

        MultiTouchAction action = new MultiTouchAction((PerformsTouchActions) mobileDriver);
        action.add(finger1).add(finger2).perform();
    }

    @Step("Update text element")
    public static void updateText(WebElement elem, String text){
        wait.until(ExpectedConditions.visibilityOf(elem));
        elem.sendKeys(text);
    }

    public enum Direction {
        UP,
        DOWN,
        LEFT,
        RIGHT;
    }
}
