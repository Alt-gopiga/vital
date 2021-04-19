package utilities;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;
import stepDefinitions.BaseClass;

import java.io.File;
import java.time.Duration;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Function;

public class PageActions extends BaseClass {

    //This method is used to return the driver
    public static WebDriver getWebdriver(){
        return driver;
    }

    //This method is to generate random string
    public String generateRandomString() {
        String generatedString= RandomStringUtils.randomAlphabetic(5);
        return (generatedString);
    }

    //This method is to generate random numeric digits
    public String generateRandomNumerals() {
        String generatedString= RandomStringUtils.randomNumeric(5);
        return (generatedString);
    }

    //This method is to get the name of Screenshot taken
    public String getScreenshotName() {
        return screenshotName=scenario.getName()+"_Test_"+generateRandomNumerals();
    }

    //This method is to launch the url
    public void launchUrl(String url) {
        try {
            driver.get(url);
            logger.info("*****Launched url : "+url+"*****");
        }
        catch (TimeoutException e) {
            Assert.fail("Timed out !!! Application didn't load. Aborting !!!");
        }
    }

    //This method is to get the current url
    public String getCurrentUrl(){
        logger.info("*****Current page URL : "+driver.getCurrentUrl()+"*****");
        return driver.getCurrentUrl();
    }

    //This method is to get the page title
    public String getPageTitle(){
        logger.info("*****The Title of the page : " + driver.getTitle() + "*****");
        return driver.getTitle();
    }

    //Method is to click on the element
    public void click(WebElement element) {
        try {
            element.click();
            logger.info("*****Element clicked : "+element.toString()+"*****");
        } catch (Exception e) {
            Assert.fail("Test failed with exception ---> "+e.toString());
        }
    }

    public void click(By by) {

        this.click(waitForElementToBeClickable(by));
    }

    //This method is to click element using javascript executor
    public void clickByJavaScript(By by) {
            this.clickByJavaScript(waitForElementToBeClickable(by));
    }

    public void clickByJavaScript(WebElement element) {
        try {
            JavascriptExecutor executor=(JavascriptExecutor) driver;
            executor.executeScript("arguments[0].click();",element);
            logger.info("*****Element clicked using javascript executor : "+element.toString()+"*****");
        }catch (Exception e){
            Assert.fail("Test failed with exception ---> "+e.toString());
        }
    }

    //This method is to wait for the element to be clickable on the page
    public WebElement waitForElementToBeClickable(By by) {
        WebElement webElement=null;

        try {
            WebDriverWait wait=new WebDriverWait(driver,maximumTimeout);
            webElement=wait.until(ExpectedConditions.elementToBeClickable(by));
            Thread.sleep(2000);
            logger.info("*****Element "+webElement.toString()+" clickable on the page*****");
        }catch (Exception e) {
            Assert.fail("Test failed with exception --->"+e.toString());
        }
        return webElement;
    }

    //This method is to set text in the text field
    public void setText(WebElement element,String value) {
        try {
            element.clear();
            element.sendKeys(new CharSequence[]{value});
            logger.info("*****Text: "+value+" entered in "+element.toString()+"*****");
        }catch (Exception e){
            Assert.fail("Test failed with exception ---> "+e.toString());
        }
    }

    public void setText(By by,String value) {
            this.setText(findObject(by), value);
    }

    //This method is to find object using By and return webelement
    public WebElement findObject(By by) {
        WebElement element=null;
        try {
            WebDriverWait wait=new WebDriverWait(driver,maximumTimeout);
            element=(WebElement)wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            Thread.sleep(2000);
            logger.info("*****Element "+by.toString()+" found on the page*****");
        } catch (Exception e) {
            logger.info("*****Element "+by.toString()+" not found on the page*****");
            Assert.fail("Test failed with exception ---> "+e.toString());
        }
        return element;
    }

