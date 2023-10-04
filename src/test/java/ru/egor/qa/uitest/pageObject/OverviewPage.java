package ru.egor.qa.uitest.pageObject;

import io.qameta.allure.Step;
import ru.egor.qa.uitest.pageElements.SwagLabsPageElements;
import ru.egor.qa.uitest.pageInterface.PageInterface;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.page;

public class OverviewPage extends SwagLabsPageElements implements PageInterface {
    @Step("Проверяем что указанная сумма совпадает с ценой товара")
    public OverviewPage checkAmount(String expectedResult) {
        $(".summary_subtotal_label").getText().contains(expectedResult);
        $("#finish").click();
        return this;
    }
    @Override
    @Step("Выполнить выход из аккаунта")
    public LoginPage logout() {
        sideBarButton.click();
        sideBarLogout.click();
        return page(new LoginPage());
    }
}
