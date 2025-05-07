package com.TugasAkhirKelompok3.pages.Menu;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CutiPage {
    private WebDriver driver;

    private By cutiButton = By.xpath("//*[@id=\"__next\"]/div/div/div[1]/div[3]/div/div/div[5]/div/div/a/div");
    private By ajukanButton =  By.xpath("//*[@id=\"__next\"]/div/div[3]/div/div[3]/button");
    private By typeAbsen = By.xpath("//*[@id=\"leave_type_id\"]");
    private By tanggalButton = By.xpath("//form//div/div[2]/div");
    private By pilihButton = By.xpath("/html/body/div[3]/div[3]/div/div/div[1]/div[2]/div[3]/div/div[2]/button[12]/span[2]");
    private By simpanButton = By.xpath("/html/body/div[3]/div[3]/div/div/div[2]/button[2]");
    private By submitButton = By.xpath("//form/div/div[4]/button[2]");

    public CutiPage(WebDriver driver) {
        this.driver = driver;
    }
    public void clickCuti(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(cutiButton));
        driver.findElement(cutiButton).click();
    }
    public void clickAjukanButton(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(ajukanButton));
        driver.findElement(ajukanButton).click();
    }
    public void clickPilihan(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(typeAbsen));
        driver.findElement(typeAbsen).click();

    }
    public void clickPilihanType(){
        WebElement option = driver.findElement(By.xpath("//li[contains(text(), 'Pernikahan anak (2 hari)')]"));
        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", option);
    }
    public void clickPilihTanggal(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(tanggalButton));
        driver.findElement(tanggalButton).click();
    }
    public void clickTanggal(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(pilihButton));
        driver.findElement(pilihButton).click();
    }
    public void clickSimpan(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(simpanButton));
        driver.findElement(simpanButton).click();
    }
    public void clickAjukan(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(submitButton));
        driver.findElement(submitButton).click();
    }
    public boolean scrollToCutiButton(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(cutiButton);
        js.executeScript("arguments[0].scrollIntoView(true);", element);
        return element.isDisplayed();
    }
    public String getErrorMessageDate() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[contains(text(),'Incorrect DATE value')]")));
        return errorElement.getText();
    }
    public String getErrorMessageType() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement errorElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Cannot read properties of null')]")));
        return errorElement.getText();
    }

}
