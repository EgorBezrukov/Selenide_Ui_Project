package ru.egor.qa.uitest.pageObject;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;
import ru.egor.qa.uitest.pageElements.SwagLabsPageElements;
import ru.egor.qa.uitest.pageInterface.PageInterface;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.page;
import static java.lang.String.valueOf;
import static java.time.Duration.ofMillis;

public class ProductsPage extends SwagLabsPageElements implements PageInterface {
    @Step("Проверить что страница открылась")
    public ProductsPage checkPageOpen(String currentUrl) {
        String url = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertEquals(url, currentUrl);
        return this;
    }

    @Step("Добавить товар корзину и перейти в корзину")
    public CartPage addToCart() {
        addToCartButton.highlight().click();
        cartButton.highlight().click();
        return page(new CartPage());
    }

    @Step("Проверить количество элементов на странице")
    public ProductsPage checkSizePageElements(int actual) {
        productNames.should(size(actual), ofMillis(5000));
        return this;
    }

    @Step("Проверить количество товаров в корзине")
    public ProductsPage checkSizeCartElements(int actual) {
        cartBadge.shouldHave(text(valueOf(actual)));
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
