Feature: Koreksi Absensi Functionality

  @positive
  Scenario: Valid Attendance Correction
    Given I am on the login page
    When I enter email "team3sqa@gmail.com" and password "SQA@Hadir12345"
    And I click the login button
    Then I scroll and click to Koreksi Absensi button
    And I scroll and click the Ajukan Koreksi button
    And I input data on clockin clockout and Tipe Absen
    And I click AjukanCIOA
    Then I should be redirected to the Koreksi Absensi page and and be able to see the corrected absences that I have input

  @positive
  Scenario: Correction of attendance with empty entry hours field
    Given I am on the login page
    When I enter email "team3sqa@gmail.com" and password "SQA@Hadir12345"
    And I click the login button
    When I scroll and click to Koreksi Absensi button
    And I scroll and click the Ajukan Koreksi button
    And I input data on clockout
    And I click AjukanCO
    Then I should be redirected to the Koreksi Absensi page and and be able to see the corrected absences that I have input

  @positive
  Scenario: Correction of attendance with entry hours field and empty Tipe Absen
    Given I am on the login page
    When I enter email "team3sqa@gmail.com" and password "SQA@Hadir12345"
    And I click the login button
    When I scroll and click to Koreksi Absensi button
    And I scroll and click the Ajukan Koreksi button
    And I input data on clockin
    And I click AjukanCI
    Then I should be redirected to the Koreksi Absensi page and and be able to see the corrected absences that I have input

  @positive
  Scenario: Correction of attendance with empty clockout field
    Given I am on the login page
    When I enter email "team3sqa@gmail.com" and password "SQA@Hadir12345"
    And I click the login button
    When I scroll and click to Koreksi Absensi button
    And I scroll and click the Ajukan Koreksi button
    And I input data on clockin and Tipe Absen
    And I click AjukanCIA
    Then I should be redirected to the Koreksi Absensi page and and be able to see the corrected absences that I have input

  @positive
  Scenario: Reset Absence Correction
    Given I am on the login page
    When I enter email "team3sqa@gmail.com" and password "SQA@Hadir12345"
    And I click the login button
    When I scroll and click to Koreksi Absensi button
    And I scroll and click the Ajukan Koreksi button
    And I input data on clockin clockout and Tipe Absen
    And I click Reset
    Then I should be redirected to the Koreksi Absensi page with empty data

  @negative
  Scenario: Correction of attendance with empty clockin and clockout field
    Given I am on the login page
    When I enter email "team3sqa@gmail.com" and password "SQA@Hadir12345"
    And I click the login button
    When I scroll and click to Koreksi Absensi button
    And I scroll and click the Ajukan Koreksi button
    And I click AjukanKosong
    Then I should see an error message koreksi "Salah satu harus diisi!"