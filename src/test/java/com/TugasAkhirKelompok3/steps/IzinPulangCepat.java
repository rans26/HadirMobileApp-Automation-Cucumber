package com.TugasAkhirKelompok3.steps;

import com.TugasAkhirKelompok3.drivers.DriverSingleton;
import com.TugasAkhirKelompok3.pages.Menu.*;
import com.TugasAkhirKelompok3.pages.authentications.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

public class IzinPulangCepat {
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

            public void user_sudah_login_ke_aplikasi_izin_pulang_cepat() {
                // Sudah login di @Before, jadi kosongkan atau tambahkan komentar
            }

            @When("User mengajukan izin pulang cepat dengan tanggal {string}, jam {string}, dan keterangan {string}")
            public void user_mengajukan_izin_pulang_cepat (String tanggal, String jam, String keterangan){
                izinPulangCepatPage = new IzinPulangCepatPage(driver);
                izinPulangCepatPage.submitIzinPulangCepat(tanggal, jam, keterangan);
            }
            @Then("Izin pulang cepat berhasil diajukan")
            public void izin_pulang_cepat_berhasil_diajukan () {
        }
    }
}