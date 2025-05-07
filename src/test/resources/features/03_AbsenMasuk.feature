Feature: Absen functionality

  @positive
  Scenario Outline: Absentee Sign in with a combination of absence type and notes
    Given I am logged in as user with email "<email>" and password "<password>"
    And I am on the absen masuk page
    And I should see the current time displayed
    And I select absen type "<absenType>"
    And I input note "<note>"
    And I click the absen masuk button
    Then I should see button absen keluar

    Examples:
      | email                  | password         | absenType        | note               |
      | team3sqa5@gmail.com   | SQA@Hadir12345   | Work From Office | Masuk on-time      |
      | team3sqa6@gmail.com    | SQA@Hadir12345   | Work From Home   | WFH karena hujan   |
      | test1@gmail.com   | SQA@Hadir12345   | Work From Office |                    |
      | randi.test5@gmail.com    | password123   | Work From Home |                    |

  @positive
  Scenario Outline: Absentee Sign in with a combination of absence type and notes
    Given I am logged in as user with email "<email>" and password "<password>"
    And I am on the absen masuk page
    And I should see the current time displayed
    And I select absen type "<absenType>"
    And I input note "<note>"
    And I click the absen masuk button
    And I should see a confirmation message "Anda berhasil melakukan absen hari ini"

    Examples:
      | email                  | password         | absenType        | note               |
      | randi.test6@gmail.com   | password123  | Work From Office | Masuk on-time      |