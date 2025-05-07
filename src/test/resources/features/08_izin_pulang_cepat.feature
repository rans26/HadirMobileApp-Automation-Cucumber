Feature: Pengajuan Izin Pulang Cepat

  Scenario: User mengajukan izin pulang cepat
    Given User sudah login ke aplikasi
    When User mengajukan izin pulang cepat dengan tanggal "05/06/2025", jam "16:00", dan keterangan "Izin pulang cepat untuk acara keluarga"
    Then Izin pulang cepat berhasil diajukan
