package pageObjects;

import io.appium.java_client.AppiumDriver;
import io.github.ashwith.flutter.FlutterElement;
import utilities.CommonOps;

public class NavigationTab extends CommonOps {
        private AppiumDriver mobileDriver;
        public NavigationTab(AppiumDriver mobileDriver) {
            this.mobileDriver = mobileDriver;
//        PageFactory.initElements(new AppiumFieldDecorator(mobileDriver), this);
        }

        public FlutterElement navBar = finder.byValueKey("main_tab");

}
