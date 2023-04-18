package ru.egor.qa.uitest.page_elements;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class SwagLabsPageElements {
    protected  final SelenideElement loginField = $("#user-name");
    protected  final SelenideElement passwordField = $("#password");
    protected  final SelenideElement loginButton = $("#login-button");
    protected  final ElementsCollection inventoryList = $$(".inventory_list");
    protected  final SelenideElement backPackOpenPage = $("#item_4_title_link");
    protected  final SelenideElement backPackPrice = $(".inventory_details_price");
    protected  final SelenideElement addToCartButton = $("#add-to-cart-sauce-labs-backpack");
    protected  final SelenideElement cartBadge = $(".shopping_cart_badge");
    protected  final SelenideElement cartButton = $(".shopping_cart_link");
    protected  final SelenideElement itemPrise = $(".inventory_item_price");
    protected  final SelenideElement errorMessage = $("[data-test=error]");
    protected  final ElementsCollection productNames = $$(".inventory_item_name");
    protected  final ElementsCollection products = $$(".inventory_item");
    protected  final ElementsCollection productPrices = $$(".inventory_item_price");
    protected  final SelenideElement productSortContainer = $("select.product_sort_container");
}
