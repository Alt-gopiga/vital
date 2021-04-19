$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("file:Features/vitalpacs.feature");
formatter.feature({
  "name": "VitalPacs Feature",
  "description": "",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Search and view DICOM images",
  "description": "",
  "keyword": "Scenario",
  "tags": [
    {
      "name": "@vitalpacs"
    }
  ]
});
formatter.before({
  "status": "skipped"
});
formatter.step({
  "name": "launch browser",
  "keyword": "When "
});
formatter.match({
  "location": "stepDefinitions.LoginSteps.launch_browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "enter url \"https://staging.vitalengine.com/ui/index.html#/\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.LoginSteps.enter_url(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "enter login credentials \"gopika\" and \"Ccare@123\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.LoginSteps.enter_login_credentials_and(java.lang.String,java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "click login button",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.LoginSteps.click_login_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "verify page title - \"Referral | Vitalengine\"",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.LoginSteps.verify_page_title(java.lang.String)"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "Go to VitalPacs menu",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.VitalpacsSteps.go_to_VitalPacs_menu()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "enter firstname",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.VitalpacsSteps.enter_firstname()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "enter lastname",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.VitalpacsSteps.enter_lastname()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "click start query",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.VitalpacsSteps.click_start_query()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "click DICOM radio button",
  "keyword": "And "
});
formatter.match({
  "location": "stepDefinitions.VitalpacsSteps.click_DICOM_radio_button()"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "DICOM preview should display",
  "keyword": "Then "
});
formatter.match({});
formatter.result({
  "status": "undefined"
});
formatter.step({
  "name": "close browser",
  "keyword": "Then "
});
formatter.match({
  "location": "stepDefinitions.LoginSteps.close_browser()"
});
formatter.result({
  "status": "skipped"
});
formatter.after({
  "status": "skipped"
});
});