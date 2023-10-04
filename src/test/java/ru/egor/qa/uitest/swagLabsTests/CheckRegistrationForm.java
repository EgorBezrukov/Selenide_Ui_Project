package ru.egor.qa.uitest.swagLabsTests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.egor.qa.uitest.pageObject.LoginPage;

@DisplayName("Тесты для формы регистрации")
public class CheckRegistrationForm extends BaseTest {
    private static LoginPage loginPage;

    @BeforeAll
    public static void init() {
        loginPage = new LoginPage();
    }

    @Test
    @DisplayName("Успешный вход")
    @Description("Проверить, что при вводе правильного логина и пароля пользователь успешно авторизуется и перенаправляется на страницу с продуктами")
    public void successfullyLogged() {
        loginPage
                .successAuth(SWAGLAB_LOGIN, SWAGLAB_PASSWORD)
                .checkPageOpen(SWAGLAB_PRODUCT_PAGE_URL)
                .logout();
    }

    @Test
    @DisplayName("Вход с пустыми полями")
    @Description("Вход с пустыми полями логина и пароля, проверка сообщения об ошибке")
    public void emptiesField() {
        loginPage
                .unSuccessAuth("", "")
                .checkErrorMessage("Epic sadface: Username is required")
                .cleanField();
    }

    @Test
    @DisplayName("Вход с невалидным логином")
    @Description("Проверить, что при вводе неправильного логина или пароля отображается сообщение об ошибке")
    public void incorrectLogin() {
        loginPage
                .unSuccessAuth("HELPDESK_LOGIN", "SWAGLAB_PASSWORD")
                .checkErrorMessage("Epic sadface: Username and password do not match any user in this service")
                .cleanField();
    }
}
