Feature: Cuti fuctionality

  @positive
  Scenario: Success full login
    Given I am on the login page
    When I enter email "hadirsqa1@gmail.com" and password "SQA@Hadir12345"
    And I click the login button
  Scenario: Success full apply with choose type and valid date
    Given I am on the leave page
    When I click the leave page button
    And I click choose type
    And I click date
    And I click the leave button
    Then I should be redirected to the list request leave page

  @negative
  Scenario: success apply leave with choose type and invalid date
    Given I am on the leave page
    When I click the leave page button
    And I click choose type
    And I click the leave button
    Then I should see an error message date leave "Incorrect DATE value: 'Invalid date'"

  @negative
  Scenario: success apply leave with blank type and valid date
    Given I am on the leave page
    When I click the leave page button
    And I click date
    And I click the leave button
    Then I should see an error message type is null "Cannot read properties of null (reading 'hris_leave_type_id')"

  @negative
  Scenario: success apply leave with blank type and valid date
    Given I am on the leave page
    When I click the leave page button
    And I click the leave button
    Then I should see an error message type is null "Cannot read properties of null (reading 'hris_leave_type_id')"




