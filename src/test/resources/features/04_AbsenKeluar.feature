Feature: Absen Keluar

  @positive
  Scenario Outline: Absent Out with combination of type and notes
    Given I am on the login page
    When I enter email "<email>" and password "<password>"
    And I click the login button
    And I am on the absen keluar page
    And I should see button absen keluar
    And I click the absen keluar button
    And I should see the current time keluar displayed
    And I input "<note>" absen keluar
    And I click the absen pulang button

    Examples:
      | email                | password      | note            |
      | team3sqa5@gmail.com  | SQA@Hadir12345  | Pulang on-time  |
      | team3sqa6@gmail.com  | SQA@Hadir12345   |   |


  @positive
  Scenario Outline: Absent Out with combination of type and notes
    Given I am on the login page
    When I enter email "<email>" and password "<password>"
    And I click the login button
    And I am on the absen keluar page
    And I should see button absen keluar
    And I click the absen keluar button
    And I should see the current time keluar displayed
    And I input "<note>" absen keluar
    And I should see a validation absen message "Berhasil absen keluar"

    Examples:
      | email                | password      | note            |
      | test1@gmail.com | SQA@Hadir12345  | Pulang on-time  |
      | randi.test5@gmail.com  | password123   |WFH selesai     |