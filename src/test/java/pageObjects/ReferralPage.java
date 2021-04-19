package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utilities.PageActions;
public class ReferralPage {
    private WebDriver ldriver;
    PageActions pageActions;
    public String jsonPath=null;
    public ReferralPage(WebDriver rdriver) {
        ldriver=rdriver;
        pageActions=new PageActions();
    }
    //Creating locators
    By profile_icon=By.xpath("//*[@id='header-navbar']/div/div[3]/ul/li[4]/div/button/span");
    By logout_button=By.xpath("//*[@id='header-navbar']/div/div[3]/ul/li[4]/div/ul/li[5]/a[2]");
    //REFERRAL
    By new_referral_button=By.xpath("//*[@ui-sref='newreferral']");
    By patient_firstName_textfield=By.xpath("//*[@name='firstName']");
    By patient_lastName_textfield=By.xpath("//*[@name='lastName']");
    By patient_dobFeild=By.xpath("//*[@name='dob']");
    By patient_reason_for_textfield=By.xpath("//*[@name='referralFor']");
    By primary_care_physician_textfield=By.xpath("//*[@name='primaryCarePhysician']");
    By add_physican_receiving_team=By.xpath("//div[@ng-click=\"NewReferralService.openAddParticipantModal('RECEIVING')\"]");
    By search_participant_textfield=By.xpath("//*[@id='addPartSearchTxt']");
    By search_button=By.xpath("//*[@id='addParticipantModal']/div/div/div[2]/div/div[1]/div[2]/div/div[1]/div[2]/input");
    By select_physician=By.xpath("//*[@id='addParticipantModal']/div/div/div[2]/div/div[1]/div[3]/div[1]/table[1]/tbody/tr/td[1]/input");
    By click_add_physician=By.xpath("//*[@id='addParticipantModal']/div/div/div[2]/div/div[2]/div/input[1]");
    By message_textfield=By.xpath("//*[@id='message']");
    By createReferral_button=By.xpath("//button[@ng-click='NewReferralService.saveReferral()']");
    By add_Tag=By.xpath("//*[@id='ng-app']/body/div[3]/div[1]/div/div/div[1]/div[4]/div[3]/div/div/tags-input/div/div/input");

    By add_workflow=By.xpath("//button[@data-target=\"#addWorkflowModal\"]");
    //By add_workflow=By.xpath("//button[@ng-click='NewReferralService.getWorkflowList()']");

    //By add_workflow=By.xpath("//*[@id='ng-app']/body/div[4]/div[1]/div/div/div[1]/div[3]/button/span");
    //*[@id="ng-app"]/body/div[4]/div[1]/div/div/div[1]/div[3]/button/span
    //By add_workflow=By.xpath("//*[@id=\"ng-app\"]/body/div[4]/div[1]/div/div/div[1]/div[3]/button");
    By click_workflow_list=By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[1]");
    By workflow_number_field1=By.xpath("/html/body/div[4]/div[12]/div/div/div/div[2]/div/div[1]/div[1]/table/tbody/tr[1]/td[2]/div/input");
    By workflow_text_field2=By.xpath("/html/body/div[4]/div[12]/div/div/div/div[2]/div/div[1]/div[1]/table/tbody/tr[3]/td[2]/div/input");
    By workflow_checkbox_field3=By.xpath("/html/body/div[4]/div[12]/div/div/div/div[2]/div/div[1]/div[1]/table/tbody/tr[2]/td[2]/div/input");
    By workflow_date_field4=By.xpath("/html/body/div[4]/div[12]/div/div/div/div[2]/div/div[1]/div[1]/table/tbody/tr[5]/td[2]/div/input");

   // By workflow_number_field1=By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[1]/td[2]");
    //By workflow_text_field2=By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[3]/td[2]");
    //By workflow_checkbox_field3=By.xpath("//table[@class=\"table table-striped\"]/tbody/tr[2]/td[2]/div/input");
    //By workflow_date_field4=By.xpath("//*[@id=\"addWorkflowModal\"]/div/div/div[2]/div/div[1]/div[1]/table/tbody/tr[5]/td[2]/div/input");
    By save_workflow_button=By.xpath("//*[@id=\"addWorkflowModal\"]/div/div/div[2]/div/div[2]/div/input[1]");
    By cancel_workflow_button=By.xpath("/html/body/div[4]/div[12]/div/div/div/div[2]/div/div[2]/div/input[2]");

    By add_medical_records=By.xpath("");
    By add_DICOM_images=By.xpath("");
    By add_todo=By.xpath("");
    By add_scheduled_events=By.xpath("");


