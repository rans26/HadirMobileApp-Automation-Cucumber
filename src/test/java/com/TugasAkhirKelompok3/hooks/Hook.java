package com.TugasAkhirKelompok3.hooks;

import java.net.MalformedURLException;

import com.TugasAkhirKelompok3.drivers.DriverSingleton;
import com.TugasAkhirKelompok3.drivers.utils.BrowserType;

import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;

public class Hook {
    @BeforeAll
    public static void initialize() throws MalformedURLException {
        DriverSingleton.getDriver(BrowserType.CHROME);
    }

    @AfterAll
    public static void finalTeardown() {
        DriverSingleton.quitDriver();
    }
}
