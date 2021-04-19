Feature: Allmodules Feature
  @allmodules
  Scenario: Successful Login
    When launch browser
    And enter url "https://staging.vitalengine.com/ui/index.html#/"
    And enter login credentials "gopika" and "Ccare@123"
    And click login button
    And verify page title - "Login | Vitalengine"
    Then close browser

  @allmodules
  Scenario:Create a Referral with workflow field
    When launch browser
    And enter url "https://staging.vitalengine.com/ui/index.html#/"
    And enter login credentials "gopika" and "Ccare@123"
    And click login button
    And verify page title - "Referral | Vitalengine"
    And click new referral button
    And add the patient details
    And add workflows
    And add receiving participants
    And enters message
    And clicks Create Referral button
    Then A new referral created
    Then close browser
  @allmodules
  Scenario:Create a Vmail with mandatory field
    When launch browser
    And enter url "https://staging.vitalengine.com/ui/index.html#/"
    And enter login credentials "gopika" and "Ccare@123"
    And click login button
    And verify page title - "Referral | Vitalengine"
    And Go to Vmail menu
    And verify page title - "Vmail | Vitalengine"
    And Click new vmail button
    And add receiving team
    And enters subject
    And enter vmail message
    And click Create Vmail button
    Then A new vmail created
    Then close browser

  @allmodules
  Scenario:Search and view DICOM images
    When launch browser
    And enter url "https://staging.vitalengine.com/ui/index.html#/"
    And enter login credentials "gopika" and "Ccare@123"
    And click login button
    And verify page title - "Referral | Vitalengine"
    And Go to VitalPacs menu
    And verify page title - "Vitalpacs | Vitalengine"
    And enter firstname
    And enter lastname
    And click start query
    And click DICOM radio button
    Then close browser