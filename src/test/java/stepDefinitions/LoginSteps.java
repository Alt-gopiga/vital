package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.LoginPage;
import utilities.JsonReader;
import utilities.PageActions;

public class LoginSteps extends BaseClass {
    public PageActions pageActions=new PageActions();
    public String jsonPath=null;

    @When("launch browser")
    public void launch_browser() {

        loginPage=new LoginPage(driver);
    }
    @And("enter url {string}")
    public void enter_url(String url) {
        loginPage.launchUrl(url);
    }
    @And("enter login credentials {string} and {string}")
    public void enter_login_credentials_and(String username, String password) throws InterruptedException {
        loginPage.clickLogin();
        loginPage.setUsername(username);
        loginPage.setPassword(password);
    }
    @And("click login button")
    public void click_login_button() throws InterruptedException {
        loginPage.clickSignIn();
    }
    @And("click login button without username and password")
    public void click_login_button_without_username_and_password() throws InterruptedException {
        loginPage.clickLogin();
        loginPage.clickSignIn();
    }
    @And("verify page title - {string}")
    public void verify_page_title(String pageTitle) {
        loginPage.verifyPageTitle(pageTitle);
    }
    @Then("close browser")
    public void close_browser() {
        driver.quit();
    }
    @When("enter invalid username")
    public void enter_invalid_username() throws InterruptedException {
        jsonPath="./src/test/java/resources/loginPage.json";
        loginPage.clickLogin();
        loginPage.setUsername(JsonReader.getValueByJPath(jsonPath,"/invalid_username"));
        loginPage.setPassword(JsonReader.getValueByJPath(jsonPath,"/invalid_password"));
    }
    @When("validate invalid username alert")
    public void validate_invalid_username_alert() {
        jsonPath="./src/test/java/resources/loginPage.json";
        String alert_text=JsonReader.getValueByJPath(jsonPath,"/invalid_username_password_alert");
        loginPage.validateInvalidUsernameAlert(alert_text);
    }
    @And("enter a valid username and invalid password")
    public void enter_a_valid_username_and_invalid_password() throws InterruptedException {
        jsonPath="./src/test/java/resources/loginPage.json";
        loginPage.clickLogin();
        loginPage.setUsername(JsonReader.getValueByJPath(jsonPath,"/valid_username"));
        loginPage.setPassword(JsonReader.getValueByJPath(jsonPath,"/invalid_password"));
    }
    @When("validate invalid password alert")
    public void validate_invalid_password_alert() {
        jsonPath="./src/test/java/resources/loginPage.json";
        String alert_text=JsonReader.getValueByJPath(jsonPath,"/invalid_username_password_alert");
        loginPage.validateInvalidPasswordAlert(alert_text);
    }
    @When("do not enter username and valid password")
    public void do_not_enter_username_and_valid_password() {
    }
    @When("validate enter username password alert")
    public void validate_enter_username_password_alert() {
    }
    @When("select Remember Me Checkbox")
    public void select_Remember_Me_Checkbox() {
        loginPage.clickRememberMeCheckbox();
    }
    @And("validate enter username alert")
    public void validate_enter_username_alert() {
        jsonPath="./src/test/java/resources/loginPage.json";
        String alert_text=JsonReader.getValueByJPath(jsonPath,"/enter_username_alert");
        loginPage.validateEnterUserNameAlert(alert_text);
    }

    /*@And("click logout button")
    public void click_logout_button() {
        referralPage=new ReferralPage(driver);
        referralPage.click_Profile_icon();
        referralPage.click_logout_icon();

    }*/
}
