package stepDefinitions;

import io.cucumber.java.en.And;
import pageObjects.VitalpacsPage;
import utilities.JsonReader;
import utilities.PageActions;

public class VitalpacsSteps extends BaseClass {

    public PageActions pageActions = new PageActions();
    public String jsonPath = null;

    @And("Go to VitalPacs menu")
    public void go_to_VitalPacs_menu() throws InterruptedException {
        vitalpacsPage =new VitalpacsPage(driver);
        vitalpacsPage.click_vitalpacs();
    }

    @And("enter firstname")
    public void enter_firstname() throws InterruptedException {
        jsonPath="./src/test/java/resources/vitalpacsPage.json";
        vitalpacsPage.setPatient_FirstName(JsonReader.getValueByJPath(jsonPath,"/DICOM_firstname"));
    }

    @And("enter lastname")
    public void enter_lastname() {
        jsonPath="./src/test/java/resources/vitalpacsPage.json";
        vitalpacsPage.setPatient_LastName(JsonReader.getValueByJPath(jsonPath,"/DICOM_lastname"));

    }

    @And("click start query")
    public void click_start_query() throws InterruptedException {
        vitalpacsPage =new VitalpacsPage(driver);
        vitalpacsPage.click_DICOM_StartQuery();

    }

    @And("click DICOM radio button")
    public void click_DICOM_radio_button() throws InterruptedException {
        vitalpacsPage =new VitalpacsPage(driver);
        vitalpacsPage.click_radioDICOMstudy();
    }
    @And("DICOM preview should display")
    public void dicom_preview_should_display() {

    }
}