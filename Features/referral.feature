Feature: Referral Feature

  #@referral
  Scenario:Create a Referral with mandatory field
    When launch browser
    And enter url "https://staging.vitalengine.com/ui/index.html#/"
    And enter login credentials "gopika" and "Ccare@123"
    And click login button
    And verify page title - "Login | Vitalengine"
    And click new referral button
    And add the patient details
    And add receiving participants
    And enters message
    And clicks Create Referral button
    Then A new referral created
    Then close browser
  #@referral
  Scenario: Create a Referral without message field
    When launch browser
    And enter url "https://staging.vitalengine.com/ui/index.html#/"
    And enter login credentials "gopika" and "Ccare@123"
    And click login button
    And verify page title - "Login | Vitalengine"
    And click new referral button
    And add the patient details
    And add receiving participants
    And clicks Create Referral button
    Then Error message should display as Please enter message
    Then close browser
  #@referral
  Scenario: Create a Referral with Tags
    When launch browser
    And enter url "https://staging.vitalengine.com/ui/index.html#/"
    And enter login credentials "gopika" and "Ccare@123"
    And click login button
    And verify page title - "Login | Vitalengine"
    And click new referral button
    And add the patient details
    And add receiving participants
    And enters message
    And add Tags
    And clicks Create Referral button
    Then A new referral created
    And close browser
  #@referral
  Scenario: Create a Referral without participant field
    When launch browser
    And enter url "https://staging.vitalengine.com/ui/index.html#/"
    And enter login credentials "gopika" and "Ccare@123"
    And click login button
    And verify page title - "Login | Vitalengine"
    And click new referral button
    And add the patient details
    And clicks Create Referral button
    Then Error message should display as Please select atleast one receiving participant

  @referral
  Scenario:Create a Referral with workflow field
    When launch browser
    And enter url "https://staging.vitalengine.com/ui/index.html#/"
    And enter login credentials "gopika" and "Ccare@123"
    And click login button
    And verify page title - "Login | Vitalengine"
    And click new referral button
    And add the patient details
    And add workflows
    And add receiving participants
    And enters message
    And clicks Create Referral button
    Then A new referral created
    Then close browser
  #@referral
  Scenario:Create a Referral with all field
    When launch browser
    And enter url "https://staging.vitalengine.com/ui/index.html#/"
    And enter login credentials "gopika" and "Ccare@123"
    And click login button
    And verify page title - "Login | Vitalengine"
    And click new referral button
    And add the patient details
    And add receiving participants
    And enters message
    And add Tags
    And add workflows
    And add medical records
    And add DICOM image
    And add schedule events
    And add Todo
    And clicks Create Referral button
    Then A new referral created
    Then close browser

