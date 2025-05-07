Feature: Menu Sick

  @positive
  Scenario: Success full login
    Given I am on the login page
    When I enter email "hadirsqa1@gmail.com" and password "SQA@Hadir12345"
    And I click the login button
#  Scenario: Success apply sick with valid date
#    Given I am on the sick page
#    When I click the page sick button
#    And I click the date sick
#    And I click the image
#    And I click the apply button
#    Then I should be redirected to the list request sick page

  @negative
  Scenario: no success apply sick with invalid date
    Given I am on the sick page
    When I click the page sick button
    And I click the image
    And I click the apply button
    Then I should see an error message date sick "Incorrect datetime value: 'Invalid date' for column 'sick_request_date_from' at row 1"

  @negative
  Scenario: success apply sick with duplicate date
    Given I am on the sick page
    When I click the page sick button
    And I click the date sick
    And I click the image
    And I click the apply button
    Then I should see an error message duplicate date "Anda sudah melakukan izin sakit di tanggal tersebut"