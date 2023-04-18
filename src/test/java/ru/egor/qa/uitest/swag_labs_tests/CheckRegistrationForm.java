package ru.egor.qa.uitest.swag_labs_tests;

import org.junit.jupiter.api.Test;
import ru.egor.qa.uitest.common_steps.SwagLabsBaseTest;
import ru.egor.qa.uitest.steps.BaseTest;

public class CheckRegistrationForm extends BaseTest {
    SwagLabsBaseTest sw = new SwagLabsBaseTest();
    @Test
    public void successfullyLogged() {
        sw.openUrl("https://www.saucedemo.com/");
        sw.inputLogin("standard_user", "secret_sauce");
        sw.checkUrl("https://www.saucedemo.com/inventory.html");
    }

    @Test
    public void emptiesField() {
        sw.openUrl("https://www.saucedemo.com/");
        sw.inputLogin("", "");
        sw.checkError("Epic sadface: Username is required");
    }

    @Test
    public void incorrectLogin() {
        sw.openUrl("https://www.saucedemo.com/");
        sw.inputLogin("user", "secret_sauce");
        sw.checkError("Epic sadface: Username and password do not match any user in this service");
    }
}
