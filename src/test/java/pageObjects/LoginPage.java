package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.PageActions;
public class LoginPage {
    private WebDriver ldriver;
    PageActions pageActions;
    public String jsonPath=null;
    public LoginPage(WebDriver rdriver) {
        ldriver=rdriver;
        pageActions=new PageActions();
    }
    By login_button= By.xpath("//*[@id='navbar']/div/a[2]");
    By userName_textfield=By.xpath("//*[@id='userName']");
    By password_textfield=By.xpath("//*[@id='password']");
    By signIn_button=By.xpath("//*[@id='loginForm']/button");
    By invalid_username_password_alert=By.xpath("//*[text()='Invalid username or password']");
    By enter_username_alert=By.xpath("//*[text()='Please enter username']");
    By remember_me_checkbox=By.xpath("//*[@id='login1-remember-me']");
    public void setUsername(String username){
        pageActions.setText(userName_textfield,username);
    }
    public void setPassword(String password){
        pageActions.setText(password_textfield,password);
    }
    public void clickLogin() throws InterruptedException {
        pageActions.click(login_button);
        pageActions.waitForPageLoad(ldriver);
    }
    public void clickSignIn() throws InterruptedException {
        pageActions.click(signIn_button);
        pageActions.waitForPageLoad(ldriver);
    }
    public void verifyPageTitle(String expectedTitle){
        Assert.assertEquals(expectedTitle,pageActions.getPageTitle());
    }
    public void validateInvalidUsernameAlert(String alert_text){
        Assert.assertEquals(alert_text,pageActions.getText(invalid_username_password_alert));
    }
    public void validateInvalidPasswordAlert(String alert_text){
        Assert.assertEquals(alert_text,pageActions.getText(invalid_username_password_alert));
    }
    public void validateEnterUserNameAlert(String alert_text){
        Assert.assertEquals(alert_text,pageActions.getText(enter_username_alert));
    }
    public void clickRememberMeCheckbox(){
        pageActions.click(remember_me_checkbox);
        Assert.assertTrue(ldriver.findElement(remember_me_checkbox).isSelected(),"The checkbox is not selected: ");
    }

    public void launchUrl(String url) {
        pageActions.launchUrl(url);
    }
}