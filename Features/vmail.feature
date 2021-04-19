Feature: Vmail Feature

 @vmail
 Scenario:Create a Vmail with mandatory field
  When launch browser
  And enter url "https://staging.vitalengine.com/ui/index.html#/"
  And enter login credentials "gopika" and "Ccare@123"
  And click login button
  And verify page title - "Login | Vitalengine"
  And Go to Vmail menu
  And Click new vmail button
  And add receiving team
  And enters subject
  And enter vmail message
  And click Create Vmail button
  Then A new vmail created
  Then close browser
 @vmail
 Scenario:Create a Vmail with mandatory field
  When launch browser
  And enter url "https://staging.vitalengine.com/ui/index.html#/"
  And enter login credentials "gopika" and "Ccare@123"
  And click login button
  And verify page title - "Login | Vitalengine"
  And Go to Vmail menu
  And Click new vmail button
  And add receiving team
  #And attach file & records
  #And attach DICOM images
  And enters subject
  And enter vmail message
  And click Create Vmail button
  Then A new vmail created
  Then close browser