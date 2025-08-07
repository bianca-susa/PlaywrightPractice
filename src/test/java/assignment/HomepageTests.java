package assignment;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HomepageTests extends TestSetup{

    @Test
    void homepage()
    {
        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/");

        Locator logo = page.locator("a.logo");
        assertThat(logo).isVisible();
        assertThat(logo).isEnabled();
        logo.click();

        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/");

        page.navigate("http://qa3magento.dev.evozon.com/women.html");
        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/women.html");

        page.goBack();
        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/");
        page.goForward();
        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/women.html");
        page.reload();
        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/women.html");
    }

    @Test
    void newProductsList()
    {
        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/");

        Locator newProducts = page.locator("ul.products-grid.products-grid--max-5-col-widget > li");
        assertThat(newProducts.first()).isVisible();
        assertThat(newProducts).hasCount(5);
        int productCount = newProducts.count();
        System.out.println("Number of products: " + productCount);

        for(Locator product: newProducts.all())
        {
            System.out.println("Product: " + product);
            assertThat(product).isVisible();
            assertThat(product).isEnabled();
        }
    }
}
