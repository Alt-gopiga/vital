package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import utilities.PageActions;

public class VmailPage {

        private WebDriver ldriver;
        PageActions pageActions;
        public String jsonPath=null;
    public VmailPage(WebDriver rdriver) {
        ldriver=rdriver;
        pageActions=new PageActions();
    }
        //Creating locators
    By vmail= By.xpath("//a[text()='VMAIL']");
    By NewVmail=By.xpath("//a[@class='btn newButtonMsg']");
    //By vmailReceivingTeam=By.xpath("//*[@id=\"ng-app\"]/body/div[3]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/div[2]/h5");
    //By vmailReceivingTeam=By.xpath("/html/body/div[4]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/div[2]/h5");
    By vmailReceivingTeam=By.xpath("//h3[text()='Receiving Team']/following-sibling::div/div/h5");
    //*[@id="ng-app"]/body/div[4]/div[1]/div/div[1]/div/div[2]/div[2]/div/div/div[2]

    By participantTextBox=By.id("addPartSearchTxt");
    By participantSearchBtn=By.xpath("//label[text()='Participant']/following-sibling::div[@class='row']/div[2]/input");
    By participantRadioBtn=By.xpath("//table[@class='table table-striped']/tbody//td/input");
    By participantAddBtn=By.xpath("//input[@ng-disabled='isSavingConcersationParticipant']");
    By closeParticipant=By.xpath("//*[@id=\"addParticipantModal\"]/div/div/div[1]/button/span");

    By vmailsubject=By.xpath("//div[@class='col-sm-10']/input[@id='subject']");
    By vmailmessage=By.xpath("//textarea[@id='message']");
    By createvmailbtn=By.xpath("//button[@class='btn btn-primary btn-lg']");
    By verify_vmail_complete=By.xpath("//*[@id=\"ng-app\"]/body/div[4]/div[1]/div/div[1]/div/div[1]/div[1]/h4");

    public void click_vmail() throws InterruptedException {
        pageActions.click(vmail);
        pageActions.waitForPageLoad(ldriver);
    }
    public void click_NewVmail() throws InterruptedException {
        pageActions.click(NewVmail);
        pageActions.waitForPageLoad(ldriver);
    }
    public void click_vmailReceivingTeam() throws InterruptedException {
        pageActions.click(vmailReceivingTeam);
        pageActions.waitForPageLoad(ldriver);
    }
    public void setSearch_participant_text(String search_participant){
        pageActions.setText(participantTextBox,search_participant);
    }
    public void click_participant_SearchBtn() throws InterruptedException {
        pageActions.click(participantSearchBtn);
        pageActions.waitForPageLoad(ldriver);
    }
    public void select_participant_RadioBtn() throws InterruptedException {
        pageActions.click(participantRadioBtn);
        pageActions.waitForPageLoad(ldriver);
    }
    public void click_participant_AddBtn() throws InterruptedException {
        pageActions.click(participantAddBtn);
        pageActions.waitForPageLoad(ldriver);
    }
    public void click_closeParticipant_popup() throws InterruptedException {
        pageActions.click(closeParticipant);
        pageActions.waitForPageLoad(ldriver);
    }
    public void setVmailsubject(String vmailsubjecttxt) throws InterruptedException {
        pageActions.scrollIntoViewElement(vmailsubject);
        pageActions.setText(vmailsubject,vmailsubjecttxt);
        pageActions.waitForPageLoad(ldriver);
    }
    public void setVmailmessage(String vmailmessagefield) throws InterruptedException {
       // pageActions.scrollIntoViewElement(vmailmessage);
        pageActions.setText(vmailmessage,vmailmessagefield);
        pageActions.waitForPageLoad(ldriver);
    }
    public void click_createvmailbtn() throws InterruptedException {
        pageActions.click(createvmailbtn);
        pageActions.waitForPageLoad(ldriver);
    }
    public void verify_vmail() throws InterruptedException {
        Assert.assertTrue(ldriver.findElement(verify_vmail_complete).isDisplayed(),"The Vmail is not created");
        pageActions.waitForPageLoad(ldriver);
    }
}
