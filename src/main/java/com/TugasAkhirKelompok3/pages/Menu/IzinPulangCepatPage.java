package com.TugasAkhirKelompok3.pages.Menu;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IzinPulangCepatPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//button[contains(text(), 'Izin Pulang Cepat')]")
    private WebElement tabIzinPulangCepat;

    @FindBy(xpath = "//button[contains(text(), 'Ajukan Pulang Cepat')]")
    private WebElement tombolAjukanIzin;

    @FindBy(xpath = "//input[@type='time' and @name='time']")
    private WebElement jamPulangCepatField;

    @FindBy(xpath = "//textarea[@name='note']")
    private WebElement catatanField;

    @FindBy(xpath = "//button[normalize-space()='Ajukan']")
    private WebElement tombolSubmit;

    @FindBy(xpath = "//*[contains(text(),'berhasil') or contains(text(),'Berhasil')]")
    private WebElement successMsg;

    public IzinPulangCepatPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void submitIzinPulangCepat(String tanggal, String jam, String keterangan) {
        wait.until(ExpectedConditions.elementToBeClickable(tabIzinPulangCepat)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tombolAjukanIzin)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tombolAjukanIzin)).click();

        wait.until(ExpectedConditions.visibilityOf(jamPulangCepatField)).sendKeys(jam);
        catatanField.sendKeys(keterangan);

        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tombolSubmit);
        wait.until(ExpectedConditions.elementToBeClickable(tombolSubmit)).click();
    }

    public boolean isSuccessMessageDisplayed() {
        try {
            return wait.until(ExpectedConditions.visibilityOf(successMsg)).isDisplayed();
        } catch (TimeoutException e) {
            return false;
        }
    }
}
