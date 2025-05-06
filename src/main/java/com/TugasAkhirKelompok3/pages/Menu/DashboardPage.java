package com.TugasAkhirKelompok3.pages.Menu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    private String baseURL = "https://magang.dikahadir.com/absen/login";
    private WebDriver driver;

    private By absenTypeDropdown = By.xpath("//div[@id='mui-component-select-is_wfh']");
    private By noteField = By.xpath("//input[@name='notes']");
    private By noteFieldKeluar = By.xpath("//div[@class='MuiInputBase-root MuiInput-root MuiInput-underline MuiInputBase-colorPrimary MuiInputBase-formControl MuiInputBase-multiline MuiInputBase-adornedStart css-1qmwbyg']");
    private By absenButton = By.xpath("//button[normalize-space()='Absen Masuk']");
    private By cameraButton = By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1xarbr2']");
    private By toastMessage = By.xpath("//div[contains(@class,'Toastify__toast-body')]");
    private By absenKeluarButton = By.xpath("//p[@class='MuiTypography-root MuiTypography-body1 css-1plcj5e']");
    private By absenMasukButton = By.xpath("//button[@type='submit']");
    private By navbarButton = By.xpath("//img[@alt='menu']");
    private By logoutButton = By.xpath("//button[normalize-space()='Logout']");
    private By wfoButton = By.xpath("//*[@id=\"mui-6\"]/li[1]");
    private By wfhButton = By.xpath("//*[@id=\"mui-6\"]/li[2]");

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPage() {
        driver.get(baseURL);
    }

    public void selectAbsenType(String absenType) {
        driver.findElement(absenTypeDropdown).click();


        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.elementToBeClickable(wfhButton));
        if (absenType.equalsIgnoreCase("Work From Office")) {
            wait.until(ExpectedConditions.elementToBeClickable(wfoButton)).click();
        } else if (absenType.equalsIgnoreCase("Work From Home")) {
            wait.until(ExpectedConditions.elementToBeClickable(wfhButton)).click();
        }
    }

    public void inputNote(String note) {
        driver.findElement(noteField).clear();
        driver.findElement(noteField).sendKeys(note);
    }

    public void inputNoteAbsenKeluar(String note) throws InterruptedException {
        driver.findElement(noteFieldKeluar).click();
        Thread.sleep(2000);
        driver.findElement(noteFieldKeluar).sendKeys(note);
    }

    public void clickAbsenMasuk() {
        driver.findElement(absenButton).click();
    }

    public String getToastMessage(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(toastMessage)).getText();
    }

    public boolean isDashboardPagesDisplayed(){
        return driver.findElement(absenButton).isDisplayed();
    }

    public void clickCamera() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cameraButton));
        driver.findElement(cameraButton).click();
    }

    public void clickAbsenKeluar() {
        driver.findElement(absenKeluarButton).click();
    }

    public void clickAbsenMasukPopUp() {
        driver.findElement(absenMasukButton).click();
    }

    public boolean isAbsenKeluarButtonDisplayed(){
        return driver.findElement(absenKeluarButton).isDisplayed();
    }

    public void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(absenKeluarButton);
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }


    public void clickNavbar() {
        driver.findElement(navbarButton).click();
    }

    public void clickLogout() {
        driver.findElement(logoutButton).click();
    }
}
