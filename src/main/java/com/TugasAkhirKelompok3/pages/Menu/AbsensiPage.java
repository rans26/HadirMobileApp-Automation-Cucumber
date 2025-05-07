package com.TugasAkhirKelompok3.pages.Menu;


import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class AbsensiPage {
    private WebDriver driver;

    private By absensiButton = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[1]/div[1]/div[1]/a[1]/div[1]/span[1]/img[1]");
    private By absensiBackButton = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/div[1]/button[1]/*[name()='svg'][1]/*[name()='g'][1]/*[name()='polyline'][1]");
    private By koreksiAbsensButton = By.xpath("/html[1]/body[1]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[1]/div[2]/div[1]/div[1]/a[1]/p[1]");

    public AbsensiPage(WebDriver driver) {
        this.driver = driver;
    }


    public boolean isDashboardPagesDisplayed(){
        return driver.findElement(absensiBackButton).isDisplayed();
    }
    public void scrollPage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement element = driver.findElement(absensiButton);
        js.executeScript("arguments[0].scrollIntoView(true);", element);

    }

    public void clickAbsensi(){
        driver.findElement(absensiButton).click();
    }

    public void clickBackAbsensi(){
        driver.findElement(absensiBackButton).click();
    }

    public void clickKoreksiAbsens(){
        driver.findElement(koreksiAbsensButton).click();
    }

}

