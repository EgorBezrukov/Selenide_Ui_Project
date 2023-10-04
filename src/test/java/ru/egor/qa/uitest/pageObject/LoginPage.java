package ru.egor.qa.uitest.pageObject;

import io.qameta.allure.Step;
import ru.egor.qa.uitest.pageElements.SwagLabsPageElements;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.Selenide.page;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;

public class LoginPage extends SwagLabsPageElements {
    public LoginPage() {
        open("https://www.saucedemo.com/");
        if (!getWebDriver().getTitle().equals("Swag Labs")) {
            throw new IllegalStateException("This is not Login Page, " +
                    "current page is: " + getWebDriver().getCurrentUrl());
        }
    }

    @Step("Успешная авторизация")
    public ProductsPage successAuth(String login, String password) {
        loginField.highlight().sendKeys(login);
        passwordField.highlight().setValue(password);
        loginButton.click();
        return page(new ProductsPage());
    }

    @Step("Неуспешная авторизация")
    public LoginPage unSuccessAuth(String login, String password) {
        loginField.highlight().sendKeys(login);
        passwordField.highlight().setValue(password);
        loginButton.click();
        return this;
    }

    @Step("Проверить, что отображается сообщение об ошибке")
    public LoginPage checkErrorMessage(String message) {
        errorMessage.shouldHave(text(message));
        return this;
    }
    @Step("Очистить поле логина и пароля")
    public LoginPage cleanField(){
        loginField.clear();
        passwordField.clear();
        return this;
    }
}
