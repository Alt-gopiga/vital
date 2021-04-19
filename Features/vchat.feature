Feature: VChat Feature

  @vchat
  Scenario:Send one to one message
    When launch browser
    And enter url "https://staging.vitalengine.com/ui/index.html#/"
    And enter login credentials "gopika" and "Ccare@123"
    And click login button
    And verify page title - "Referral | Vitalengine"
    And Go to Vchat menu
    And open one to one chat
    And enter the message
    And click send message icon
    Then Entered message should be sent to the receiver side
    Then close browser