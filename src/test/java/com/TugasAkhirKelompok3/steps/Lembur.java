package com.TugasAkhirKelompok3.steps;

import com.TugasAkhirKelompok3.drivers.DriverSingleton;
import com.TugasAkhirKelompok3.pages.Menu.*;
import com.TugasAkhirKelompok3.pages.authentications.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.WebDriver;

public class Lembur {
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

    @Given("User sudah login ke aplikasi untuk lembur")
    public void user_sudah_login_ke_aplikasi_lembur() {
    }

    @And("I scroll and click lembur button")
    public void iScrollAndClickLemburButton() {
        dashboardPage.goToLemburPage();
    }

    @And("click the Ajukan Lembur button")
    public void iScrollAndClickTheAjukanButton() {
        lemburPage.submitLembur();
    }

    @And("I input data on clockin {string} clockout {string} and Catatan {string}")
    public void iInputDataOnClockinClockoutAndCatatan(String clockIn, String clockOut, String catatan) {
        lemburPage.fillFormLembur(clockIn, clockOut, catatan);
    }

    @Then("Lembur berhasil diajukan")
    public void lemburBerhasilDiajukan() {
        assert lemburPage.isSuccessMessageDisplayed();
    }
}
