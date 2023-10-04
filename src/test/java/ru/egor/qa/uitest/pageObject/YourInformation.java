package ru.egor.qa.uitest.pageObject;

import io.qameta.allure.Step;
import ru.egor.qa.uitest.pageElements.SwagLabsPageElements;
import ru.egor.qa.uitest.pageInterface.PageInterface;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class YourInformation extends SwagLabsPageElements implements PageInterface {
    @Step("Заполняем информацию о себе и переходим на следующую страницу")
    public OverviewPage fillField(String firstName, String lastName, String postalCode) {
        $("[data-test=firstName]").highlight().sendKeys(firstName);
        $("[data-test=lastName]").highlight().sendKeys(lastName);
        $("[data-test=postalCode]").highlight().sendKeys(postalCode);
        $("#continue").highlight().click();
        return page(new OverviewPage());
    }

    @Override
    @Step("Выполнить выход из аккаунта")
    public LoginPage logout() {
        sideBarButton.click();
        sideBarLogout.click();
        return page(new LoginPage());
    }
}
