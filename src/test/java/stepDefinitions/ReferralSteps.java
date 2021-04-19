package stepDefinitions;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import pageObjects.ReferralPage;
import utilities.JsonReader;
import utilities.PageActions;
public class ReferralSteps extends BaseClass{
    public PageActions pageActions=new PageActions();
    public String jsonPath=null;
    @And("click logout button")
    public void click_logout_button() throws InterruptedException {
        referralPage=new ReferralPage(driver);
        referralPage.click_Profile_icon();
        referralPage.click_logout_icon();
    }
    @And("click new referral button")
    public void click_new_referral_button() throws InterruptedException {
        referralPage=new ReferralPage(driver);
        referralPage.click_NewReferral();
    }
    @And("add the patient details")
    public void add_the_patient_details() throws InterruptedException {
        jsonPath="./src/test/java/resources/referralPage.json";
        //referralPage.AddPatientDetails();
        referralPage.setPatient_firstName_textfield(JsonReader.getValueByJPath(jsonPath,"/patient_Firstname"));
        referralPage.setPatient_lastName_textfield(JsonReader.getValueByJPath(jsonPath,"/patient_Lastname"));
        referralPage.setPatient_dobFeild(JsonReader.getValueByJPath(jsonPath,"/patient_dob"));
        referralPage.setPatient_reason_for_textfield(JsonReader.getValueByJPath(jsonPath,"/patient_ReasonFor"));
        referralPage.setPrimary_care_physician_textfield(JsonReader.getValueByJPath(jsonPath,"/patient_primaryCare_Physician"));
    }
    @And("add receiving participants")
    public void add_receiving_participants() throws InterruptedException {
        jsonPath="./src/test/java/resources/referralPage.json";
        //referralPage.AddReceivingTeamDetail();
        referralPage.Click_physician_receiving_team();
        referralPage.setSearch_participant_textfield(JsonReader.getValueByJPath(jsonPath,"/Search_physicianName"));
        referralPage.click_Search_button();
        referralPage.select_Physician();
        referralPage.click_add_physician_button();
    }
    @And("Error message should display as Please select atleast one receiving participant")
    public void error_message_should_display_as_Please_select_atleast_one_receiving_participant() throws InterruptedException {
        jsonPath="./src/test/java/resources/referralPage.json";
        Assert.assertEquals(JsonReader.getValueByJPath(jsonPath,"/Please_select_atleast_one_receiving_participant_alert_text"),
                referralPage.validate_Please_select_receiving_participant_alert());

    }
    @And("enters message")
    public void enters_message() throws InterruptedException {
        jsonPath="./src/test/java/resources/referralPage.json";
        referralPage.setMessage_textfield(JsonReader.getValueByJPath(jsonPath,"/text_message"));
    }
    @Then("clicks Create Referral button")
    public void clicks_Create_Referral_button() throws InterruptedException {
        referralPage.click_createReferral_button();
    }
    @Then("A new referral created")
    public void a_new_referral_created() throws InterruptedException {
        referralPage.verify_referral_created();
    }
    @Then("Error message should display as Please enter message")
    public void error_message_should_display_as_Please_enter_message() throws InterruptedException {
        jsonPath="./src/test/java/resources/referralPage.json";
        Assert.assertEquals(JsonReader.getValueByJPath(jsonPath,"/Please_enter_message_alert_text"),
                referralPage.validate_Please_enter_message_alert());
    }
    @And("add Tags")
    public void add_Tags() {
        jsonPath="./src/test/java/resources/referralPage.json";
        referralPage.add_tag(JsonReader.getValueByJPath(jsonPath,"/tags"));
    }
    @And("add workflows")
    public void add_workflows() throws InterruptedException {
        jsonPath="./src/test/java/resources/referralPage.json";
        referralPage.click_add_workflow();
        referralPage.select_workflow();
       // referralPage.setWorkflow_number_field1(JsonReader.getValueByJPath(jsonPath,"/workflow_number_field"));
        referralPage.setWorkflow_text_field2(JsonReader.getValueByJPath(jsonPath,"/workflow_text_field"));
        referralPage.select_Workflow_checkbox_field3();
        referralPage.setWorkflow_date_field4(JsonReader.getValueByJPath(jsonPath,"/workflow_date_field"));
        referralPage.click_Save_workflow_button();
        referralPage.click_Cancel_workflow_button();
    }
}