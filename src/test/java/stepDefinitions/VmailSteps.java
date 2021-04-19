package stepDefinitions;

import io.cucumber.java.en.And;
import pageObjects.VmailPage;
import utilities.JsonReader;
import utilities.PageActions;

public class VmailSteps  extends BaseClass{

    public PageActions pageActions=new PageActions();
    public String jsonPath=null;

    @And("Go to Vmail menu")
    public void go_to_Vmail_menu() throws InterruptedException{
        vmailPage =new VmailPage(driver);
        vmailPage.click_vmail();

    }
    @And("Click new vmail button")
    public void click_new_vmail_button() throws InterruptedException {
        vmailPage =new VmailPage(driver);
        vmailPage.click_NewVmail();
    }

    @And("add receiving team")
    public void add_receiving_team() throws InterruptedException{
        jsonPath="./src/test/java/resources/vmailPage.json";
        vmailPage.click_vmailReceivingTeam();
        vmailPage.setSearch_participant_text(JsonReader.getValueByJPath(jsonPath,"/Search_vmail_participnat"));
        vmailPage.click_participant_SearchBtn();
        vmailPage.select_participant_RadioBtn();
        vmailPage.click_participant_AddBtn();
        vmailPage.click_closeParticipant_popup();
    }

    @And("enters subject")
    public void enters_subject() throws InterruptedException  {
        jsonPath="./src/test/java/resources/vmailPage.json";
        vmailPage.setVmailsubject(JsonReader.getValueByJPath(jsonPath,"/vmail_subject"));
    }

    @And("enter vmail message")
    public void enter_vmail_message() throws InterruptedException {
        jsonPath="./src/test/java/resources/vmailPage.json";
        vmailPage.setVmailmessage(JsonReader.getValueByJPath(jsonPath,"vmail_text_message"));
    }

    @And("click Create Vmail button")
    public void click_Create_Vmail_button() throws InterruptedException  {
        vmailPage.click_createvmailbtn();
    }

    @And("A new vmail created")
    public void a_new_vmail_created() throws InterruptedException {
        vmailPage.verify_vmail();
    }
}
