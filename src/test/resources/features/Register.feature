Feature: Register functionality

  @positive
  Scenario: Navigate to registration page
    Given I am on the login page
    When I click on the register link
    Then I should be redirected to the registration page

  @positive
  Scenario: Successful registration with valid data
    Given I am on the registration page
    When I enter registration details with:
      | Field   | Value                     |
      | nik     | D7232029                  |
      | name    | Randi Maulana             |
      | email   | randi.test@gmail.com    |
      | password| password123               |
      | photo   | src/test/resources/SelfieTest.png |
    And I click hide and show password
    And I click the register button
    Then I should be see message "Akun sudah terdaftar di sistem dan belum terverifikasi"

  @negative
  Scenario: Registration with an already registered email
    Given I am on the registration page
    When I enter registration details with:
      | Field   | Value                     |
      | nik     | D7232029                   |
      | name    | Randi Maulana             |
      | email   | team3sqa@gmail.com      |
      | password| password123               |
      | photo   | src/test/resources/SelfieTest2.jpg |
    And I click the register button
    Then I should be see message "Email sudah terdaftar"

  @negative
  Scenario: Registration with invalid email format
    Given I am on the registration page
    When I enter registration details with:
      | Field   | Value                     |
      | nik     | D7232029                  |
      | name    | Randi Maulana             |
      | email   | randi.testcom            |
      | password| password123               |
      | photo   | src/test/resources/SelfieTest.png |
    And I click the register button
    Then I should see a validation message "Please include an '@' in the email address."

  @negative
  Scenario: Registration with empty fields
    Given I am on the registration page
    And I click the register button
    Then I should see a validation message "Please fill out this field."

  @negative
  Scenario: Registration with invalid image format
    Given I am on the registration page
    When I enter registration details with:
      | Field   | Value                     |
      | nik     | D7232029                  |
      | name    | Randi Maulana             |
      | email   | randi.test@gmail.com            |
      | password| password123               |
      | photo   | src/test/resources/SelfieTest3.pdf |
    And I click the register button
    Then I should be see message "*File harus berupa gambar"
