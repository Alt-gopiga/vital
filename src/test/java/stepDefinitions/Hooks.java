package stepDefinitions;

//import cucumber.api.Scenario;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import utilities.DriverManager;
import utilities.PageActions;

import java.io.IOException;

public class Hooks extends BaseClass {

    //Hook will be executed once before every TC
    @Before
    public WebDriver setup(Scenario scenario) throws IOException {

        pageActions =new PageActions();
        driverManager = new DriverManager();
        driverManager.loadProperties();
        driverManager.setLoggerConfiguration();
        driver=driverManager.launchBrowser();
        BaseClass.scenario=scenario;

        return driver;
    }

    @After
    public void tearDown(Scenario scenario){

        try {
            String screenshotName=scenario.getName().replaceAll(" ","_");
            if(scenario.isFailed()){
                logger.info("Scenario is failed : "+scenario.getName());
                //pageActions.captureScreen(driver,pageActions.getScreenshotName());
                scenario.log("Scenario is failed");
                TakesScreenshot ts=(TakesScreenshot)driver;
                byte[] screenshot=ts.getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot,"image/png",screenshotName);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        driver.quit();
    }

}
