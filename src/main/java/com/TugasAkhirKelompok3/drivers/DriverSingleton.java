package com.TugasAkhirKelompok3.drivers;

import com.TugasAkhirKelompok3.drivers.strategies.DriverStrategyImplementer;
import org.openqa.selenium.WebDriver;

public class DriverSingleton {

    public static WebDriver driver;

    public static WebDriver getDriver(String browser) {
        if (driver == null) {
            driver = new DriverStrategyImplementer().setStrategy(browser);
        }

        return driver;
    }

    public static WebDriver getDriver() {
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}