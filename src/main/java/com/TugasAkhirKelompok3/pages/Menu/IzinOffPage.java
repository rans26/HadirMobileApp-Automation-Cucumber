package com.TugasAkhirKelompok3.pages.Menu;

import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class IzinOffPage {
    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(xpath = "//button[contains(text(), 'Izin Off')]")
    private WebElement tabIzinOff;

    @FindBy(xpath = "//button[contains(text(), 'Ajukan Izin Off')]")
    private WebElement tombolAjukanIzinOff;

    @FindBy(xpath = "//button[normalize-space()='Ajukan']")
    private WebElement tombolAjukan;

    @FindBy(xpath = "//input[@placeholder='mm/dd/yyyy']")
    private WebElement tanggalField;

    @FindBy(xpath = "//textarea")
    private WebElement alasanOffField;

    public IzinOffPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public void submitIzin(String tanggal, String keterangan) {
        try {
            wait.until(ExpectedConditions.elementToBeClickable(tabIzinOff)).click();
            wait.until(ExpectedConditions.elementToBeClickable(tombolAjukanIzinOff)).click();

            wait.until(ExpectedConditions.visibilityOf(tanggalField));
            tanggalField.clear();
            tanggalField.sendKeys(tanggal);

            wait.until(ExpectedConditions.visibilityOf(alasanOffField));
            alasanOffField.clear();
            alasanOffField.sendKeys(keterangan);

            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", tombolAjukan);
            wait.until(ExpectedConditions.elementToBeClickable(tombolAjukan)).click();

        } catch (TimeoutException e) {
            System.out.println(" Timeout saat menunggu elemen muncul: " + e.getMessage());
        } catch (NoSuchElementException e) {
            System.out.println(" Elemen tidak ditemukan: " + e.getMessage());
        } catch (Exception e) {
            System.out.println(" Gagal submit izin off: " + e.getMessage());
        }
    }
}

