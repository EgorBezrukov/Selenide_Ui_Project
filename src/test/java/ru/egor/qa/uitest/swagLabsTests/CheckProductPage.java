package ru.egor.qa.uitest.swagLabsTests;

import io.qameta.allure.Description;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.egor.qa.uitest.pageObject.LoginPage;
public class CheckProductPage extends BaseTest {

    private static LoginPage loginPage;

    @BeforeAll
    public static void init() {
        loginPage = new LoginPage();
    }

    @Test
    @DisplayName("Проверка количество элементов на странице")
    @Description("Проверить, что при входе на главную страницу, количество элементов равно 6")
    public void checkSizeElement() {
        loginPage
                .successAuth(SWAGLAB_LOGIN, SWAGLAB_PASSWORD)
                .checkSizePageElements(6)
                .logout();
    }

    @Test
    @DisplayName("Пользовательский сценарий, выполнение покупки")
    public void swagShopUserCase() {
        loginPage
                .successAuth(SWAGLAB_LOGIN, SWAGLAB_PASSWORD)
                .addToCart()
                .checkoutBtnClick()
                .fillField("Lol","Balabol","1231")
                .checkAmount("$29.99")
                .logout();
    }
}
