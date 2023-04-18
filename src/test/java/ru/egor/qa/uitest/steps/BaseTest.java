package ru.egor.qa.uitest.steps;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;

abstract public class BaseTest {

    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.driverManagerEnabled = true;
        Configuration.browserSize = "1920x1080";
        Configuration.timeout = 60000;
        SelenideLogger
                .addListener("AllureSelenide", new AllureSelenide()
                .screenshots(true)
                .savePageSource(true)
        );
    }

    @BeforeAll
    public static void init() {
        setUp();
    }

    @AfterEach
    public void tearDown() {
        WebDriverRunner.getWebDriver().close();
        WebDriverRunner.getWebDriver().quit();
    }


}
