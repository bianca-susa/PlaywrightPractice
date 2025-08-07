package assignment;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HeadlineTests extends TestSetup{

    @Test
    void sale()
    {
        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/");

        Locator headlines = page.locator(".nav-primary");
        assertThat(headlines).isVisible();
        for(Locator headline: headlines.all())
        {
            System.out.println(headline.innerText());
            assertThat(headline).isVisible();
            assertThat(headline).isEnabled();
        }

        Locator sale = page.getByText("Sale", new Page.GetByTextOptions().setExact(true));
        assertThat(sale).isVisible();
        assertThat(sale).isEnabled();
        sale.click();

        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/sale.html");
    }
}
