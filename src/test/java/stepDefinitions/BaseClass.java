package stepDefinitions;


//import cucumber.api.Scenario;

import io.cucumber.java.Scenario;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import pageObjects.LoginPage;
import pageObjects.ReferralPage;
import pageObjects.VitalpacsPage;
import pageObjects.VchatPage;
import pageObjects.VmailPage;
import utilities.DriverManager;
import utilities.PageActions;

import java.util.Properties;


public class BaseClass {

    //Create references
    // public static ThreadLocal<WebDriver> threadLocal = new ThreadLocal<WebDriver>();

    public static WebDriver driver;
    public LoginPage loginPage;
    public ReferralPage referralPage;
    public VmailPage vmailPage;
    public VitalpacsPage vitalpacsPage;
    public VchatPage vchatPage;
    public static Logger logger;
    public Properties configProp;
    public long maximumTimeout=90;
    public PageActions pageActions;
    public DriverManager driverManager;
    public static Scenario scenario;
    public static String screenshotName;

}
