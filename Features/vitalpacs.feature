Feature: VitalPacs Feature

@vitalpacs
Scenario:Search and view DICOM images
  When launch browser
  And enter url "https://staging.vitalengine.com/ui/index.html#/"
  And enter login credentials "gopika" and "Ccare@123"
  And click login button
  And verify page title - "Referral | Vitalengine"
  And Go to VitalPacs menu
  And enter firstname
  And enter lastname
  And click start query
  And click DICOM radio button
  And DICOM preview should display
  Then close browser