package com.TugasAkhirKelompok3.pages.Menu;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IzinTerlambatPage {

    private WebDriver driver;
    private WebDriverWait wait;

    private By btnAjukanIzin = By.xpath("//*[@id=\"mui-p-6759-P-late\"]/div[3]/button");
    private By fieldTanggal = By.name("tanggal");
    private By fieldJam = By.name("jam");
    private By fieldKeterangan = By.name("keterangan");
    private By btnSubmit = By.xpath("//button[contains(text(), 'Submit')]");
    private By successMsg = By.xpath("//*[contains(text(),'berhasil') or contains(text(),'Berhasil')]");

    public IzinTerlambatPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public void submitIzin(String tanggal, String jam, String keterangan) {
        scrollToBottom();

        // Klik tombol ajukan
        wait.until(ExpectedConditions.elementToBeClickable(btnAjukanIzin)).click();

        // Isi form
        wait.until(ExpectedConditions.visibilityOfElementLocated(fieldTanggal)).clear();
        driver.findElement(fieldTanggal).sendKeys(tanggal);

        WebElement jamField = driver.findElement(fieldJam);
        jamField.clear();
        jamField.sendKeys(jam);

        WebElement ketField = driver.findElement(fieldKeterangan);
        ketField.clear();
        ketField.sendKeys(keterangan);

        // Klik submit
        driver.findElement(btnSubmit).click();
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOfElementLocated(successMsg)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }

    private void scrollToBottom() {
        ((JavascriptExecutor) driver).executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
    public void clickMenuAjukanIzinTerlambat() {
        driver.findElement(btnAjukanIzin).click();

    }
}
