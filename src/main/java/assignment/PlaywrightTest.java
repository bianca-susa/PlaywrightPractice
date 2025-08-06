package assignment;

import com.microsoft.playwright.*;

public class PlaywrightTest {

    public static void homepage()
    {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false) );
            Page page = browser.newPage();
            page.navigate("http://qa3magento.dev.evozon.com/");
            System.out.println("2. Page title: " + page.title());
            System.out.println("3. Current URL: " + page.url());

            Locator logo = page.locator("#header > div > a > img.large");
            logo.click();

            page.navigate("http://qa3magento.dev.evozon.com/women.html");

            page.goBack();
            page.goForward();
            page.reload();

            page.close();
        }
    }

    public static void account()
    {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false) );
            Page page = browser.newPage();
            page.navigate("http://qa3magento.dev.evozon.com/");

            Locator acountButton = page.locator("#header > div > div.skip-links > div > a > span.label");
            acountButton.click();

            Locator account = page.getByText("Account");
            System.out.println(account);

            page.close();
        }
    }

    public static void search()
    {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false) );
            Page page = browser.newPage();
            page.navigate("http://qa3magento.dev.evozon.com/");

            Locator searchField = page.locator("#search");
            searchField.clear();
            searchField.fill("woman");

            Locator submitButton = page.locator("#search_mini_form > div.input-box > button");
            submitButton.click();

            page.close();
        }
    }

    public static void newProductsList()
    {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false) );
            Page page = browser.newPage();
            page.navigate("http://qa3magento.dev.evozon.com/");

            Locator newProducts = page.locator("//*[@id=\"top\"]/body/div/div/div[2]/div/div/div[2]/div[2]/div[2]/ul/li");
            int productCount = newProducts.count();
            System.out.println("Number of products: " + productCount);

            for(Locator product: newProducts.all())
            {
                System.out.println("Product: " + product);
            }

            page.close();
        }
    }

    public static void navigation()
    {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false) );
            Page page = browser.newPage();
            page.navigate("http://qa3magento.dev.evozon.com/");

            Locator headlines = page.locator("//*[@id=\"nav\"]/ol/li");
            for(Locator headline: headlines.all())
            {
                System.out.println(headline.innerText());
            }

            Locator sale = page.locator("#nav > ol > li.level0.nav-5.parent");
            sale.click();

            page.close();
        }
    }

    public static void addProductToCart()
    {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false) );
            Page page = browser.newPage();
            page.navigate("http://qa3magento.dev.evozon.com/");

            Locator category = page.locator("#nav > ol > li.level0.nav-1.first.parent");
            category.click();

            Locator subCategory = page.locator("body > div > div > div.main-container.col1-layout > div > div.col-main > ul > li:nth-child(2)");
            subCategory.click();

            Locator product = page.locator("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1)");
            product.click();

            Locator colorOption = page.locator("#swatch21 > span.swatch-label");
            colorOption.click();

            Locator sizeOption = page.locator("#swatch80 > span.swatch-label");
            sizeOption.click();

            Locator quantityField = page.locator("#qty");
            quantityField.fill("2");

            Locator addToCartButton = page.locator("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button");
            addToCartButton.click();

            page.close();
        }
    }

    public static void removeProductFromCart()
    {
        try (Playwright playwright = Playwright.create()) {
            Browser browser = playwright.chromium().launch(
                    new BrowserType.LaunchOptions().setHeadless(false) );
            Page page = browser.newPage();
            page.navigate("http://qa3magento.dev.evozon.com/");

            Locator category = page.locator("#nav > ol > li.level0.nav-1.first.parent");
            category.click();

            Locator subCategory = page.locator("body > div > div > div.main-container.col1-layout > div > div.col-main > ul > li:nth-child(2)");
            subCategory.click();

            Locator product1 = page.locator("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(1)");
            product1.click();

            Locator colorOption = page.locator("#swatch21 > span.swatch-label");
            colorOption.click();

            Locator sizeOption = page.locator("#swatch80 > span.swatch-label");
            sizeOption.click();

            Locator quantityField = page.locator("#qty");
            quantityField.fill("2");

            Locator addToCartButton = page.locator("#product_addtocart_form > div.product-shop > div.product-options-bottom > div.add-to-cart > div.add-to-cart-buttons > button");
            addToCartButton.click();

            page.waitForTimeout(2000);

            page.goBack();
            page.goBack();

            Locator product2 = page.locator("body > div > div > div.main-container.col3-layout > div > div.col-wrapper > div.col-main > div.category-products > ul > li:nth-child(3)");
            product2.click();

            colorOption.click();
            sizeOption.click();

            quantityField.fill("3");

            addToCartButton.click();

            page.waitForTimeout(2000);

            Locator removeFromCartButton = page.locator("#shopping-cart-table > tbody > tr.first.odd > td.a-center.product-cart-remove.last > a");
            removeFromCartButton.click();

            page.close();
        }
    }

    public static void main(String[] args) {
        homepage();
        account();
        search();
        newProductsList();
        navigation();
        addProductToCart();
        removeProductFromCart();
    }
}
