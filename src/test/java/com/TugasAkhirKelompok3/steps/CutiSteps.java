package com.TugasAkhirKelompok3.steps;

import com.juaracoding.Pages.CutiPage;
import com.juaracoding.Utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class CutiSteps {
    CutiPage cutiPage = new CutiPage(DriverManager.getDriver());

    @Given("I am on the leave page")
    public void i_am_om_the_leave_page(){
        DriverManager.getDriver().get("https://magang.dikahadir.com/apps/absent");
        Assert.assertTrue(cutiPage.scrollToCutiButton());
        cutiPage.clickCuti();
    }
    @When("I click the leave page button")
    public void i_click_the_leave_page_button() throws InterruptedException {
        cutiPage.clickAjukanButton();
        Thread.sleep(1000);
    }
    @When("I click choose type")
    public void i_click_type() throws InterruptedException {
        cutiPage.clickPilihan();
        cutiPage.clickPilihanType();
        Thread.sleep(1000);
    }
    @When("I click date")
    public void i_click_date() throws InterruptedException {
        cutiPage.clickPilihTanggal();
        cutiPage.clickTanggal();
        cutiPage.clickSimpan();
        Thread.sleep(1000);
    }
    @When("I click the leave button")
    public void i_click_the_leave_button() throws InterruptedException {
        cutiPage.clickAjukan();
        Thread.sleep(1000);
    }
    @Then("I should be redirected to the list request leave page")
    public void i_should_be_redirected_to_the_list_request_leave_page() {
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl, currentUrl.contains("/apps/absent/leave-client"));
    }
    @Then("I should see an error message date leave {string}")
    public void i_should_see_an_error_message_date_leave (String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, cutiPage.getErrorMessageDate());
    }
    @Then("I should see an error message type is null {string}")
    public void i_should_see_error_message_type_is_null(String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, cutiPage.getErrorMessageType());
    }

}
