package POC;

import com.google.common.collect.ImmutableMap;

import com.google.common.collect.Maps;
import com.google.common.collect.Multimaps;
import io.appium.java_client.Setting;
import io.appium.java_client.remote.SupportsContextSwitching;
import io.github.ashwith.flutter.FlutterElement;
import io.qameta.allure.Description;
import io.qameta.allure.Step;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import pageObjects.Settings;
import utilities.CommonOps;
import workflows.WorkFlows;

import java.awt.*;
import java.time.Duration;
import java.util.ArrayList;
 import java.util.Map;
import java.util.Objects;

import static extensions.MobileActions.startPress;
import static org.testng.Assert.assertEquals;

@Listeners(utilities.Listeners.class)
public class Test1 extends CommonOps {

    @Test(description = "Test01 - can't upload a nw post before the previous is approved")
    @Description("This test case verify a user can't send a post before the previous one is approved")
    @Step("Test")
    public void test01_verifyWaterio() throws InterruptedException {

        ((SupportsContextSwitching) mobileDriver).context("NATIVE_APP");
        WorkFlows.login();
//        ((SupportsContextSwitching) mobileDriver).context("FLUTTER");
//        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//android.widget.Button"))).get(1).click();
//        ((SupportsContextSwitching) mobileDriver).context("FLUTTER");
//        mobileDriver.executeScript("flutter:waitFor",main.addHydration_btn);
//        System.out.println(main.addHydration_btn.getText());
//        main.addHydration180_btn.click();

//        MobileActions mobileActions=new MobileActions();
//        mobileActions.pressByElement(main.addHydration_btn);
//        mobileDriver.executeScript("flutter:waitFor",main.addHydration_btn);
//        mobileDriver.executeScript("flutter:getTopRight" ,main.addHydration_btn );

//        main.addHydration_btn.click();
//        startPress(MobileActions.BtnPress.CLICK, main.addHydration_btn, mobileDriver);


//        Response response = mobileDriver.execute("flutter:getVMInfo");


//        Object response3 = mobileDriver.executeScript("flutter:getIsolate");



//        ((Maps.TransformedEntriesMap) response2).get("")

//        HashMap<String,Objects> stringObjectsHashMap= (HashMap<String, Objects>) response2;
//        mobileDriver.executeScript("flutter:getVMInfo");

//        String id = response.getSessionId();
//        response.getState();
//        response.getStatus();
//        Object response2 = mobileDriver.executeScript("flutter:getVMInfo");
//        System.out.println(response2);
//
//        String[] id=response2.toString().split("type=@Isolate")[1].substring(1).split(",name");
//        String idIsolate=id[0].toString().split("id=")[1].toString().split(",")[0];
//        mobileDriver.executeScript("flutter:setIsolateId", idIsolate);
//        Object o=  mobileDriver.executeScript("flutter:setIsolateId", "isolates/" + id);


//        mobileDriver.executeScript("flutter:setFrameSync", true, 5000);
//        startPress(MobileActions.BtnPress.CLICK, main.main_btn, mobileDriver);
//        mobileDriver.executeScript("flutter:longTap", main.main_btn, );
        mobileDriver.executeScript("flutter:waitFor",main.main_btn);
        main.main_btn.click();
//        mobileDriver.executeScript("flutter:setFrameSync", false, 5000);

//        HashMap<String, Object> stringObjectsHashMap = new HashMap<>();
//        stringObjectsHashMap.put("durationMilliseconds", 100);
//        stringObjectsHashMap.put("frequency", 30);
//
//
//       Object o= mobileDriver.executeScript("flutter:longTap",main.addHydration_btn ,stringObjectsHashMap);
//       o.toString();

//        driver.executeScript("flutter:scroll", main.addHydration_btn, new HashMap<String, Object>() {{
////            put("item", find.byType("TextField"));
//            put("dx", 50);
//            put("dy", 100);
//            put("durationMilliseconds", 200);
//            put("frequency", 30);
//        }});


//        mobileDriver.executeScript("flutter:longTap",main.addHydration_btn ,jsonObject.toString());
//        mobileDriver.executeScript("flutter: tap", main.addHydration_btn);
//        MobileActions.tap(main.addHydration_btn);
//------------------------------------------
//        Map renderObjectDiagnostics = (Map) mobileDriver.executeScript(
//                "flutter:getRenderObjectDiagnostics",
//                main.addHydration_btn.getId(),
//                new HashMap<String, Object>() {{
//                    put("includeProperties", true);
//                    put("subtreeDepth", 2);
//                }}
//        );
//        assertEquals(renderObjectDiagnostics.get("type"), "DiagnosticableTreeNode");
//        assertEquals(((List)renderObjectDiagnostics.get("children")).size(), 1);
//        System.out.println(renderObjectDiagnostics);
        //-----------------------------------------------
//        System.out.println(main.txt_hydrated);
//        System.out.println(main.txt_hydrated.getText());


    }
}
