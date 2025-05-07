package com.TugasAkhirKelompok3.steps;

import com.juaracoding.Pages.SakitPage;
import com.juaracoding.Utils.DriverManager;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class SakitSteps {
    SakitPage sakitPage = new SakitPage(DriverManager.getDriver());

    @Given("I am on the sick page")
    public void i_am_on_the_sick_page(){
        DriverManager.getDriver().get("https://magang.dikahadir.com/apps/absent");
        Assert.assertTrue(sakitPage.scrollToSakitButton());
        sakitPage.clickSakit();
    }
    @When("I click the page sick button")
    public void i_click_the_page_sick_button() throws InterruptedException {
        sakitPage.clickAjukanSakit();
        Thread.sleep(1000);
    }
    @When("I click the date sick")
    public void i_click_the_date_sick() throws InterruptedException {
        sakitPage.clickTanggal();
        sakitPage.clickPilihTanggal();
        sakitPage.clickSimpan();
        Thread.sleep(1000);
    }
    @When("I click the image")
    public void i_click_the_image () throws InterruptedException {
        sakitPage.clickUpload();
        Thread.sleep(1000);
    }
    @When("I click the apply button")
    public void i_click_the_apply_button() throws InterruptedException {
        sakitPage.clickAjukan();
        Thread.sleep(1000);
    }
    @Then("I should be redirected to the list request sick page")
    public void i_should_be_redirected_to_the_list_request_sick_page() {
        String currentUrl = DriverManager.getDriver().getCurrentUrl();
        Assert.assertTrue(currentUrl, currentUrl.contains("/apps/absent/sick"));
    }
    @Then("I should see an error message date sick {string}")
    public void i_should_see_an_error_message_date_sick (String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, sakitPage.getErrorMessageDateSick());
    }
    @Then("I should see an error message duplicate date {string}")
    public void i_should_see_an_error_message_duplicate_date (String expectedErrorMessage) {
        Assert.assertEquals(expectedErrorMessage, sakitPage.getErrorMessageDuplicateDate());
    }
}
