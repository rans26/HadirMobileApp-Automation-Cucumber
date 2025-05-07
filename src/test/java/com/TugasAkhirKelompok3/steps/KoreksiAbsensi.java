package com.TugasAkhirKelompok3.steps;

import com.TugasAkhirKelompok3.drivers.DriverSingleton;
import com.TugasAkhirKelompok3.pages.Menu.AbsensiPage;
import com.TugasAkhirKelompok3.pages.Menu.DashboardPage;
import com.TugasAkhirKelompok3.pages.Menu.KoreksiAbsensiPage;
import com.TugasAkhirKelompok3.pages.authentications.LoginPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class KoreksiAbsensi {

    private WebDriver driver;
    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private AbsensiPage absensiPage;
    private KoreksiAbsensiPage koreksiAbsensiPage;

    @Before
    public void setup() {
        driver = DriverSingleton.getDriver();
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        absensiPage = new AbsensiPage(driver);
        koreksiAbsensiPage = new KoreksiAbsensiPage(driver);
    }


//    @Given("I am on the Dashboard page2")
//    public void i_am_on_the_dashboard_page2(){
//        DriverManager.getDriver().get("https://magang.dikahadir.com/apps/absent");
//        Assert.assertTrue(dashboardAbsensiPages.isDashboardPagesDisplayed());
//    }

    @When("I scroll and click to Koreksi Absensi button")
    public void i_scroll_and_click_the_Koreksi_Absensi_button() throws InterruptedException {
        koreksiAbsensiPage.scrollPage();
        Thread.sleep(2000);
        koreksiAbsensiPage.clickKoreksiAbsensi();
        Thread.sleep(1000);
    }

        @When("I click the Koreksi Absensi button")
        public void i_click_the_login_button() throws InterruptedException {
            Thread.sleep(2000);
            koreksiAbsensiPage.clickKoreksiAbsensi();
            Thread.sleep(1000);
        }
        @When("I scroll and click the Ajukan Koreksi button")
        public void i_scroll_and_click_the_Ajukan_Koreksi_button() throws InterruptedException {
            Thread.sleep(3000);
        koreksiAbsensiPage.clickAjukanKoreksi();
            Thread.sleep(2000);

        }

        @When("I input data on clockin clockout and Tipe Absen")
        public void I_input_data_on_clockin_clockout_and_Tipe_Absen() throws InterruptedException {
            Thread.sleep(2000);
            koreksiAbsensiPage.checkinButton();
            Thread.sleep(2000);
            koreksiAbsensiPage.ClickDaysCheckIn();
            Thread.sleep(2000);
            koreksiAbsensiPage.ClickDHoursCheckin();
            Thread.sleep(2000);
            koreksiAbsensiPage.ClickDMinutesCheckin();
            Thread.sleep(2000);
            koreksiAbsensiPage.checkoutButton();
            Thread.sleep(1000);
            koreksiAbsensiPage.ClickDaysCheckOut();
            Thread.sleep(1000);
            koreksiAbsensiPage.ClickDHoursCheckout();
            Thread.sleep(2000);
            koreksiAbsensiPage.ClickDMinutesCheckout();
            Thread.sleep(2000);
            koreksiAbsensiPage.ClickTipeAbsen();
            Thread.sleep(1000);
            koreksiAbsensiPage.ClickWFH();
            Thread.sleep(1000);

        }

        @And ("I input data on clockout")
        public void I_input_data_on_clockout() throws InterruptedException {
            Thread.sleep(2000);
            koreksiAbsensiPage.checkoutButton();
            Thread.sleep(2000);
            koreksiAbsensiPage.ClickDaysCheckOut();
            Thread.sleep(2000);
            koreksiAbsensiPage.ClickDHoursCheckout();
            Thread.sleep(2000);
            koreksiAbsensiPage.ClickDMinutesCheckout();
            Thread.sleep(1000);

        }
        @When("I click Reset")
        public void I_click_Reset() throws InterruptedException {
            Thread.sleep(2000);
            koreksiAbsensiPage.ClickReset();
            Thread.sleep(1000);
        }
        @When("I input data on clockin")
        public void I_input_data_on_clockin() throws InterruptedException {
            Thread.sleep(2000);
            koreksiAbsensiPage.checkinButton();
            Thread.sleep(2000);
            koreksiAbsensiPage.ClickDaysCheckIn();
            Thread.sleep(2000);
            koreksiAbsensiPage.ClickDHoursCheckin();
            Thread.sleep(2000);
            koreksiAbsensiPage.ClickDMinutesCheckin();
            Thread.sleep(2000);

        }
        @When("I input data on clockin and Tipe Absen")
        public void I_input_data_on_clockin_and_Tipe_Absen() throws InterruptedException {
            Thread.sleep(2000);
            koreksiAbsensiPage.checkinButton();
            Thread.sleep(2000);
            koreksiAbsensiPage.ClickDaysCheckIn();
            Thread.sleep(2000);
            koreksiAbsensiPage.ClickDHoursCheckin();
            Thread.sleep(2000);
            koreksiAbsensiPage.ClickDMinutesCheckin();
            Thread.sleep(2000);
            koreksiAbsensiPage.ClickTipeAbsen();
            Thread.sleep(2000);
            koreksiAbsensiPage.ClickWFH();
            Thread.sleep(1000);

        }




    @Then("I should see an error message koreksi {string}")
    public void i_should_see_an_error_message_koreksi(String expectedErrorMessage)throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertEquals(expectedErrorMessage, koreksiAbsensiPage.getErrorMessage());
    }
    @Then("I should be redirected to the Koreksi Absensi page and and be able to see the corrected absences that I have input")
    public void I_should_be_redirected_to_the_Koreksi_Absensi_page_and_and_be_able_to_see_the_corrected_absences_that_I_have_input() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(koreksiAbsensiPage.isKoreksiAbsensiDisplayed());
        Thread.sleep(1000);
    }
        @Then("I should be redirected to the Koreksi Absensi page with empty data")
    public void I_should_be_redirected_to_the_Koreksi_Absensi_page_with_empty_data() throws InterruptedException {
            Thread.sleep(2000);
            koreksiAbsensiPage.ClickAjukanCIOA();
        Thread.sleep(1000);
    }


    @And ("I click AjukanCIOA")
    public void I_click_AjukanCIOA() throws InterruptedException {
        Thread.sleep(1000);
        koreksiAbsensiPage.ClickAjukanCIOA();
        Thread.sleep(1000);
    }

    @And ("I click AjukanCIA")
    public void I_click_AjukanCIA() throws InterruptedException {
        Thread.sleep(1000);
        koreksiAbsensiPage.ClickAjukanCIA();
        Thread.sleep(1000);
    }

    @And ("I click AjukanCI")
    public void I_click_AjukanCI() throws InterruptedException {
        Thread.sleep(1000);
        koreksiAbsensiPage.ClickAjukanCI();
        Thread.sleep(1000);
    }

    @And ("I click AjukanCO")
    public void I_click_AjukanCO() throws InterruptedException {
        Thread.sleep(1000);
        koreksiAbsensiPage.ClickAjukanCO();
        Thread.sleep(1000);
    }

    @And ("I click AjukanKosong")
    public void I_click_AjukanKosong() throws InterruptedException {
        Thread.sleep(1000);
        koreksiAbsensiPage.ClickAjukanKosong();
        Thread.sleep(1000);
    }


    }



