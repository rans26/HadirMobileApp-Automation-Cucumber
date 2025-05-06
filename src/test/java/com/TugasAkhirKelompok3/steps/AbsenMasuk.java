package com.TugasAkhirKelompok3.steps;

import com.TugasAkhirKelompok3.drivers.DriverSingleton;
import com.TugasAkhirKelompok3.pages.Menu.DashboardPage;
import com.TugasAkhirKelompok3.pages.authentications.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.*;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class AbsenMasuk {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Given("I am logged in as user with email {string} and password {string}")
    public void i_am_logged_in_as_user_with_email_and_password(String email, String password) throws InterruptedException {
        loginPage.openPage();
        loginPage.enterEmail(email);
        loginPage.enterPassword(password);
        loginPage.clickLogin();
        Thread.sleep(2000);
        Assert.assertTrue(dashboardPage.isDashboardPagesDisplayed());
    }

    @And("I am on the absen masuk page")
    public void i_am_on_the_absen_masuk_page() throws InterruptedException {
        dashboardPage.clickAbsenMasuk();
        Thread.sleep(5000);
        dashboardPage.clickCamera();
        Thread.sleep(5000);
    }

    @When("I select absen type {string}")
    public void i_select_absen_type(String absenType) {
        dashboardPage.selectAbsenType(absenType);
    }

    @And("I input note {string}")
    public void i_input_note(String note) throws InterruptedException {
        Thread.sleep(1000);
        dashboardPage.inputNote(note);
    }

    @And("I click the {string} button")
    public void i_click_the_absen_masuk_button(String buttonName) throws InterruptedException {
        if (buttonName.equalsIgnoreCase("Absen Masuk")) {
            dashboardPage.clickAbsenMasukPopUp();
            Thread.sleep(2000);
        }
    }

    @And("I click the absen masuk button")
    public void i_click_the_absen_masuk_button() throws InterruptedException {
        dashboardPage.clickAbsenMasukPopUp();
    }

    @And("I should see button absen keluar")
    public void i_should_see_button_absen_keluar() throws InterruptedException {
        dashboardPage.scrollPage();
        Thread.sleep(3000);
        Assert.assertTrue(dashboardPage.isAbsenKeluarButtonDisplayed());
    }

    @And("I should see the current time displayed")
    public void i_should_see_the_current_time_displayed() {
        Assert.assertTrue(dashboardPage.isTimeDisplayed());
    }



}
