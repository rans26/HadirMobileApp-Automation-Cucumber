package com.TugasAkhirKelompok3.steps;

import com.TugasAkhirKelompok3.drivers.DriverSingleton;
import com.TugasAkhirKelompok3.pages.Menu.*;
import com.TugasAkhirKelompok3.pages.authentications.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class IzinOff {
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;
    IzinOffPage izinOffPage;
    IzinPulangCepatPage izinPulangCepatPage;
    IzinTerlambatPage izinTerlambatPage;
    LemburPage lemburPage;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        izinOffPage = new IzinOffPage(driver);
        izinPulangCepatPage = new IzinPulangCepatPage(driver);
        izinTerlambatPage = new IzinTerlambatPage(driver);
        lemburPage = new LemburPage(driver);
    }

    @Given("User sudah login ke aplikasi untuk izin off")
    public void user_sudah_login_ke_aplikasi_untuk_izin_off() {
        // Login sudah dilakukan di @Before
    }

    @When("User mengajukan izin off dengan tanggal {string} dan keterangan {string}")
    public void user_mengajukan_izin_off_dengan_tanggal_dan_keterangan(String tanggal, String keterangan) {
        izinOffPage = new IzinOffPage(driver);
        izinOffPage.submitIzin(tanggal, keterangan); // Hanya tanggal dan keterangan
    }

    @Then("Izin off berhasil diajukan")
    public void izin_off_berhasil_diajukan() {
        // Tambahkan validasi jika perlu
    }
}