    By Please_enter_message_alert=By.xpath("//*[text()='Please enter message']");
    By complete_referral=By.xpath("//*[contains(text(),'Referral Id')]");

    By Please_select_receiving_participant_alert=By.xpath("//div[@ng-show='showTxtError']/label");

    public void click_Profile_icon() throws InterruptedException {
        pageActions.click(profile_icon);
        pageActions.waitForPageLoad(ldriver);
    }
    public void click_logout_icon() throws InterruptedException {
        pageActions.click(logout_button);
        pageActions.waitForPageLoad(ldriver);
    }
    public void click_NewReferral() throws InterruptedException {
        pageActions.click(new_referral_button);
        pageActions.waitForPageLoad(ldriver);
    }
    public void setPatient_firstName_textfield(String patient_firstName){
        pageActions.setText(patient_firstName_textfield,patient_firstName);
    }
    public void setPatient_lastName_textfield(String patient_lastName){
        pageActions.setText(patient_lastName_textfield,patient_lastName);
    }
    public void setPatient_dobFeild(String patient_dob){

        pageActions.setText(patient_dobFeild,patient_dob);
    }
    public void setPatient_reason_for_textfield(String patient_reason_for){
        pageActions.setText(patient_reason_for_textfield,patient_reason_for);
    }
    public void setPrimary_care_physician_textfield(String primary_care_physician){
        pageActions.setText(primary_care_physician_textfield,primary_care_physician);
    }
    public void Click_physician_receiving_team() throws InterruptedException {
        pageActions.click(add_physican_receiving_team);
        pageActions.waitForPageLoad(ldriver);
    }
    public void setSearch_participant_textfield(String search_participant){
        pageActions.setText(search_participant_textfield,search_participant);
    }
    public void click_Search_button() throws InterruptedException {
        pageActions.click(search_button);
        pageActions.waitForPageLoad(ldriver);
    }
    public void select_Physician() throws InterruptedException {
        pageActions.click(select_physician);
        pageActions.waitForPageLoad(ldriver);
    }
    public void click_add_physician_button() throws InterruptedException {
        pageActions.click(click_add_physician);
        pageActions.waitForPageLoad(ldriver);
    }
    public void setMessage_textfield(String textMessage){

        pageActions.setText(message_textfield,textMessage);
    }
    public void click_createReferral_button() throws InterruptedException {
        pageActions.click(createReferral_button);
        pageActions.waitForPageLoad(ldriver);
    }
    public String validate_Please_enter_message_alert(){

        return  pageActions.getText(Please_enter_message_alert);
    }
    public void verify_referral_created(){
        Assert.assertTrue(ldriver.findElement(complete_referral).isDisplayed(),"The referral Id is not generated");
    }
    public String validate_Please_select_receiving_participant_alert(){
        return pageActions.getText(Please_select_receiving_participant_alert);
    }
    public void add_tag(String tag){
        pageActions.setText(add_Tag,tag);
        // pageActions.
    }
    public void click_add_workflow() throws InterruptedException {

        JavascriptExecutor js = (JavascriptExecutor) ldriver;
        js.executeScript("window.scrollBy(0,200)");
        //js.executeScript("arguments[0].scrollIntoView();", Element);
        WebElement Element=ldriver.findElement(By.xpath("//button[@ng-click=\"NewReferralService.getWorkflowList()\"]"));
        Element.click();
        //pageActions.click(add_workflow);
        pageActions.waitForPageLoad(ldriver);
    }
    public void select_workflow() throws InterruptedException {


        pageActions.waitForPageLoad(ldriver);
        pageActions.click(click_workflow_list);
        pageActions.waitForPageLoad(ldriver);
    }
    /*public void setWorkflow_number_field1(String workflow_field1){
        pageActions.setText(workflow_number_field1,workflow_field1);
    }*/
    public void setWorkflow_text_field2(String workflow_field2){
        pageActions.setText(workflow_text_field2,workflow_field2);
    }
    public void select_Workflow_checkbox_field3() throws InterruptedException {
        pageActions.click(workflow_checkbox_field3);
        pageActions.waitForPageLoad(ldriver);
    }
    public void setWorkflow_date_field4(String workflow_field4){
        pageActions.setText(workflow_date_field4,workflow_field4);
    }
    public void click_Save_workflow_button() throws InterruptedException {
        pageActions.click(save_workflow_button);
        pageActions.waitForPageLoad(ldriver);
    }
    public void click_Cancel_workflow_button() throws InterruptedException {
        pageActions.click(cancel_workflow_button);
        pageActions.waitForPageLoad(ldriver);
    }
}