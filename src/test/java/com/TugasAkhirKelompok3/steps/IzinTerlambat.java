package com.TugasAkhirKelompok3.steps;

import com.TugasAkhirKelompok3.drivers.DriverSingleton;
import com.TugasAkhirKelompok3.pages.Menu.*;
import com.TugasAkhirKelompok3.pages.authentications.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class IzinTerlambat {
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

    @Given("User sudah login ke aplikasi untuk izin terlambat")
    public void user_sudah_login_ke_aplikasi_izin_terlambat() {

    }

    @And("I navigate to the page")
    public void i_navigate_to_the_page() {
        dashboardPage.clickMenuIzin();
    }

    @And("I click the ajukan izin terlambat button")
    public void iClickTheAjukanIzinTerlambatButton() {
        izinTerlambatPage.clickMenuAjukanIzinTerlambat();
    }

    @When("User mengajukan izin terlambat dengan tanggal {string}, jam {string}, dan keterangan {string}")
    public void user_mengajukan_izin_terlambat(String tanggal, String jam, String keterangan) {
        izinTerlambatPage = new IzinTerlambatPage(driver);
        izinTerlambatPage.submitIzin(tanggal, jam, keterangan);
    }

    @Then("Izin terlambat berhasil diajukan")
    public void izin_terlambat_berhasil_diajukan() {
        // Verifikasi hasil jika diperlukan
    }
}

