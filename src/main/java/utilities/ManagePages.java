package utilities;

import pageObjects.History;
import pageObjects.MainPage;

public class ManagePages extends Base{

    public static void pageObjects(){
        main = new pageObjects.MainPage(mobileDriver);
        history = new pageObjects.History(mobileDriver);
    }
}
