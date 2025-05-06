Feature: Absen functionality

  @positive
  Scenario Outline: Absen Masuk dengan kombinasi tipe absen dan catatan
    Given I am logged in as user with email "<email>" and password "<password>"
    And I am on the absen masuk page
    And I select absen type "<absenType>"
    And I input note "<note>"
    And I click the absen masuk button
    And I should see a confirmation message "Anda berhasil melakukan absen hari ini"
    Then I should see button absen keluar

    Examples:
      | email                  | password         | absenType        | note               |
      | team3sqa6@gmail.com   | SQA@Hadir12345   | Work From Office | Masuk on-time      |
#      | team3sqa2@gmail.com    | SQA@Hadir12345   | Work From Home   | WFH karena hujan   |
#      | team3sqa3@gmail.com    | SQA@Hadir12345   | Work From Office |                    |
#      | team3sqa5@gmail.com    | SQA@Hadir12345   | Work From Home |                    |
