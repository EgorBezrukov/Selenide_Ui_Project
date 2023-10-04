package ru.egor.qa.uitest.swagLabsTests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.egor.qa.uitest.config.ConfigReader;
import ru.egor.qa.uitest.listeners.AllureListener;

/**
 * Базовый тестовый класс
 */
@ExtendWith(AllureListener.class)//расширяем тестовый класс
abstract public class BaseTest {
    protected final String SWAGLAB_PRODUCT_PAGE_URL = ConfigReader.testDataConfig.SwagLabProductPageUrl();
    protected static final String SWAGLAB_BASE_URL = ConfigReader.testDataConfig.SwagLabBaseUrl();
    protected static final String SWAGLAB_LOGIN = ConfigReader.testDataConfig.SwagLabLogin();
    protected static final String SWAGLAB_PASSWORD = ConfigReader.testDataConfig.SwagLabPassword();

    @BeforeAll
    public static void setUp() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
        Configuration.browserPosition = "0x0";
        Configuration.timeout = 10000;
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide()
                                .screenshots(true)
                                .savePageSource(true));
    }
//    @AfterEach
//    public void afterEach() {
//        step("Закрыть приложение", Selenide::closeWebDriver);
//    }

}
