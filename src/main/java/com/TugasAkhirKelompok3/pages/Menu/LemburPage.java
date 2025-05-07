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

public class LemburPage {
    private WebDriver driver;
    private WebDriverWait wait;

    public LemburPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//button[contains(text(), 'Lembur')]")
    private WebElement tombolLembur;

    @FindBy(xpath = "//button[contains(text(), 'Ajukan Lembur')]")
    private WebElement tombolAjukanLembur;

    @FindBy(xpath = "//input[@type='time' and @name='clock_in']")
    private WebElement clockInField;

    @FindBy(xpath = "//input[@type='time' and @name='clock_out']")
    private WebElement clockOutField;

    @FindBy(xpath = "//textarea[@name='note']")
    private WebElement catatanField;

    @FindBy(xpath = "//button[normalize-space()='Ajukan']")
    private WebElement tombolSubmit;

    @FindBy(xpath = "//*[contains(text(),'berhasil') or contains(text(),'Berhasil')]")
    private WebElement successMsg;

    public void fillFormLembur(String clockIn, String clockOut, String catatan) {
        wait.until(ExpectedConditions.elementToBeClickable(tombolLembur)).click();
        wait.until(ExpectedConditions.elementToBeClickable(tombolAjukanLembur)).click();

        wait.until(ExpectedConditions.visibilityOf(clockInField)).clear();
        clockInField.sendKeys(clockIn);

        wait.until(ExpectedConditions.visibilityOf(clockOutField)).clear();
        clockOutField.sendKeys(clockOut);

        wait.until(ExpectedConditions.visibilityOf(catatanField)).clear();
        catatanField.sendKeys(catatan);
    }

    public void submitLembur() {
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