    //This method is to wait for the page to load
    public void waitForPageLoad(WebDriver driver) throws InterruptedException {
        ExpectedCondition<Boolean> pageLoadCondition=new ExpectedCondition<Boolean>() {

            public  Boolean apply( WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        };
        WebDriverWait wait=new WebDriverWait(driver,maximumTimeout);
        wait.until(pageLoadCondition);
        Thread.sleep(50000);
        logger.info("*****Page loaded successfully*****");
    }

    //Method is to capture Screenshot
    public void captureScreen(WebDriver driver, String tName) {
            try {
                TakesScreenshot ts=(TakesScreenshot)driver;
                File source=ts.getScreenshotAs(OutputType.FILE);
                File target=new File(System.getProperty("user.dir")+"/test-output/Screenshots/"+tName+".png");
                FileUtils.copyFile(source,target);
                logger.info("*****Screenshot captured successfully*****");
            }catch (Exception e){
                Assert.fail("Test failed with exception ---> "+e.toString());
            }
    }

    //This method is to wait for specific seconds using Thread.sleep
    public void waitForSeconds(int d){
            try {
                Thread.sleep((long)(d*1000));
                logger.info("*****Hard wait for "+d+" seconds*****");
            }catch (Exception e){
                Assert.fail("Test failed with exception ---> "+e.toString());
            }
    }

    //This method is to scroll to page end
    public void scrollToPageEnd(){
        Actions builder=new Actions(driver);
        builder.sendKeys(new CharSequence[]{Keys.END}).perform();
    }

    //This method is hit keys with keyboard mimic
    public void hitKeys(String key){
        Actions builder=new Actions(driver);
        if(key.equals("tab")){
            builder.sendKeys(new CharSequence[]{Keys.TAB}).perform();
        } else if(key.equals("enter")){
            builder.sendKeys(new CharSequence[]{Keys.ENTER}).perform();
        } else if (key.equals("down")) {
            builder.sendKeys(new CharSequence[]{Keys.DOWN}).perform();
        } else if (key.equals("up")) {
            builder.sendKeys(new CharSequence[]{Keys.UP}).perform();
        } else if (key.equals("left")) {
            builder.sendKeys(new CharSequence[]{Keys.LEFT}).perform();
        } else if (key.equals("right")) {
            builder.sendKeys(new CharSequence[]{Keys.RIGHT}).perform();
        } else if (key.equals("pagedown")) {
            builder.sendKeys(new CharSequence[]{Keys.PAGE_DOWN}).perform();
        }
        logger.info("***** Key "+key+" hit from the keyboard*****");
    }

    //This method is to select the dropdown using value
    public void selectValueFromDropDownByValue(By by, String value){
        try {
            Select select=new Select(findObject(by));
            select.selectByValue(value);
            logger.info("***** Dropdown value "+value+" selected*****");
        }catch (Exception e){
            Assert.fail("Test failed with exception ---> " + e.toString());
        }
    }

    //This method is to select dropdown using text
    public void selectValueFromDropDownByText(By by,String value){
        try {
            Select select=new Select(findObject(by));
            select.selectByVisibleText(value);
            logger.info("***** Dropdown value "+value+" selected*****");
        }catch (Exception e) {
            Assert.fail("Test failed with exception ---> "+e.toString());
        }
    }

    //This method is to wait using Fluent wait
    public void waitUsingPollingIntervals(By by,long pollingFrequency){
        FluentWait<WebDriver> wait=new FluentWait<WebDriver>(driver)
                //Wait for the condtion
                .withTimeout(Duration.ofSeconds(maximumTimeout))
                //Checking for its presence once for every 5 seconds
                .pollingEvery(Duration.ofSeconds(pollingFrequency))
                //Which will ignore the exception
                .ignoring(NoSuchElementException.class);

        WebElement element=wait.until(new Function<WebDriver, WebElement>() {
            @Override
            public WebElement apply(WebDriver webDriver) {
                return driver.findElement(by);
            }
        });
    }

    //This method is to double click on the element
    public void doubleClick(By by){
        Actions action=new Actions(driver);
        findObject(by);
        action.moveToElement(driver.findElement(by)).doubleClick().perform();
        logger.info("*****Double click on element :" + by.toString() + " done using actions class*****");
    }

    //This method is move to specific element and click
    public void moveToElementAndClick(By by) {
        Actions action=new Actions(driver);
        findObject(by);
        action.moveToElement(driver.findElement(by)).click().perform();
        logger.info("*****Element :" + by.toString() + " clicked using actions class*****");
    }

    //This method is to open url in separate tab
    public void openUrlInSeparateTab(String url){
        String selectLinkOpenInNewTab= Keys.chord(new CharSequence[]{Keys.CONTROL, Keys.RETURN});
        driver.findElement(By.linkText(url)).sendKeys(new CharSequence[]{selectLinkOpenInNewTab});
        logger.info("*****URL :"+url+" opened in separate tab*****");
    }

    //This method is to wait for element to get disappear from page
    public void waitTillElementDisappears(By by){
        WebElement element=null;
        try {
            WebDriverWait wait=new WebDriverWait(driver,maximumTimeout);
            wait.until(ExpectedConditions.visibilityOfElementLocated(by));
            wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
            logger.info("*****Element "+by.toString()+" disappeared from the page*****");
        } catch (Exception e){
            Assert.fail("Test failed with exception ---> "+e.toString());
        }
    }

    //This method is to get text from specific element
    public String getText(By by){
        return findObject(by).getText();
    }

    //This method is to check frame and switch to it
    public WebDriver frameToBeAvailableAndSwitchToIt(String frameLocator) {
        WebDriverWait wait=new WebDriverWait(driver, maximumTimeout);
        return (WebDriver)(wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(frameLocator)));
    }

    //this method is to check frame and switch to it
    public WebDriver frameToBeAvailableAndSwitchToIt(By by){
        WebDriverWait wait=new WebDriverWait(driver,maximumTimeout);
        return (WebDriver) (wait.until(ExpectedConditions.frameToBeAvailableAndSwitchToIt(by)));
    }

    //this method is wait for alert
    public void waitForAlert(){
        new WebDriverWait(driver,maximumTimeout).until(ExpectedConditions.alertIsPresent());
    }

    //this method is to switch to window
    public void switchToWindow(){
        String parentWindowHandle=driver.getWindowHandle();
        Set<String> windowHandles=driver.getWindowHandles();
        Iterator var1=windowHandles.iterator();

        while(var1.hasNext()){
            String window=(String)var1.next();
            if(!(window.equals(parentWindowHandle))){
                driver.switchTo().window(window);
                logger.info("*****Switched to window..."+driver.getTitle());
            }
        }
    }

    //this method is scroll page to a specific element
    public void scrollIntoViewElement(By by) throws InterruptedException {
        JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView(true);",new Object[]{findObject(by)});
        Thread.sleep(2000);
        logger.info("*****Scrolled the page to element "+by.toString());
    }


}
