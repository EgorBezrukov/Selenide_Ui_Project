package ru.egor.qa.uitest.common_steps;

import com.codeborne.selenide.WebDriverRunner;
import org.junit.jupiter.api.Assertions;
import ru.egor.qa.uitest.page_elements.SwagLabsPageElements;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.CollectionCondition.sizeGreaterThanOrEqual;
import static com.codeborne.selenide.Selenide.*;

public class SwagLabsBaseTest extends SwagLabsPageElements {

    public void openUrl(String url) {
        open(url);
    }

    public void inputLogin(String login, String password) {
        loginField.sendKeys(login);
        passwordField.sendKeys(password);
        loginButton.click();
    }

    public void checkUrl(String url) {
        String result = WebDriverRunner.getWebDriver().getCurrentUrl();
        Assertions.assertEquals(url, result);
    }

    public void checkError(String massage) {
        String res = errorMessage.getText();
        Assertions.assertEquals(res, massage);
    }

    public void checkElementPage(int quantity) {
        productNames.shouldHave(sizeGreaterThanOrEqual(quantity));
    }

    public void sortsProductsByPriceFromLowToHigh() {
        productSortContainer.selectOptionByValue("lohi");
    }

    public void sortsProductsByPriceFromHighToLow() {
        productSortContainer.selectOptionByValue("hilo");
    }

    public void theProductsShouldBeSortedByPriceFromLowToHigh() {
        products.shouldHave(sizeGreaterThan(0));
        productPrices.shouldHave(sizeGreaterThan(0));
//        $$(".inventory_item_price").shouldBe(sortedBy("text"));
    }

    public void theProductsShouldBeSortedByPriceFromHighToLow() {
        products.shouldHave(sizeGreaterThan(0));
        productPrices.shouldHave(sizeGreaterThan(0));
//        productPrices.shouldBe(sort("text", reverseOrder()));
    }
}
