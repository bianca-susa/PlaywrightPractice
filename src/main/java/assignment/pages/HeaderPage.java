package assignment.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.AriaRole;

import java.time.LocalDate;
import java.util.List;

import static com.microsoft.playwright.assertions.PlaywrightAssertions.assertThat;

public class HeaderPage {
    private Page page;
    private Locator searchField;
    private Locator searchButton;
    private Locator accountButton;
    private Locator accountHeader;
    private Locator logo;
    private Locator welcomeMessage;

    public HeaderPage(Page page)
    {
        this.page = page;
        this.searchField = page.locator("#search");
        this.searchButton = page.getByRole(AriaRole.BUTTON, new Page.GetByRoleOptions().setName("Search"));
        this.accountButton = page.locator("a[data-target-element=\"#header-account\"]");
        this.accountHeader = page.locator("#header-account");
        this.logo = page.locator("a.logo");
        this.welcomeMessage = page.locator(".header-language-container .welcome-msg");
    }

    public void navigate()
    {
        page.navigate("http://qa3magento.dev.evozon.com/");
    }

    public void search(String input)
    {
        searchField.fill(input);
        searchButton.click();
    }

    public String getWelcomeMessage()
    {
        return welcomeMessage.textContent();
    }

    public void clickAccountButton()
    {
        accountButton.click();
    }

    public boolean isHeaderVisible()
    {
        return accountHeader.isVisible();
    }

    public void clickLogo()
    {
        logo.click();
    }

}
