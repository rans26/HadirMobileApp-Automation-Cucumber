package com.TugasAkhirKelompok3.pages.Menu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class KoreksiAbsensiPage {
    private WebDriver driver;

    private By koreksiAbsensiButton = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]/div[1]");
    private By ajukanKoreksiButton = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[3]/button[1]");
    private By checkInButton = By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/*[name()='svg'][1]");
    private By clickDaysCheckIn = By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/button[3]");
    private By clickHoursCheckIn = By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]");
    private By clickMinutesCheckIn = By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]");
    private By checkOutButton = By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[2]/div[1]/div[1]/div[1]/button[1]/*[name()='svg'][1]/*[name()='path'][1]");
    private By clickDaysCheckOut = By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[2]/div[1]/div[2]/button[3]");
    private By clickHoursCheckOut = By.xpath("/html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]");
    private By clickMinutesCheckOut = By.xpath("//html[1]/body[1]/div[3]/div[2]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]");
    private By clickTipeAbsen = By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[3]/div[1]/div[1]");
    private By wfh = By.xpath("/html[1]/body[1]/div[3]/div[3]/ul[1]/li[2]");
    private By wfo = By.xpath("/html[1]/body[1]/div[3]/div[3]/ul[1]/li[3]/span[1]");
    private By ajukanButtonCIOA = By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[4]/button[2]");
    private By ajukanButtonCIA = By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[4]/button[2]");
    private By ajukanButtonCI = By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[4]/button[2]");
    private By ajukanButtonCO = By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[3]/button[2]");
    private By ajukanButtonKosong = By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[3]/button[2]");
    private By resetButton = By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/form[1]/div[1]/div[4]/button[1]");
private By errorMessage = By.xpath("/html[1]/body[1]/div[2]/div[3]/div[1]/form[1]/div[1]/p[1]");

    public KoreksiAbsensiPage(WebDriver driver) {
        this.driver = driver;
    }
    public String getErrorMessage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessage)).getText();
    }
    public void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(koreksiAbsensiButton);
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public void clickKoreksiAbsensi(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(koreksiAbsensiButton));
        driver.findElement(koreksiAbsensiButton).click();
    }
    public void clickAjukanKoreksi(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ajukanKoreksiButton));
        driver.findElement(ajukanKoreksiButton).click();
    }
    public void checkinButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkInButton));
        driver.findElement(checkInButton).click();
    }
    public void checkoutButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(checkOutButton));
        driver.findElement(checkOutButton).click();
    }
    public void ClickDaysCheckIn(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickDaysCheckIn));
        driver.findElement(clickDaysCheckIn).click();
    }
    public void ClickDaysCheckOut(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickDaysCheckOut));
        driver.findElement(clickDaysCheckOut).click();
    }
    public void ClickDHoursCheckin(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickHoursCheckIn));
        driver.findElement(clickHoursCheckIn).click();
    }
    public void ClickDHoursCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickHoursCheckOut));
        driver.findElement(clickHoursCheckOut).click();
    }
    public void ClickDMinutesCheckin(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickMinutesCheckIn));
        driver.findElement(clickMinutesCheckIn).click();
    }
    public void ClickDMinutesCheckout(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickMinutesCheckOut));
        driver.findElement(clickMinutesCheckOut).click();
    }
    public void ClickTipeAbsen(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(clickTipeAbsen));
        driver.findElement(clickTipeAbsen).click();
    }
    public void ClickWFH(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(wfh));
        driver.findElement(wfh).click();
    }
    public void ClickWFO(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(wfo));
        driver.findElement(wfo).click();
    }

    public boolean isKoreksiAbsensiDisplayed(){
        return driver.findElement(ajukanKoreksiButton).isDisplayed();
    }
    public void ClickAjukanCIOA(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ajukanButtonCIOA));
        driver.findElement(ajukanButtonCIOA).click();
    }

    public void ClickAjukanCIA(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ajukanButtonCIA));
        driver.findElement(ajukanButtonCIA).click();
    }

    public void ClickAjukanCI(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ajukanButtonCI));
        driver.findElement(ajukanButtonCI).click();
    }

    public void ClickAjukanCO(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ajukanButtonCO));
        driver.findElement(ajukanButtonCO).click();
    }

    public void ClickAjukanKosong(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ajukanButtonKosong));
        driver.findElement(ajukanButtonKosong).click();
    }

    public void ClickReset(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(resetButton));
        driver.findElement(resetButton).click();
    }
}

