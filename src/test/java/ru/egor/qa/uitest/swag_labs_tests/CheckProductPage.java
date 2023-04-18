package ru.egor.qa.uitest.swag_labs_tests;

import org.junit.jupiter.api.Test;
import ru.egor.qa.uitest.common_steps.SwagLabsBaseTest;
import ru.egor.qa.uitest.steps.BaseTest;

public class CheckProductPage extends BaseTest {
    SwagLabsBaseTest sw = new SwagLabsBaseTest();

    @Test
    public void checkThatProductsAreDisplayed() {
        sw.openUrl("https://www.saucedemo.com/");
        sw.inputLogin("standard_user", "secret_sauce");
        sw.checkElementPage(6);
    }

    @Test
    public void productsSortedLowToHigh() {
        sw.openUrl("https://www.saucedemo.com/");
        sw.inputLogin("standard_user", "secret_sauce");
        sw.sortsProductsByPriceFromLowToHigh();
        sw.theProductsShouldBeSortedByPriceFromLowToHigh();
    }

    @Test
    public void productsSortedHighToLow() {
        sw.openUrl("https://www.saucedemo.com/");
        sw.inputLogin("standard_user", "secret_sauce");
        sw.sortsProductsByPriceFromHighToLow();
        sw.theProductsShouldBeSortedByPriceFromHighToLow();
    }
}
