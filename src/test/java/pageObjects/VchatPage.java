package pageObjects;

import org.openqa.selenium.WebDriver;
import utilities.PageActions;

public class VchatPage {
    private WebDriver ldriver;
    PageActions pageActions;
    public String jsonPath = null;

    public VchatPage(WebDriver rdriver) {
        ldriver = rdriver;
        pageActions = new PageActions();
    }
}
