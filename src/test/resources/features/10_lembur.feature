Feature: Pengajuan Lembur

  Scenario Outline: User mengajukan lembur
    Given I am on the login page
    When I enter email <email> and password <password>
    And I click the login button
    Then I scroll and click lembur button
    And click the Ajukan Lembur button
    And I input data on clockin clockout and Catatan
    Then I click Ajukan
    Examples:
      | email                | password         |
      | "team3sqa@gmail.com" | "SQA@Hadir12345" |
