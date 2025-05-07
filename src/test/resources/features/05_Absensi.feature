Feature: Absensi Functionality

  @positive
Scenario: Attendance History Display
    Given I am on the login page
    When I enter email "team3sqa@gmail.com" and password "SQA@Hadir12345"
    And I click the login button

#    Then I should be redirected to the dashboard page
    Then I scroll and click to Absensi button
