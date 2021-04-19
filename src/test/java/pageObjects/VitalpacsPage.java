package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utilities.PageActions;

public class VitalpacsPage {
    private WebDriver ldriver;
    PageActions pageActions;
    public String jsonPath = null;

    public VitalpacsPage(WebDriver rdriver) {
        ldriver = rdriver;
        pageActions = new PageActions();
    }
//Creating locators
    By vitalpacs= By.xpath("//a[@ui-sref=\"vitalpacs\"]");
    By PatientFirstName = By.xpath("//*[@id=\"patientName\"]");
    By PatientLastName = By.xpath("//*[@id=\"lastName\"]");
    By DicomStartQuery = By.xpath("//button[@ng-click=\"VitalpacsService.getStudyList()\"]");
    By radioDicomStudy = By.xpath("//input[@ng-model=\"vpFields.studyCheck\"]");

    public void click_vitalpacs() throws InterruptedException {
        pageActions.click(vitalpacs);
        pageActions.waitForPageLoad(ldriver);
    }
    public void setPatient_FirstName(String DicomPatientFirstName) throws InterruptedException {
        pageActions.setText(PatientFirstName,DicomPatientFirstName);
        pageActions.waitForPageLoad(ldriver);
    }
    public void setPatient_LastName(String DicomPatientLastName){
        pageActions.setText(PatientLastName,DicomPatientLastName);

    }
    public void click_DICOM_StartQuery() throws InterruptedException {
        pageActions.click(DicomStartQuery);
        pageActions.waitForPageLoad(ldriver);
    }
    public void click_radioDICOMstudy() throws InterruptedException {
        pageActions.scrollIntoViewElement(radioDicomStudy);
        pageActions.click(radioDicomStudy);
        pageActions.waitForPageLoad(ldriver);
    }

}
