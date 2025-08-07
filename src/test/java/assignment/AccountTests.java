package assignment;

import com.microsoft.playwright.Locator;
import org.junit.jupiter.api.Test;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class AccountTests extends TestSetup{

    @Test
    void account()
    {
        assertThat(page).hasURL("http://qa3magento.dev.evozon.com/");

        Locator headerAccount = page.locator("#header-account");
        Locator accountButton = page.locator("a[data-target-element=\"#header-account\"]");
        assertThat(accountButton).isVisible();
        assertThat(accountButton).isEnabled();

        assertThat(headerAccount).not().isVisible();

        accountButton.click();

        assertThat(headerAccount).isVisible();
    }
}
