Feature: Login Feature
  @login
  Scenario: Successful Login
    When launch browser
    And enter url "https://staging.vitalengine.com/ui/index.html#/"
    And enter login credentials "gopika" and "Ccare@123"
    And click login button
    And verify page title - "Login | Vitalengine"
    Then close browser
  @login
  Scenario: Invalid Username Login
    When launch browser
    And enter url "https://staging.vitalengine.com/ui/index.html#/"
    And enter invalid username
    And click login button
    And validate invalid username alert
    Then close browser
  @login
  Scenario: Invalid Password Login
    When launch browser
    And enter url "https://staging.vitalengine.com/ui/index.html#/"
    And enter a valid username and invalid password
    And click login button
    And validate invalid password alert
    Then close browser
  @login
  Scenario: Empty Login
    When launch browser
    And enter url "https://staging.vitalengine.com/ui/index.html#/"
    And do not enter username and valid password
    And click login button without username and password
    And validate enter username alert
    Then close browser
  @login
  Scenario: Login with Remember Me Checkbox
    When launch browser
    And enter url "https://staging.vitalengine.com/ui/index.html#/"
    And enter login credentials "gopika" and "Ccare@123"
    And select Remember Me Checkbox
    And click login button
    And verify page title - "Login | Vitalengine"
    Then close browser
  @login @logout
  Scenario: Successful login and logout
    When launch browser
    And enter url "https://staging.vitalengine.com/ui/index.html#/"
    And enter login credentials "gopika" and "Ccare@123"
    And click login button
    And verify page title - "Login | Vitalengine"
    And click logout button
    Then close browser

