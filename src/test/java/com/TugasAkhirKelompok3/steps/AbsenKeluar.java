package com.TugasAkhirKelompok3.steps;

import com.TugasAkhirKelompok3.pages.Menu.DashboardPage;
import com.TugasAkhirKelompok3.pages.authentications.LoginPage;
import com.TugasAkhirKelompok3.drivers.DriverSingleton;
import io.cucumber.java.en.*;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AbsenKeluar {
    private WebDriver webDriver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Before
    public void setup() {
        webDriver = DriverSingleton.getDriver();
        loginPage = new LoginPage(webDriver);
        dashboardPage = new DashboardPage(webDriver);
    }

    @Given("I am on the absen keluar page")
    public void i_am_on_absen_keluar_page() {
        Assert.assertTrue(webDriver.getCurrentUrl().contains("/apps/absent"));
    }

    @And("I click the absen keluar button")
    public void i_click_the_absen_keluar_button() throws InterruptedException {
            dashboardPage.clickAbsenKeluar();
            Thread.sleep(1000);
    }

    @And("I input {string} absen keluar")
    public void i_input_note(String note) throws InterruptedException {
        dashboardPage.inputNoteAbsenKeluar(note);
        Thread.sleep(2000);
    }

    @And("I click the absen pulang button")
    public void i_click_the_absen_pulang_button() throws InterruptedException {
        dashboardPage.clickAbsenPulang();
        Thread.sleep(1000);
    }

    @Then("I should see a confirmation message {string}")
    public void i_should_see_confirmation_message(String expected) {
        String actual = dashboardPage.getToastMessage();
        Assert.assertTrue(actual.contains(expected));
    }

    @Then("I should see a validation absen message {string}")
    public void i_should_see_validation_absen_message(String expected) {
        String actual = dashboardPage.getToastMessage();
        Assert.assertTrue(actual.contains(expected));
    }
}
