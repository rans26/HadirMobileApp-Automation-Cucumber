Feature: Absen Keluar

  @positive
  Scenario Outline: Absen Keluar dengan kombinasi tipe dan catatan
    Given I am on the login page
    When I enter email "team3sqa6@gmail.com" and password "SQA@Hadir12345"
    And I click the login button
    And I am on the absen keluar page
    And I should see button absen keluar
    And I click the absen keluar button
    And I input "<note>" absen keluar

    Examples:
      | email                | password      | note            |
      | team3sqa6@gmail.com  | SQA@Hadir12345  | Pulang on-time  |
#      | team3sqa2@gmail.com  | SQA@Hadir12345   |WFH selesai     |
