package com.TugasAkhirKelompok3.pages.Menu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SakitPage {
    private WebDriver driver;

    private By sakitButton = By.xpath("//*[@id=\"__next\"]/div/div/div[1]/div[3]/div/div/div[6]/div/div");
    private By ajukanSakit = By.xpath( "//*[@id=\"__next\"]/div/div[3]/div/div[3]/button");
    private By tanggallButton = By.xpath("/html/body/div[2]/div[3]/div/form/div/div[1]/div");
    private By pilihTanggal = By.xpath( "/html/body/div[3]/div[3]/div/div/div[1]/div[2]/div[3]/div/div[2]/button[14]");
    private By simpanButton = By.xpath( "/html/body/div[3]/div[3]/div/div/div[2]/button[2]");
    private By ajukanButton = By.xpath( "//form/div/div[3]/button[2]");


    public SakitPage(WebDriver driver){
        this.driver = driver;
    }

    public void clickSakit(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(sakitButton));
        driver.findElement(sakitButton).click();
    }
    public void clickAjukanSakit(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ajukanSakit));
        driver.findElement(ajukanSakit).click();
    }
    public void clickTanggal(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(tanggallButton));
        driver.findElement(tanggallButton).click();
    }
    public void clickPilihTanggal(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(pilihTanggal));
        driver.findElement(pilihTanggal).click();
    }
    public void clickSimpan(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(simpanButton));
        driver.findElement(simpanButton).click();
    }
    public void clickUpload(){
        WebElement fileInput = driver.findElement(By.xpath("//input[@type='file']"));
        fileInput.sendKeys("C:\\Users\\USER\\Pictures\\surat sakit.jpg");
    }
    public void clickAjukan(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ajukanButton));
        driver.findElement(ajukanButton).click();
    }

    public boolean scrollToSakitButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(sakitButton);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return element.isDisplayed();
    }
    public String getErrorMessageDateSick() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Incorrect datetime value')]")));
        return errorElement.getText();
    }
    public String getErrorMessageDuplicateDate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Anda sudah melakukan izin sakit di tanggal tersebut')]")));
        return errorElement.getText();
    }
}
