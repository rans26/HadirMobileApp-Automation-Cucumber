package com.TugasAkhirKelompok3.drivers.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager {
    public static WebDriver make(){
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--use-fake-ui-for-media-stream");
        options.setBinary("C:\\chrome-win64\\chrome.exe");
        options.addArguments("--start-maximized");
        return new ChromeDriver(options);
    }
}