Feature: Pengajuan Izin Off

  Sebagai karyawan
  Saya ingin dapat mengajukan izin off
  Agar saya dapat tidak masuk kerja pada tanggal tertentu

  Scenario: Pengajuan izin off berhasil
    Given I am on the login page
    When I enter email "team3sqa@gmail.com" and password "SQA@Hadir12345"
    And I click the login button
    When User mengajukan izin off dengan tanggal "05/07/2025" dan keterangan "Ada urusan keluarga"
    Then Izin off berhasil diajukan
