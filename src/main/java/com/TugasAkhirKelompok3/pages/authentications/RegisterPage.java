package com.TugasAkhirKelompok3.pages.authentications;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.File;

public class RegisterPage {
    private String baseURL = "https://magang.dikahadir.com/absen/register";
    private WebDriver driver;

    private By nikField = By.xpath("//input[@id='nik']");
    private By nameField = By.xpath("//input[@id='fullname']");
    private By emailField = By.xpath("//input[@id='email']");
    private By passwordField = By.xpath("//input[@id='password']");
    private By buttonRegister = By.xpath("//button[@id='submit']");
    private By loginRegisterButton = By.xpath("//button[normalize-space()='disini']");
    private By hidePassswordButton = By.xpath("//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yhx7lq']//*[name()='svg']");
    private By successMessage = By.xpath("//div[@role='alert']");
    private By fileErrorMessage = By.xpath("//p[@id='selfie-helper-text']");


    public RegisterPage(WebDriver driver){
        this.driver = driver;
    }

    public void openPage() {
        driver.get(baseURL);
    }

    public void enterNIK(String NIK) {
        driver.findElement(nikField).sendKeys(NIK);
    }

    public void enterName(String name) {
        driver.findElement(nameField).sendKeys(name);
    }

    public void enterEmail(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void showHidePassword(){
        driver.findElement(hidePassswordButton).click();
    }

    public void clickButtonRegister(){
        driver.findElement(buttonRegister).click();
    }

    public void uploadPhotoSelfie(String path){
        if (path != null && !path.trim().isEmpty()) {
            File uploadFile = new File(path);
            WebElement fileInput = driver.findElement(By.xpath("//input[@id='selfie']"));
            fileInput.sendKeys(uploadFile.getAbsolutePath());
        }
    }

    public String getValidationRegister() {
        WebElement emailInput = driver.findElement(emailField);
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return (String) js.executeScript("return arguments[0].validationMessage;", emailInput);
    }

    public void clickRegister(){
        driver.findElement(loginRegisterButton).click();
    }

    public boolean isRegisterPagesDisplayed(){
        return driver.findElement(buttonRegister).isDisplayed();
    }

    public String getNotifMessage() throws InterruptedException {
        Thread.sleep(6000);
        return driver.findElement(successMessage).getText();
    }

    public String getFileErrorMessage() {
        return driver.findElement(fileErrorMessage).getText();
    }
}
