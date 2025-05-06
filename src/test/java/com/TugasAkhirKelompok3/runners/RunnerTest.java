package com.TugasAkhirKelompok3.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/features/Login.feature",
                "src/test/resources/features/Register.feature",
                "src/test/resources/features/AbsenMasuk.feature",
                "src/test/resources/features/AbsenKeluar.feature",
        },
        glue = {
                "com.TugasAkhirKelompok3.hooks",
                "com.TugasAkhirKelompok3.steps",
        },
        plugin = {"pretty", "html:target/cucumber-report.html", "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"},
        monochrome = true
)
public class RunnerTest extends AbstractTestNGCucumberTests {
}
