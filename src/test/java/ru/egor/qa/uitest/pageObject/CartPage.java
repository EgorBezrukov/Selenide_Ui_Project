package ru.egor.qa.uitest.pageObject;

import io.qameta.allure.Step;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class CartPage {
    @Step("Перейти на страницу заполнения информации о себе")
    public YourInformation checkoutBtnClick() {
        $("#checkout").highlight().click();
        return page(new YourInformation());
    }
}
