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

public class Login {
    private LoginPage loginPages;
    private WebDriver driver;
    private DashboardPage dashboardPage;
    private RegisterPage registerPage;

    @Before()
    public void setup() {
        driver = DriverSingleton.getDriver();
        loginPages = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
        registerPage = new RegisterPage(driver);
    }

    @Given("I am on the login page")
    public void i_am_on_the_login_page(){
       loginPages.openPage();
        Assert.assertTrue(loginPages.isLoginPagesDisplayed());
    }

    @When("I enter email {string} and password {string}")
    public void i_enter_email_and_password(String email, String password) throws InterruptedException {
        loginPages.enterEmail(email);
        loginPages.enterPassword(password);
        Thread.sleep(1000);
    }

    @When("I click the login button")
    public void i_click_the_login_button() throws InterruptedException {
        loginPages.clickLogin();
        Thread.sleep(1000);
    }

    @Then("I should see an error message {string}")
    public void i_should_see_an_error_message(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, loginPages.getErrorMessage());
    }

    @Then("I should see a validation message {string}")
    public void i_should_see_a_validation_message(String expectedValidationMessage) {
        Assert.assertTrue(registerPage.getValidationRegister().contains(expectedValidationMessage));
    }

    @Then("I should be redirected to the dashboard page")
    public void i_should_be_redirected_to_the_dashboard_page() {
        Assert.assertTrue(dashboardPage.isDashboardPagesDisplayed());
    }

    @And("I click the navbar at the top right of the page")
    public void iClickTheNavbarAtTheTopRightOfThePage() throws InterruptedException {
        dashboardPage.clickNavbar();
        Thread.sleep(1000);
    }

    @Then("I click Logout at the bottom in the navbar")
    public void iClickLogoutAtTheBottomInTheNavbar() throws InterruptedException {
        dashboardPage.clickLogout();
        Thread.sleep(1000);
    }


    @And("I press back button")
    public void iPressBackButton() {
        driver.navigate().back();
    }

    @Then("Verify user remains on the login page")
    public void verifyUserRemainsOnTheLoginPageNoAccessToDashboard() {
        loginPages.openPage();
        Assert.assertTrue(loginPages.isLoginPagesDisplayed());
    }
}
