package com.TugasAkhirKelompok3.steps;

import com.TugasAkhirKelompok3.drivers.DriverSingleton;
import com.TugasAkhirKelompok3.pages.Menu.DashboardPage;
import com.TugasAkhirKelompok3.pages.authentications.LoginPage;
import com.TugasAkhirKelompok3.pages.authentications.RegisterPage;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;


import java.util.Map;

public class Register {
    private WebDriver driver;
    private LoginPage loginPages;
    private DashboardPage dashboardPage;
    private RegisterPage registerPage;

    @Before()
    public void setup() {
        driver = DriverSingleton.getDriver();
        loginPages = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Given("I am on the registration page")
    public void i_am_on_the_registration_page(){
        registerPage.openPage();
        Assert.assertTrue(registerPage.isRegisterPagesDisplayed());
    }

    @When("I click on the register link")
    public void i_click_on_the_register_link() throws InterruptedException {
        registerPage.clickRegister();
        Thread.sleep(1000);
    }

    @Then("I should be redirected to the registration page")
    public void i_should_be_redirected_to_the_registration_page() {
        String currentUrl = driver.getCurrentUrl();
        System.out.println(currentUrl);
    }


    @When("I enter registration details with:")
    public void i_enter_registration_details_with_nik_name_email_password_and_upload_photo(io.cucumber.datatable.DataTable dataTable) {
        Map<String, String> data = dataTable.asMap(String.class, String.class);

        registerPage.enterNIK(data.get("nik"));
        registerPage.enterName(data.get("name"));
        registerPage.enterEmail(data.get("email"));
        registerPage.enterPassword(data.get("password"));
        registerPage.uploadPhotoSelfie(data.get("photo"));
    }


    @When("I click hide and show password")
    public void i_click_hide_and_show_password() throws InterruptedException {
        registerPage.showHidePassword();
        Thread.sleep(1000);
        registerPage.showHidePassword();
   }

    @And("I click the register button")
    public void i_click_the_register_button() throws InterruptedException {
        registerPage.clickButtonRegister();
        Thread.sleep(2000);
    }

    @Then("I should be see message {string}")
    public void i_should_be_see_message(String expectedMessage) throws InterruptedException {
        String actualMessage = registerPage.getNotifMessage();
        Assert.assertEquals(expectedMessage, actualMessage);
    }



}
