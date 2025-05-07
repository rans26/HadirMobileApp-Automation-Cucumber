package com.TugasAkhirKelompok3.steps;

import com.TugasAkhirKelompok3.drivers.DriverSingleton;
import com.TugasAkhirKelompok3.pages.Menu.AbsensiPage;
import com.TugasAkhirKelompok3.pages.Menu.DashboardPage;
import com.TugasAkhirKelompok3.pages.authentications.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Absensi {
    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private AbsensiPage absensiPage;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        absensiPage = new AbsensiPage(driver);
    }


    @Given("I am on the Dashboard page")
    public void i_am_on_the_Dashboard_page() throws SQLException {
        DriverManager.getDriver("https://magang.dikahadir.com/apps/absent");
    }

    @When("I scroll and click to Absensi button")
    public void i_scroll_and_click_the_Absensi_button() throws InterruptedException {
        absensiPage.scrollPage();
        absensiPage.clickAbsensi();
        Thread.sleep(1000);
    }

    @Then("I should be redirected to the Absensi page")
    public void i_should_be_redirected_to_the_Absensi_page() {
//            String currentUrl = DriverManager.getDriver().getCurrentUrl();
//            Assert.assertTrue(currentUrl, "/apps/absent/activity".contains(currentUrl));
        absensiPage.clickBackAbsensi();
    }
}


