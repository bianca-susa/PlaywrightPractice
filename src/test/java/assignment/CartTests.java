package assignment;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import java.util.regex.Pattern;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class CartTests extends TestSetup{

    @Test
    void addProductToCart()
    {
        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/");

        Locator category = page.locator("#nav > ol > li.level0.nav-1.first.parent");
        assertThat(category).isVisible();
        assertThat(category).isEnabled();
        category.click();

        Locator subCategory = page.locator("body > div > div > div.main-container.col1-layout > div > div.col-main > ul > li:nth-child(2)");
        assertThat(subCategory).isVisible();
        assertThat(subCategory).isEnabled();
        subCategory.click();

        Locator product = page.locator("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1)");
        assertThat(product).isVisible();
        assertThat(product).isEnabled();
        product.click();

        Locator colorOption = page.locator("#swatch21 > span.swatch-label");
        assertThat(colorOption).isVisible();
        assertThat(colorOption).isEnabled();
        colorOption.click();

        Locator sizeOption = page.locator("#swatch80 > span.swatch-label");
        assertThat(sizeOption).isVisible();
        assertThat(sizeOption).isEnabled();
        sizeOption.click();

        Locator quantityField = page.locator("#qty");
        assertThat(quantityField).isVisible();
        assertThat(quantityField).isEnabled();
        assertThat(quantityField).hasValue("1");
        quantityField.fill("2");
        assertThat(quantityField).hasValue("2");

        Locator addToCartButton = page.locator("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button");
        assertThat(addToCartButton).isVisible();
        assertThat(addToCartButton).isEnabled();
        addToCartButton.click();

        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/checkout/cart/");
        Locator shoppinCartTable = page.locator("#shopping-cart-table tbody tr");
        assertThat(shoppinCartTable).hasCount(1);
    }

    @Test
    void removeProductFromCart()
    {
        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/");

        Locator category = page.locator("#nav > ol > li.level0.nav-1.first.parent");
        assertThat(category).isVisible();
        assertThat(category).isEnabled();
        category.click();

        Locator subCategory = page.locator("body > div > div > div.main-container.col1-layout > div > div.col-main > ul > li:nth-child(2)");
        assertThat(subCategory).isVisible();
        assertThat(subCategory).isEnabled();
        subCategory.click();

        Locator product = page.locator("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1)");
        assertThat(product).isVisible();
        assertThat(product).isEnabled();
        product.click();

        Locator colorOption = page.locator("#swatch21 > span.swatch-label");
        assertThat(colorOption).isVisible();
        assertThat(colorOption).isEnabled();
        colorOption.click();

        Locator sizeOption = page.locator("#swatch80 > span.swatch-label");
        assertThat(sizeOption).isVisible();
        assertThat(sizeOption).isEnabled();
        sizeOption.click();

        Locator quantityField = page.locator("#qty");
        assertThat(quantityField).isVisible();
        assertThat(quantityField).isEnabled();
        assertThat(quantityField).hasValue("1");
        quantityField.fill("2");
        assertThat(quantityField).hasValue("2");

        Locator addToCartButton = page.locator("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button");
        assertThat(addToCartButton).isVisible();
        assertThat(addToCartButton).isEnabled();
        addToCartButton.click();

        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/checkout/cart/");

        Locator shoppinCartTable = page.locator("#shopping-cart-table tbody tr");
        assertThat(shoppinCartTable).hasCount(1);

        page.goBack();
        page.goBack();

        Locator product2 = page.locator("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(3)");
        assertThat(product).isVisible();
        assertThat(product).isEnabled();
        product2.click();


        assertThat(colorOption).isVisible();
        assertThat(colorOption).isEnabled();
        colorOption.click();

        assertThat(sizeOption).isVisible();
        assertThat(sizeOption).isEnabled();
        sizeOption.click();

        assertThat(quantityField).isVisible();
        assertThat(quantityField).isEnabled();
        assertThat(quantityField).hasValue("1");
        quantityField.fill("3");
        assertThat(quantityField).hasValue("3");

        assertThat(addToCartButton).isVisible();
        assertThat(addToCartButton).isEnabled();
        addToCartButton.click();

        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/checkout/cart/");
        assertThat(shoppinCartTable).hasCount(2);

        Locator removeFromCartButton = page.locator("#shopping-cart-table > tbody > tr.first.odd > td.a-center.product-cart-remove.last > a");
        assertThat(removeFromCartButton).isVisible();
        assertThat(removeFromCartButton).isEnabled();
        removeFromCartButton.click();

        assertThat(shoppinCartTable).hasCount(1);
    }

    @Test
    void emptyCart()
    {
        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/");

        Locator category = page.locator("#nav > ol > li.level0.nav-1.first.parent");
        assertThat(category).isVisible();
        assertThat(category).isEnabled();
        category.click();

        Locator subCategory = page.locator("body > div > div > div.main-container.col1-layout > div > div.col-main > ul > li:nth-child(2)");
        assertThat(subCategory).isVisible();
        assertThat(subCategory).isEnabled();
        subCategory.click();

        Locator product = page.locator("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1)");
        assertThat(product).isVisible();
        assertThat(product).isEnabled();
        product.click();

        Locator colorOption = page.locator("#swatch21 > span.swatch-label");
        assertThat(colorOption).isVisible();
        assertThat(colorOption).isEnabled();
        colorOption.click();

        Locator sizeOption = page.locator("#swatch80 > span.swatch-label");
        assertThat(sizeOption).isVisible();
        assertThat(sizeOption).isEnabled();
        sizeOption.click();

        Locator quantityField = page.locator("#qty");
        assertThat(quantityField).isVisible();
        assertThat(quantityField).isEnabled();
        assertThat(quantityField).hasValue("1");
        quantityField.fill("2");
        assertThat(quantityField).hasValue("2");

        Locator addToCartButton = page.locator("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button");
        assertThat(addToCartButton).isVisible();
        assertThat(addToCartButton).isEnabled();
        addToCartButton.click();

        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/checkout/cart/");

        Locator shoppinCartTable = page.locator("#shopping-cart-table tbody tr");
        assertThat(shoppinCartTable).hasCount(1);

        page.goBack();
        page.goBack();

        Locator product2 = page.locator("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(3)");
        assertThat(product).isVisible();
        assertThat(product).isEnabled();
        product2.click();


        assertThat(colorOption).isVisible();
        assertThat(colorOption).isEnabled();
        colorOption.click();

        assertThat(sizeOption).isVisible();
        assertThat(sizeOption).isEnabled();
        sizeOption.click();

        assertThat(quantityField).isVisible();
        assertThat(quantityField).isEnabled();
        assertThat(quantityField).hasValue("1");
        quantityField.fill("3");
        assertThat(quantityField).hasValue("3");

        assertThat(addToCartButton).isVisible();
        assertThat(addToCartButton).isEnabled();
        addToCartButton.click();

        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/checkout/cart/");
        assertThat(shoppinCartTable).hasCount(2);

        Locator emptyCart = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Empty cart"));
        assertThat(emptyCart).isVisible();
        assertThat(emptyCart).isEnabled();

        emptyCart.click();

        assertThat(shoppinCartTable).hasCount(0);
    }

    @Test
    void updateCart()
    {
        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/");

        Locator category = page.locator("#nav > ol > li.level0.nav-1.first.parent");
        assertThat(category).isVisible();
        assertThat(category).isEnabled();
        category.click();

        Locator subCategory = page.locator("body > div > div > div.main-container.col1-layout > div > div.col-main > ul > li:nth-child(2)");
        assertThat(subCategory).isVisible();
        assertThat(subCategory).isEnabled();
        subCategory.click();

        Locator product = page.locator("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1)");
        assertThat(product).isVisible();
        assertThat(product).isEnabled();
        product.click();

        Locator colorOption = page.locator("#swatch21 > span.swatch-label");
        assertThat(colorOption).isVisible();
        assertThat(colorOption).isEnabled();
        colorOption.click();

        Locator sizeOption = page.locator("#swatch80 > span.swatch-label");
        assertThat(sizeOption).isVisible();
        assertThat(sizeOption).isEnabled();
        sizeOption.click();

        Locator quantityField = page.locator("#qty");
        assertThat(quantityField).isVisible();
        assertThat(quantityField).isEnabled();
        assertThat(quantityField).hasValue("1");
        quantityField.fill("2");
        assertThat(quantityField).hasValue("2");

        Locator addToCartButton = page.locator("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button");
        assertThat(addToCartButton).isVisible();
        assertThat(addToCartButton).isEnabled();
        addToCartButton.click();

        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/checkout/cart/");
        Locator shoppinCartTable = page.locator("#shopping-cart-table tbody tr");
        assertThat(shoppinCartTable).hasCount(1);

        Locator updateCart = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Update shopping cart"));
        assertThat(updateCart).isVisible();
        assertThat(updateCart).isEnabled();

        updateCart.click();

        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/checkout/cart/");
    }

    @Test
    void continueShopping()
    {
        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/");

        Locator category = page.locator("#nav > ol > li.level0.nav-1.first.parent");
        assertThat(category).isVisible();
        assertThat(category).isEnabled();
        category.click();

        Locator subCategory = page.locator("body > div > div > div.main-container.col1-layout > div > div.col-main > ul > li:nth-child(2)");
        assertThat(subCategory).isVisible();
        assertThat(subCategory).isEnabled();
        subCategory.click();

        Locator product = page.locator("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1)");
        assertThat(product).isVisible();
        assertThat(product).isEnabled();
        product.click();

        Locator colorOption = page.locator("#swatch21 > span.swatch-label");
        assertThat(colorOption).isVisible();
        assertThat(colorOption).isEnabled();
        colorOption.click();

        Locator sizeOption = page.locator("#swatch80 > span.swatch-label");
        assertThat(sizeOption).isVisible();
        assertThat(sizeOption).isEnabled();
        sizeOption.click();

        Locator quantityField = page.locator("#qty");
        assertThat(quantityField).isVisible();
        assertThat(quantityField).isEnabled();
        assertThat(quantityField).hasValue("1");
        quantityField.fill("2");
        assertThat(quantityField).hasValue("2");

        Locator addToCartButton = page.locator("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button");
        assertThat(addToCartButton).isVisible();
        assertThat(addToCartButton).isEnabled();
        addToCartButton.click();

        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/checkout/cart/");
        Locator shoppinCartTable = page.locator("#shopping-cart-table tbody tr");
        assertThat(shoppinCartTable).hasCount(1);

        Locator continueShopping = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Continue shopping"));
        assertThat(continueShopping).isVisible();
        assertThat(continueShopping).isEnabled();

        continueShopping.click();

        assertThat(page).hasURL(Pattern.compile("http://qa3magento\\.dev\\.evozon\\.com/.+\\.html"));
    }
}
