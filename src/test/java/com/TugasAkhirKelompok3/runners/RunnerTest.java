package com.TugasAkhirKelompok3.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {
                "src/test/resources/features/01_Login.feature",
                "src/test/resources/features/02_Register.feature",
                "src/test/resources/features/03_AbsenMasuk.feature",
                "src/test/resources/features/04_AbsenKeluar.feature",
                "src/test/resources/features/05_Absensi.feature",
                "src/test/resources/features/06_KoreksiAbsensi.feature",
                "src/test/resources/features/07_izin_off.feature",
                "src/test/resources/features/06_izin_pulang_cepat.feature",
                "src/test/resources/features/06_izin_terlambat.feature",
                "src/test/resources/features/06_lembur.feature",
                "src/test/resources/features/11_Cuti.feature",
                "src/test/resources/features/12_Sakit.feature",
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
